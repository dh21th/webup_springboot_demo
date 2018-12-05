package com.webup.user.es.base.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.webup.user.es.base.BaseElasticsearch;
import com.webup.user.es.repositories.Content;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.search.join.ScoreMode;
import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.admin.indices.analyze.AnalyzeRequest;
import org.elasticsearch.action.admin.indices.analyze.AnalyzeResponse;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequestBuilder;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.action.bulk.*;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.get.MultiGetItemResponse;
import org.elasticsearch.action.get.MultiGetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.MultiSearchResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.unit.ByteSizeUnit;
import org.elasticsearch.common.unit.ByteSizeValue;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.*;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryAction;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.histogram.DateHistogramInterval;
import org.elasticsearch.search.aggregations.metrics.sum.Sum;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.SearchQuery;

import java.io.*;
import java.lang.reflect.*;
import java.util.*;

public class AbstractElasticsearch<T, ID extends Serializable> implements BaseElasticsearch<T, ID> {

    private Class tClass;
    private Class idClass;
    private String idName;
    private String documentIndexName,documentType;
    private TransportClient client ;
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    private void getTIDClass() {
        if (null != tClass) {
            return;
        }
        ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        tClass = (Class) actualTypeArguments[0];
        idClass = (Class) actualTypeArguments[1];
        Document[] annotationsByType = Content.class.getAnnotationsByType(Document.class);
        if(annotationsByType.length==0){
            return;
        }
        for (Field field : tClass.getDeclaredFields()) {
            if(field.getAnnotationsByType(Id.class).length>0){
                idName = field.getName();
                break;
            }
        }
        documentIndexName = annotationsByType[0].indexName();
        documentType = annotationsByType[0].type();
        client = (TransportClient)elasticsearchTemplate.getClient();
    }

    @Override
    public boolean addIndex(XContentBuilder mapping) {
        getTIDClass();
        CreateIndexRequestBuilder cib=client.admin().indices().prepareCreate(documentIndexName);
        cib.addMapping(documentType, mapping);
        CreateIndexResponse res=cib.execute().actionGet();
        return true;
    }

    @Override
    public boolean deleteIndex(){
        if(!indexExists()){
            return true;
        }
        client.admin().indices()
                .prepareDelete(documentIndexName)
                .execute().actionGet();
        return !indexExists();
    }

    @Override
    public boolean indexExists() {
        getTIDClass();
        IndicesExistsResponse inExistsResponse = client.admin().indices()
                .exists(new IndicesExistsRequest(documentIndexName))
                .actionGet();
        return inExistsResponse.isExists();
    }

    /**
     *  创建索引并添加文档
     * @throws Exception Exception
     */
    @Override
    public boolean addDocument(T t) throws Exception{
        getTIDClass();
        JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(t));
        XContentBuilder xContentBuilder = XContentFactory.jsonBuilder().startObject();
        for (Field field : jsonObject.getClass().getFields()) {
            xContentBuilder.field(field.getName(),jsonObject.get(field.getName()));
        }
        xContentBuilder.endObject();
        IndexResponse response = client.prepareIndex(documentIndexName, documentType).setSource(xContentBuilder).get();
        System.out.println("添加索引成功,版本号："+response.getVersion());
        return true;
    }

    /**
     * 批量添加索引数据
     * @throws Exception Exception
     */
    @Override
    public boolean bulkAddDocument(List<T> tList) throws Exception {
        getTIDClass();
        BulkRequestBuilder bulkRequest = client.prepareBulk();
        // either use client#prepare, or use Requests# to directly build index/delete requests
        for (T t : tList) {
//            XContentBuilder xContentBuilder = XContentFactory.jsonBuilder().startObject();
//            JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(t));
//            for (Field field : jsonObject.getClass().getFields()) {
//                xContentBuilder.field(field.getName(),jsonObject.get(field.getName()));
//            }
//            xContentBuilder.endObject();
//            bulkRequest.add(client.prepareIndex(documentIndexName, documentType, jsonObject.getString(idName)).setSource(xContentBuilder));
            bulkRequest.add(new IndexRequest(documentIndexName, documentType, String.valueOf(getFieldValueByName(t,idName))).source(JSON.toJSONString(t)));
            //添加到builder中 手动 批量更新
//            bulkRequest.add(client.prepareIndex(documentIndexName, documentType).setSource(JSON.toJSONString(t)).setId(String.valueOf(getFieldValueByName(t,idName))));
        }
//        手动 批量更新
//        BulkResponse bulkResponse = bulkRequest.execute().actionGet();
        BulkResponse bulkResponse = bulkRequest.get();
        if (bulkResponse.hasFailures()) {
            System.out.println(bulkResponse.buildFailureMessage());
        }
        return !bulkResponse.hasFailures();
    }

    /**设置自动提交文档
     * BulkProcessor
     * @throws Exception Exception
     */
    @Override
    public boolean autoBulkAddDocument(List<T> tList) throws Exception {
        getTIDClass();
        BulkProcessor bulkProcessor = BulkProcessor.builder(client,
                new BulkProcessor.Listener() {
                    @Override
                    public void beforeBulk(long executionId, BulkRequest request) {
                        //提交前调用
                    }
                    @Override
                    public void afterBulk(long executionId, BulkRequest request, BulkResponse response) {
                        //提交结束后调用（无论成功或失败）
                        System.out.println( "提交" + response.getItems().length + "个文档，用时"+ response.getIngestTookInMillis() + "MS" + (response.hasFailures() ? " 有文档提交失败！" : ""));
                    }
                    @Override
                    public void afterBulk(long executionId, BulkRequest request, Throwable failure) {
                        //提交结束且失败时调用
                        System.out.println( " 有文档提交失败！after failure=" + failure);
                    }
                })
                // 当请求超过10000个（default=1000）或者总大小超过1GB（default=5MB）时，触发批量提交动作。
                // 文档数量达到1000时提交
                .setBulkActions(10000)
                // 总文档体积达到5MB时提交
                .setBulkSize(new ByteSizeValue(5, ByteSizeUnit.MB))
                // 每5S提交一次（无论文档数量、体积是否达到阈值）
                .setFlushInterval(TimeValue.timeValueSeconds(5))
                // 加1后为可并行的提交请求数，即设为0代表只可1个请求并行，设为1为2个并行
                .setConcurrentRequests(1)
                .setBackoffPolicy(BackoffPolicy.exponentialBackoff(TimeValue.timeValueMillis(100), 3))
                .build();

        //提交单个
        //String json = "{\"id\":\"66\",\"author\":\"ckse\",\"title\":\"windows编程\",\"content\":\"windows 32 API编程\",\"price\":\"99\",\"view\":\"222\",\"date\":\"2017-08-01 17:21:18\"}";
        //bulkProcessor.add(new IndexRequest("设置的index name", "设置的type name","要插入的文档的ID").source(json));//添加文档，以便自动提交
        for (T t : tList) {
            // 添加文档，以便自动提交
            bulkProcessor.add(new IndexRequest(documentIndexName, documentType, String.valueOf(getFieldValueByName(t,idName))).source(JSON.toJSONString(t)));
        }
        return true;
    }

    @Override
    public void importBulk(String absFileName){
        getTIDClass();
        FileReader fr = null;
        BufferedReader bfr = null;
        try {
            File file = new File(absFileName);
            fr=new FileReader(file);
            bfr=new BufferedReader(fr);
            BulkRequestBuilder bulkRequest=client.prepareBulk();
            int count=0;
            String line;
            while((line=bfr.readLine())!=null){
                bulkRequest.add(client.prepareIndex(documentIndexName, documentType).setSource(line));
                if (count%10==0) {
                    bulkRequest.execute().actionGet();
                }
                count++;
            }
            bulkRequest.execute().actionGet();
            System.out.println("导入成功!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                bfr.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void exportBulk(String absFileName) throws Exception{
        getTIDClass();
        QueryBuilder queryBuilder = QueryBuilders.matchAllQuery();
        SearchResponse response = client.prepareSearch(documentIndexName).setQuery(queryBuilder).get();
        SearchHits resultHits = response.getHits();
        System.out.println(JSONObject.toJSON(resultHits));
        FileWriter fw=null;
        BufferedWriter bfw =null;
        try {
            File file = new File(absFileName);
            fw = new FileWriter(file);
            bfw = new BufferedWriter(fw);
            if (resultHits.getHits().length == 0) {
                System.out.println("查到0条数据!");
                return;
            }
            for (int i = 0; i < resultHits.getHits().length; i++) {
                String jsonStr = resultHits.getHits()[i].getSourceAsString();
                System.out.println(jsonStr);
                bfw.write(jsonStr);
                bfw.write("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                bfw.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public T getById(ID id) {
        getTIDClass();
        GetResponse response = client.prepareGet(documentIndexName, documentType,String.valueOf(id)).execute().actionGet();
        Map<String,Object> map = response.getSourceAsMap();
        return null==map ? null : mapToClass(map);
    }

    @Override
    public boolean deleteById(ID id){
        getTIDClass();
        DeleteResponse dResponse = client.prepareDelete(documentIndexName, documentType, String.valueOf(id)).execute().actionGet();
        return RestStatus.OK.equals(dResponse.status()) || RestStatus.NOT_FOUND.equals(dResponse.status());
    }

    @Override
    public long deleteByQuery(List<QueryBuilder> queryBuilders) {
        getTIDClass();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        for (QueryBuilder queryBuilder : queryBuilders) {
            boolQueryBuilder.must(queryBuilder);
        }
        BulkByScrollResponse bulkResponse = DeleteByQueryAction.INSTANCE.newRequestBuilder(client).source(documentIndexName)
            .filter(boolQueryBuilder.must(QueryBuilders.typeQuery(documentType)))
            .get();
        return bulkResponse.getDeleted();
    }

    @Override
    public void deleteAll(){
        getTIDClass();
        DeleteByQueryAction.INSTANCE.newRequestBuilder(client)
           .source(documentIndexName)
           .filter(QueryBuilders.matchAllQuery())
           .get();
    }

    /**
     * bulk批量通过指定id删除方法
     */
    @Override
    public boolean deleteByIds(List<ID> ids) {
        getTIDClass();
        BulkRequestBuilder builder=client.prepareBulk();
        for(ID id : ids){
            builder.add(client.prepareDelete(documentIndexName, documentType, String.valueOf(id)).request());
        }
        BulkResponse bulkResponse = builder.get();
        return RestStatus.OK.equals(bulkResponse.status());
    }

    @Override
    public boolean updateDocument(T t) throws Exception{
        getTIDClass();
        UpdateRequest updateRequest = new UpdateRequest();
        updateRequest.index(documentIndexName);
        updateRequest.type(documentType);
        JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(t));
        updateRequest.id(String.valueOf(jsonObject.get(idName)));
        XContentBuilder xContentBuilder = XContentFactory.jsonBuilder().startObject();
        for (Field field : jsonObject.getClass().getFields()) {
            xContentBuilder.field(field.getName(),jsonObject.get(field.getName()));
        }
        xContentBuilder.endObject();
        updateRequest.doc(xContentBuilder);
        UpdateResponse response = client.update(updateRequest).get();
        return RestStatus.CREATED.equals(response.status());
    }

    @Override
    public boolean prepareUpdateDocument(T t) throws Exception {
        getTIDClass();
        XContentBuilder xContentBuilder = XContentFactory.jsonBuilder().startObject();
        JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(t));
        for (Field field : jsonObject.getClass().getFields()) {
            xContentBuilder.field(field.getName(),jsonObject.get(field.getName()));
        }
        xContentBuilder.endObject();
        UpdateResponse response = client.prepareUpdate(documentIndexName, documentType, String.valueOf(jsonObject.get(idName))).setDoc(xContentBuilder).get();
        System.out.println(response.getVersion());
        return RestStatus.CREATED.equals(response.status());
    }

    @Override
    public List<T> search(QueryBuilder queryBuilder, SortBuilder sort){
        getTIDClass();
        SearchRequestBuilder searchRequestBuilder = elasticsearchTemplate.getClient().prepareSearch(documentIndexName).setTypes(documentType).setQuery(queryBuilder);
        if(null!=sort){
            searchRequestBuilder.addSort(sort);
        }
        SearchResponse response = searchRequestBuilder.get();
        List<T> list = new ArrayList<>();
        for (SearchHit searchHit : response.getHits()) {
            list.add( mapToClass(searchHit.getSourceAsMap()) );
        }
        return list;
    }

    @Override
    public Page<T> searchOfPage(QueryBuilder queryBuilder, Pageable pageable) {
        return null;
    }

    @Override
    public Page<T> searchOfPage(SearchQuery queryBuilder) {
        return null;
    }

    @Override
    public Page<T> searchSimilar(T obj, String[] key, Pageable pageable) {
        return null;
    }

    @Override
    public void refresh() {

    }

    @Override
    public Class<T> getEntityClass() {
        return tClass;
    }

    @Override
    public List<T> findAll(SortBuilder sort) {
        QueryBuilder queryBuilder = QueryBuilders.matchAllQuery();
        return search(queryBuilder, sort);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return null;
    }


    /**
     * 根据属性名获取属性值
     * */
    private Object getFieldValueByName( Object o, String fieldName) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[] {});
            Object value = method.invoke(o, new Object[] {});
            return value;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * map 转换 对象
     * @param map map
     * @return T
     */
    private T mapToClass(Map<String,Object> map){
        if(null==map){
            return null;
        }
        getTIDClass();
        return (T)JSON.parseObject(JSON.toJSONString(map), tClass);
    }







    @Override
    public List<T> spanQuery(){
        getTIDClass();
//        SpanTermQuery                和其他跨度查询结合使用，单独使用相当于TermQuery
//        SpanFirstQuery               用来匹配域中的第一个部分内的各个spans
//        SpanNearQuery                用来匹配临近的spans
//        SpanNotQuery                 用来匹配不重叠的spans
//        SpanOrQuery                  span查询的聚合匹配

        MatchQueryBuilder matchQuery = QueryBuilders.matchQuery("title","JAVA编程思想");
        matchQuery.fuzziness(Fuzziness.AUTO);

        MultiMatchQueryBuilder multiMatchQueryBuilder = QueryBuilders.multiMatchQuery("JAVA编程思想","title", "content");
        multiMatchQueryBuilder.analyzer("standard");
        multiMatchQueryBuilder.cutoffFrequency(0.001f);
        multiMatchQueryBuilder.field("title",20);
        multiMatchQueryBuilder.fuzziness(Fuzziness.TWO);
        multiMatchQueryBuilder.maxExpansions(100);
        multiMatchQueryBuilder.prefixLength(10);
        multiMatchQueryBuilder.tieBreaker(20);
        multiMatchQueryBuilder.type(MultiMatchQueryBuilder.Type.BEST_FIELDS);
        multiMatchQueryBuilder.boost(20);

        QueryBuilder rangeQuery = QueryBuilders.rangeQuery("price")
                .from(1)
                .to(100)
                .includeLower(false)
                .includeUpper(false);
        // A simplified form using gte, gt, lt or lte
        QueryBuilder _qb = QueryBuilders.rangeQuery("price")
                .gte("10")
                .lt("20");

        // 通配符
        QueryBuilder wildcardQuery = QueryBuilders.wildcardQuery("author", "*e");
        // 使用模糊查询匹配文档的查询
        QueryBuilder fuzzyQuery = QueryBuilders.fuzzyQuery("author","e" );
        // 匹配与其他查询的布尔组合匹配的文档的查询
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery()
                .should(QueryBuilders.termQuery("author","eeee")).boost(100) //设置此查询的权重。 匹配此查询的文件（除正常权重之外）的得分乘以提供的提升。
                .should(QueryBuilders.termQuery("id","AV5NF_Dbhqf-jFOFkksT").boost(1));
        QueryBuilder boolQuery = QueryBuilders.boolQuery()
                .must(QueryBuilders.termQuery("author", "eeee"))
                .must(QueryBuilders.termQuery("title", "JAVA思想"))
                // 添加不得出现在匹配文档中的查询。
                .mustNot(QueryBuilders.termQuery("content", "C++"))
                // 添加应该与返回的文档匹配的子句。 对于具有no的布尔查询,子句必须一个或多个SHOULD子句且必须与文档匹配,用于布尔值查询匹配。 不允许null值。
                .should(QueryBuilders.termQuery("id", "AV5NF_Dbhqf-jFOFkksT"))
                // 添加一个查询，必须出现在匹配的文档中，但会不贡献得分。 不允许null值。
                .filter(QueryBuilders.termQuery("price", "30.3"));
        QueryBuilder boostingQuery = QueryBuilders.boostingQuery(
                QueryBuilders.termQuery("id","AV5NF_Dbhqf-jFOFkksR"),
                QueryBuilders.termQuery("title","C"))
                // 设置负增强因子。
                .negativeBoost(0.2f);
        QueryBuilder constantScoreQuery = QueryBuilders.constantScoreQuery(
                QueryBuilders.termQuery("title","C")
        ).boost(2.0f);
        QueryBuilder disMaxQuery = QueryBuilders.disMaxQuery()
                .add(QueryBuilders.termQuery("id", "512"))
                .add(QueryBuilders.termQuery("author", "ckse"))
                .boost(1.2f)
                .tieBreaker(0.7f);

        FunctionScoreQueryBuilder.FilterFunctionBuilder[] functions = {
                new FunctionScoreQueryBuilder.FilterFunctionBuilder(
                        QueryBuilders.matchQuery("id", "512"),
                        ScoreFunctionBuilders.randomFunction()), //" ABCDEF"
                new FunctionScoreQueryBuilder.FilterFunctionBuilder(
                        ScoreFunctionBuilders.exponentialDecayFunction("age", 0L, 1L))
        };
        QueryBuilder functionScoreQuery = QueryBuilders.functionScoreQuery(functions);
        QueryBuilder regexpQuery = QueryBuilders.regexpQuery("title","*J");
        QueryBuilder typeQuery = QueryBuilders.typeQuery("data");
        QueryBuilder idsQuery = QueryBuilders.idsQuery(documentType).addIds("512", "520", "531");
//        SearchResponse response=client.prepareSearch().setQuery(qb).execute().actionGet();

        QueryBuilder termQuery = QueryBuilders.termQuery("id","11");
        QueryBuilder queryBuilder = QueryBuilders.termsQuery("id","1","2");
        QueryBuilder multiMatchQuery = QueryBuilders.multiMatchQuery("JAVA编程思想","title", "content");
        QueryBuilder commonTermsQuery = QueryBuilders.commonTermsQuery("id","1");
        QueryBuilder queryStringQuery = QueryBuilders.queryStringQuery("*:*");
        QueryBuilder existsQuery = QueryBuilders.existsQuery("id");
        // 匹配含有id字段的记录
        QueryBuilder simpleQueryStringQuery = QueryBuilders.simpleQueryStringQuery("+id:1");
        // 匹配分词前缀 如果字段没分词，就匹配整个字段前缀
        QueryBuilder prefixQuery = QueryBuilders.prefixQuery("title","192.138");


        QueryBuilder spanFirstQuery = QueryBuilders.spanFirstQuery(QueryBuilders.spanTermQuery("title", "C"), 30000);

        QueryBuilder spanNearQuery = QueryBuilders.spanNearQuery(QueryBuilders.spanTermQuery("title", "C"),1000)
                .addClause(QueryBuilders.spanTermQuery("name", "葫芦7139娃"));

        QueryBuilder spanNotQuery = QueryBuilders.spanNotQuery(QueryBuilders.spanTermQuery("title", "C"), QueryBuilders.spanTermQuery("title", "C1"));

        QueryBuilder spanOrQuery = QueryBuilders.spanOrQuery(QueryBuilders.spanTermQuery("title", "C"));

        return search(spanFirstQuery, null);
    }


    /**
     * MultiGetResponse  查询多个xxx的值
     * <a href='https://www.elastic.co/guide/en/elasticsearch/client/java-api/5.5/java-docs-multi-get.html'>
     * @throws Exception
     */
    @Override
    public List<T> multiGetResponse() throws Exception {
        MultiGetResponse multiGetItemResponses = client.prepareMultiGet()
                .add(documentIndexName, documentType, "526")
                .add(documentIndexName, documentType, "572", "582", "613")
                .get();
        List<T> list = new ArrayList<>();
        for (MultiGetItemResponse itemResponse : multiGetItemResponses) {
            GetResponse response = itemResponse.getResponse();
            if (response.isExists()) {
                list.add(mapToClass(response.getSourceAsMap()));
            }
        }
        return list;
    }



    /**
     * MatchPhrasePrefixQueryBuilder  为提供的字段名称和文本创建一个类型为“PHRASE_PREFIX”的匹配查询。
     * @throws Exception
     */
    @Override
    public List<T> matchPhrasePrefixQueryBuilder() throws Exception {
        String key = "C++";
        MatchPhrasePrefixQueryBuilder matchPhrasePrefixQueryBuilder = QueryBuilders.matchPhrasePrefixQuery("title",key);
        matchPhrasePrefixQueryBuilder.boost(10);
        matchPhrasePrefixQueryBuilder.analyzer("standard");
        matchPhrasePrefixQueryBuilder.slop(2);
        matchPhrasePrefixQueryBuilder.maxExpansions(100);
        return search(matchPhrasePrefixQueryBuilder,null);
    }


    /**
     * group 分组查询
     */
    public void group(){


    }

//    /**
//     * Aggregation
//     */
//    public void Aggregation()
//    {
//
//        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//        //添加时间范围过滤
//        boolQueryBuilder.must(QueryBuilders.rangeQuery("@timestamp").format("yyyy-MM-dd HH:mm:ss").gte("").lte(""));
//        AggregationBuilder aggregationBuilder = AggregationBuilders
//                //terms(查询字段别名).field(分组字段)
//                .terms("").field("")
//                .order(Terms.Order.aggregation("", false))
//                .size(10)
//                .subAggregation(AggregationBuilders.count("").field(""));
//        SearchRequestBuilder searchRequestBuilder = client.prepareSearch("article").setTypes("articledate")
//                .setQuery(boolQueryBuilder)
//                .addAggregation(aggregationBuilder)
//                .setSize(0);
//
//        SearchResponse sr = searchRequestBuilder.execute().actionGet();
//        Terms genders = sr.getAggregations().get("");//统计字段别名
//        for (Terms.Bucket entry : genders.getBuckets())
//        {
//            System.out.println((String) entry.getKey()+"-("+entry.getDocCount()+")");
//        }
//
//
//        //如想group by 时间，并且按天来进行分组
//        AggregationBuilder aggregation = AggregationBuilders
//                .dateHistogram("agg")
//                .field("@timestamp")
//                .format("yyyy-MM-dd")
//                .dateHistogramInterval(DateHistogramInterval.DAY);
//        //可能有新需求，group by 时间，姓名
//        //AggregationBuilder nameAgg = AggregationBuilders.terms(姓名别名).field(姓名).size(10);
//        //aggregation.subAggregation(nameAgg);
//
//        //可以能需要进行名称统计，但是需要distinct
//        //aggregation.subAggregation(AggregationBuilders.cardinality(别名).field(姓名))
//
//        //其他如下
////        （1）统计某个字段的数量
////        ValueCountBuilder vcb=  AggregationBuilders.count("count_uid").field("uid");
////      （2）去重统计某个字段的数量（有少量误差）
////       CardinalityBuilder cb= AggregationBuilders.cardinality("distinct_count_uid").field("uid");
////      （3）聚合过滤
////      FilterAggregationBuilder fab= AggregationBuilders.filter("uid_filter").filter(QueryBuilders.queryStringQuery("uid:001"));
////      （4）按某个字段分组
////      TermsBuilder tb=  AggregationBuilders.terms("group_name").field("name");
////      （5）求和
////      SumBuilder  sumBuilder= AggregationBuilders.sum("sum_price").field("price");
////      （6）求平均
////      AvgBuilder ab= AggregationBuilders.avg("avg_price").field("price");
////      （7）求最大值
////      MaxBuilder mb= AggregationBuilders.max("max_price").field("price");
////      （8）求最小值
////      MinBuilder min= AggregationBuilders.min("min_price").field("price");
////      （9）按日期间隔分组
////      DateHistogramBuilder dhb= AggregationBuilders.dateHistogram("dh").field("date");
////      （10）获取聚合里面的结果
////      TopHitsBuilder thb=  AggregationBuilders.topHits("top_result");
////      （11）嵌套的聚合
////      NestedBuilder nb= AggregationBuilders.nested("negsted_path").path("quests");
////      （12）反转嵌套
////      AggregationBuilders.reverseNested("res_negsted").path("kps ");
//
//
//    }


    /**
     * MultiSearchResponse 多字段检索
     */
    @Override
    public void multiSearchResponse(){
        SearchRequestBuilder srb1 = client.prepareSearch().setQuery(QueryBuilders.queryStringQuery("JAVA"));
        SearchRequestBuilder srb2 = client.prepareSearch().setQuery(QueryBuilders.matchQuery("title", "C"));
        MultiSearchResponse sr = client.prepareMultiSearch().add(srb1).add(srb2).get();
        for (MultiSearchResponse.Item item : sr.getResponses()) {
            SearchResponse response = item.getResponse();
            for (SearchHit searchHit : response.getHits()) {
                println(searchHit);
            }
        }
    }




    /**
     * 复杂查询
     */
    @Override
    public void complexSearch1(){
        int page=1;
        int pageSize=10;
        String keyword="";

        BoolQueryBuilder boolQueryBuilder=QueryBuilders.boolQuery();

        if(keyword!=null&&!keyword.equals("")){
            QueryBuilder nameBuilder=QueryBuilders.matchQuery("zuName", keyword).analyzer("ik_max_word").boost(10);
            QueryBuilder labelBuilder=QueryBuilders.matchQuery("zuLabelName", keyword).analyzer("ik_max_word").boost(10);
            QueryBuilder categoryBuilder=QueryBuilders.matchQuery("categoryName", keyword).analyzer("ik_max_word").boost(10);
            boolQueryBuilder.should(nameBuilder).should(labelBuilder).should(categoryBuilder);
        }else{
            boolQueryBuilder.must(QueryBuilders.matchAllQuery());
        }
        SearchResponse response=client.prepareSearch("article").setTypes("articledate")
                .setQuery(boolQueryBuilder)
                .setFrom((page-1)*pageSize).setSize(pageSize)
                .setExplain(true)
                .get();

        SearchHits hits=response.getHits();
    }

    /**
     * 复杂查询2
     */
    @Override
    public void complexSearch2(){
        String relatedValue="fendo";
        String userId="1234";
        int page=1;
        int pageSize=10;

        BoolQueryBuilder builders=new BoolQueryBuilder();
        //加上条件
        builders.must(QueryBuilders.termQuery("userId", userId));
        if(relatedValue=="fendo"){
            builders.must(QueryBuilders.nestedQuery("related4ZuValue",
                    QueryBuilders.boolQuery()
                            .must(QueryBuilders.termQuery("related4ZuValue.nameValue", ""))
                    //.must(QueryBuilders.rangeQuery("endTime").lte(LongformStringDate(System.currentTimeMillis())))
                    ,ScoreMode.None));
        }else{
            builders.must(QueryBuilders.nestedQuery("related4ZuValue", QueryBuilders.termQuery("related4ZuValue.nameValue", ""),
                    ScoreMode.None));
        }
        SearchResponse response=client.prepareSearch("article").setTypes("articledate")
                .setQuery(builders).setFrom((page-1)*pageSize)
                .setSize(pageSize)
                .get();
        SearchHits hits=response.getHits();
    }


    /**
     * 取查询结果总和count
     */
    @Override
    public void countSum() {

        int relatedValue=1;
        String userId="111";
        BoolQueryBuilder builders=new BoolQueryBuilder();
        builders.must(QueryBuilders.termQuery("userId", userId));
        if(relatedValue==1){
            builders.must(QueryBuilders.nestedQuery("related4ZuValue",QueryBuilders.boolQuery()
                            .must(QueryBuilders.termQuery("related4ZuValue.nameValue", "123"))
                            .must(QueryBuilders.rangeQuery("endTime").lte(""))
                    ,ScoreMode.None));

        }else{
            builders.must(QueryBuilders.nestedQuery("related4ZuValue", QueryBuilders.termQuery("related4ZuValue.nameValue", "111"),
                    ScoreMode.None));
        }
        SearchResponse response=client.prepareSearch("article").setTypes("articledate")
                .setQuery(builders)
                .setSize(1)
                .get();
        SearchHits hits=response.getHits();
        System.out.println(hits.getTotalHits());
    }



    /**
     * 聚合求和sum
     */
    @Override
    public void getPlatformZuOrdersTotalAmount() {

        String keyword="";
        String startTime="";
        String endTime="";

        BoolQueryBuilder boolQueryBuilder=QueryBuilders.boolQuery();
        if(keyword==null||keyword.equals("")){
            QueryBuilder queryBuilder=QueryBuilders.matchAllQuery();
            boolQueryBuilder.must(queryBuilder);
        }else{
            QueryBuilder zuNameBuilder=QueryBuilders.matchQuery("zuName", keyword);
            QueryBuilder buyerNameBuilder=QueryBuilders.matchQuery("buyerName", keyword);
            QueryBuilder sellerNameBuilder=QueryBuilders.matchQuery("sellerName", keyword);
            boolQueryBuilder.should(zuNameBuilder).should(buyerNameBuilder).should(sellerNameBuilder);

        }
        if(!startTime.equals("")){
            QueryBuilder addTimeBuilder=QueryBuilders.rangeQuery("addTime").from(startTime).to(endTime);
            boolQueryBuilder.must(addTimeBuilder);
        }
        SearchResponse response=client.prepareSearch("article").setTypes("articledate")
                .setQuery(boolQueryBuilder)
                .addAggregation(AggregationBuilders.sum("price").field("price"))
                .get();
        Sum sum=response.getAggregations().get("price");
        System.out.println(sum.getValue());
    }


    /**
     * ---------------------------分页
     */

    /**
     * 使用Scroll方法分页
     */
    @Override
    public void queryPageScroll(){
        QueryBuilder qb = QueryBuilders.termQuery("id", "1");
        SearchResponse scrollResp = client.prepareSearch("article")
                .addSort(FieldSortBuilder.DOC_FIELD_NAME, SortOrder.ASC)
                .setScroll(new TimeValue(60000))
                .setQuery(qb)
                .setSize(1).get();
        do {
            for (SearchHit hit : scrollResp.getHits().getHits()) {
                println(hit);
            }
            scrollResp = client.prepareSearchScroll(scrollResp.getScrollId()).setScroll(new TimeValue(60000)).execute().actionGet();
        } while(scrollResp.getHits().getHits().length != 0);
    }


    /**
     * 分页
     * @throws Exception
     */
    @Override
    public void fenye() throws Exception {
        SearchResponse response = client.prepareSearch("article")
                .setQuery(QueryBuilders.matchAllQuery())
                .setFrom(10)
                .setSize(20)
                .execute().actionGet();
        for (SearchHit searchHit : response.getHits()) {
            println(searchHit);
        }

    }


    /**
     * 高亮
     * @throws Exception
     */
    @Override
    public void highlighter() throws Exception{
        QueryBuilder matchQuery = QueryBuilders.matchQuery("author", "fendo");
        HighlightBuilder hiBuilder=new HighlightBuilder();
        hiBuilder.preTags("<h2>");
        hiBuilder.postTags("</h2>");
        hiBuilder.field("author");
        // 搜索数据
        SearchResponse response = client.prepareSearch(documentIndexName)
                .setQuery(matchQuery)
                .highlighter(hiBuilder)
                .execute().actionGet();
        for (SearchHit searchHit : response.getHits()) {
            println(searchHit);
        }
    }





    /**
     * ---------------------------分词器
     */

    /**
     * AnalyzeRequest 分词器
     * <a href='https://www.elastic.co/guide/cn/elasticsearch/guide/current/standard-tokenizer.html'>
     * @throws Exception
     */
    @Override
    public void analyzeRequest() throws Exception {
        AnalyzeRequest analyzeRequest = new AnalyzeRequest();
        analyzeRequest.text("My œsophagus caused a débâcle");
        /**
         * whitespace （空白字符）分词器按空白字符 —— 空格、tabs、换行符等等进行简单拆分
         * letter 分词器 ，采用另外一种策略，按照任何非字符进行拆分
         * standard 分词器使用 Unicode 文本分割算法
         */
        analyzeRequest.addTokenFilter("standard");
        analyzeRequest.addCharFilter("asciifolding");
        ActionFuture<AnalyzeResponse> analyzeResponseActionFuture =  client.admin().indices().analyze(analyzeRequest);
        List<AnalyzeResponse.AnalyzeToken> analyzeTokens =  analyzeResponseActionFuture.actionGet().getTokens();
        for (AnalyzeResponse.AnalyzeToken analyzeToken : analyzeTokens){
            System.out.println(analyzeToken.getTerm());
        }
    }

//    /**
//     * IK分词器
//     * @param args
//     * @throws IOException
//     */
//    public  void iKAnalyzer(String []args) throws IOException {
//        Settings settings  = Settings.EMPTY;
//        IKAnalyzer analyzer = new IKAnalyzer();
//        String text = "中华人民共和国国歌";
//        StringReader stringReader = new StringReader(text);
//        TokenStream tokenStream = analyzer.tokenStream("",stringReader);
//        tokenStream.reset();
//        CharTermAttribute term=tokenStream.getAttribute(CharTermAttribute.class);
//        while(tokenStream.incrementToken()){
//            System.out.print(term.toString()+"—");
//        }
//        stringReader.close();
//        tokenStream.close();
//    }

    /**
     * 输出结果SearchResponse
     * @param response
     */
    public static void println(SearchResponse response){
        System.err.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
        System.err.println(
                "getFailedShards : " + response.getFailedShards() + "\n" +
                        "getNumReducePhases : " + response.getNumReducePhases() + "\n" +
                        "getScrollId : " + response.getScrollId() +  "\n" +
//                        "getTookInMillis : " + response.getTookInMillis() + "\n" +
                        "getTotalShards : " + response.getTotalShards() +  "\n" +
                        "getAggregations : " + response.getAggregations() + "\n" +
                        "getProfileResults : " + response.getProfileResults() + "\n" +
                        "getShardFailures : " + response.getShardFailures() + "\n" +
                        "getSuggest : " + response.getSuggest() + "\n" +
                        "getTook : " + response.getTook() + "\n" +
                        "isTerminatedEarly : " + response.isTerminatedEarly() + "\n" +
                        "isTimedOut : " + response.isTimedOut() + "\n" +
                        "remoteAddress : " + response.remoteAddress() + "\n" +
                        "status : " + response.status() + "\n" +
                        "getHits : " + response.getHits()
        );
    }

    /**
     * 输出结果SearchResponse
     * @param searchHit searchHit
     */
    public static void println(SearchHit searchHit){
        System.err.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
        System.err.println(
                "docId : " + searchHit.docId() + "\n" +
                        "getId : " + searchHit.getId() + "\n" +
                        "getIndex : " + searchHit.getIndex()+ "\n" +
                        "getScore : " + searchHit.getScore() + "\n" +
                        "getSourceAsString : " + searchHit.getSourceAsString() + "\n" +
                        "getType : " + searchHit.getType() + "\n" +
                        "getVersion : " + searchHit.getVersion() + "\n" +
                        "fieldsOrNull : " + searchHit.fieldsOrNull() + "\n" +
                        "getExplanation : " + searchHit.getExplanation() + "\n" +
                        "getFields : " + searchHit.getFields() + "\n" +
                        "highlightFields : " + searchHit.getHighlightFields() + "\n" +
                        "hasSource : " + searchHit.hasSource()
        );
    }

}
