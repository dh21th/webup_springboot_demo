//package com.webup.soa;
//
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.google.common.net.InetAddresses;
//import org.elasticsearch.action.DocWriteResponse;
//import org.elasticsearch.action.delete.DeleteResponse;
//import org.elasticsearch.action.get.GetResponse;
//import org.elasticsearch.action.index.IndexResponse;
//import org.elasticsearch.action.update.UpdateResponse;
//import org.elasticsearch.client.transport.TransportClient;
//import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.common.transport.InetSocketTransportAddress;
//import org.elasticsearch.common.xcontent.XContentFactory;
//import org.elasticsearch.common.xcontent.XContentType;
//import org.elasticsearch.common.transport.BoundTransportAddress;
//import org.elasticsearch.transport.client.PreBuiltTransportClient;
//import org.junit.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.IOException;
//import java.net.InetAddress;
//import java.net.InetSocketAddress;
//import java.net.UnknownHostException;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Elasticsearch的基本测试   <version>5.6.8</version>
// * @ClassName: ElasticsearchTest1
// * @author sunt
// * @date 2017年11月22日
// * @version V1.0
// */
//public class ElasticsearchTest1 {
//
//    private Logger logger = LoggerFactory.getLogger(ElasticsearchTest1.class);
//
//    public final static String HOST = "10.6.101.50";
//
//    public final static int PORT = 9300;//http请求的端口是9200，客户端是9300
//
//    /**
//     * 测试Elasticsearch客户端连接
//     * @Title: test1
//     * @author sunt
//     * @date 2017年11月22日
//     * @return void
//     * @throws UnknownHostException
//     */
//    @SuppressWarnings("resource")
//    @Test
//    public void test1() throws UnknownHostException {
//
//String index = xxx;
//        String type = xxx;
//// 指定要返回的字段
//        String[] fields = new String[2];
//        fields[0] = "field1"; // 字段1名称
//        fields[1] = "filed2"; // 字段2名称
//// 构造query
//        SearchRequestBuilder requestBuilder = client.prepareSearch(index);
//        requestBuilder .setFrom(0).setSize(100)
//        .setTimeout(TimeValue.timeValueMillis(300))
//        .setTypes(type)
//        .addFields(fields);
//// bool 条件
//        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//        TermQueryBuilder tqb = QueryBuilders.termQuery("field1", "val1");
//        boolQueryBuilder.must(tqb);
//// set query
//        requestBuilder.setQuery(boolQueryBuilder);
//// get response
//        SearchResponse response = requestBuilder.execute().actionGet();
//// 遍历返回的字段
//        SearchHits searchHits = response.getHits();
//        for (SearchHit hit : searchHits) {
//        System.out.println(hit.getFields().get("filed1").getValue().toString());
//        }
//

//String index = xxx;
//        String type = xxx;
//// 指定要返回的字段
//        String[] fields = new String[2];
//        fields[0] = "field1"; // 字段1名称
//        fields[1] = "filed2"; // 字段2名称
//// 构造query
//        SearchRequestBuilder requestBuilder = client.prepareSearch(index);
//        requestBuilder .setFrom(0).setSize(100)
//        .setTimeout(TimeValue.timeValueMillis(300))
//        .setTypes(type)
//        // 指定返回的字段，排除字段设为null
//        .setFetchSource(fields, null);
//// bool 条件
//        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//        TermQueryBuilder tqb = QueryBuilders.termQuery("field1", "val1");
//        boolQueryBuilder.must(tqb);
//// set query
//        requestBuilder.setQuery(boolQueryBuilder);
//// get response
//        SearchResponse response = requestBuilder.execute().actionGet();
//// 遍历返回的字段
//        SearchHits searchHits = response.getHits();
//        for (SearchHit hit : searchHits) {
//// 注意这里和2.x不同的是使用getSource函数
//        System.out.println(hit.getSource().get("filed1"));


////        //创建客户端
////        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
////                .addTransportAddresses(new InetSocketTransportAddress(InetAddress.getByName(HOST),PORT));
//
//        TransportClient client=getClient();
//        logger.debug("Elasticsearch connect info:" + client.toString());
//
//        //关闭客户端
//        client.close();
//    }
//
//    private TransportClient getClient(){
////        Settings settings = Settings.builder().put("cluster.name", "biteniuniu").build(); // 集群名称及Node.name设置
//        Settings settings = Settings.builder().put("cluster.name", "zsy").build(); // 集群名称及Node.name设置
//        //我用6.3.2版本的时候这里一直报异常说找不到InetSocketTransportAddress类，这应该和jar有关，当我改成5.6.8就不报错了
//        TransportClient client = new PreBuiltTransportClient(settings);//6.3.2这里TransportAddress代替InetSocketTransportAddress
//        client.addTransportAddress(new InetSocketTransportAddress(
//                new InetSocketAddress(InetAddresses.forString(HOST), PORT)));
//        return client;
//    }
//    /**
//     * 创建索引库
//     * @Title: addIndex1
//     * @author sunt
//     * @date 2017年11月23日
//     * @return void
//     * 需求:创建一个索引库为：msg消息队列,类型为：tweet,id为1
//     * 索引库的名称必须为小写
//     * @throws IOException
//     */
//    @Test
//    public void addIndex1() throws IOException {
//        TransportClient client=getClient();
//        IndexResponse response = client.prepareIndex("msg", "tweet", "1").setSource(XContentFactory.jsonBuilder()
//                .startObject().field("userName", "张三")
//                .field("sendDate", new Date())
//                .field("msg", "你好李四")
//                .endObject()).get();
//
//        logger.info("索引名称:" + response.getIndex() + "\n类型:" + response.getType()
//                + "\n文档ID:" + response.getId() + "\n当前实例状态:" + response.status());
//        //关闭客户端
//        client.close();
//    }
//    /**
//     * 添加索引:传入json字符串
//     * @Title: addIndex2
//     * @author sunt
//     * @date 2017年11月23日
//     * @return void
//     */
//    @Test
//    public void addIndex2() {
//        TransportClient client=getClient();
//        String jsonStr = "{" +
//                "\"userName\":\"张三\"," +
//                "\"sendDate\":\"2017-11-30\"," +
//                "\"msg\":\"你好李四\"" +
//                "}";
//        IndexResponse response = client.prepareIndex("weixin", "tweet").setSource(jsonStr,XContentType.JSON).get();
//        logger.info("json索引名称:" + response.getIndex() + "\njson类型:" + response.getType()
//                + "\njson文档ID:" + response.getId() + "\n当前实例json状态:" + response.status());
//        //关闭客户端
//        client.close();
//    }
//    /**
//     * 创建索引-传入Map对象
//     * @Title: addIndex3
//     * @author sunt
//     * @date 2017年11月23日
//     * @return void
//     */
//    @Test
//    public void addIndex3() {
//        TransportClient client=getClient();
//        Map<String, Object> map = new HashMap<String,Object>();
//        map.put("userName", "张三3");
//        map.put("sendDate", new Date());
//        map.put("msg", "你好李四3");
//        IndexResponse response = client.prepareIndex("momo", "tweet").setSource(map).get();
//        logger.info("map索引名称:" + response.getIndex() + "\n map类型:" + response.getType()
//                + "\n map文档ID:" + response.getId() + "\n当前实例map状态:" + response.status());
//        //关闭客户端
//        client.close();
//    }
//
//    /**
//     * 传递json对象
//     * 需要添加依赖:gson
//     * @Title: addIndex4
//     * @author sunt
//     * @date 2017年11月23日
//     * @return void
//     */
//    @Test
//    public void addIndex4() {
//        TransportClient client=getClient();
//        JSONObject jsonObject = JSON.parseObject("{\"userName\":\"张三4\",\"sendDate\":\"2017-11-23\",\"msg\":\"你好李四\"}");
//
//        IndexResponse response = client.prepareIndex("qq", "tweet").setSource(jsonObject, XContentType.JSON).get();
//
//        logger.info("jsonObject索引名称:" + response.getIndex() + "\n jsonObject类型:" + response.getType()
//                + "\n jsonObject文档ID:" + response.getId() + "\n当前实例jsonObject状态:" + response.status());
//        // CREATED
//        //关闭客户端
//        client.close();
//    }
//
//    /**
//     * 从索引库获取数据
//     * @Title: getData1
//     * @author sunt
//     * @date 2017年11月23日
//     * @return void
//     */
//    @Test
//    public void getData1() {
//        TransportClient client=getClient();
//        GetResponse getResponse = client.prepareGet("msg", "tweet", "1").get();
//        logger.info("索引库的数据:" + getResponse.getSourceAsString());
//        //关闭客户端
//        client.close();
//    }
//
//    /**
//     * 更新索引库数据
//     * @Title: updateData
//     * @author sunt
//     * @date 2017年11月23日
//     * @return void
//     */
//    @Test
//    public void updateData() {
//        TransportClient client=getClient();
//        JSONObject jsonObject = JSON.parseObject("{\"userName\":\"王五\",\"sendDate\":\"2008-08-08\",\"msg\":\"你好,张三，好久不见\"}");
//
//        UpdateResponse updateResponse = client.prepareUpdate("msg", "tweet", "1")
//                .setDoc(jsonObject.toString(),XContentType.JSON).get();
//
//        logger.info("updateResponse索引名称:" + updateResponse.getIndex() + "\n updateResponse类型:" + updateResponse.getType()
//                + "\n updateResponse文档ID:" + updateResponse.getId() + "\n当前实例updateResponse状态:" + updateResponse.status());
//        // CREATED = OK
//        //关闭客户端
//        client.close();
//    }
//    /**
//     * 根据索引名称，类别，文档ID 删除索引库的数据
//     * @Title: deleteData
//     * @author sunt
//     * @date 2017年11月23日
//     * @return void
//     */
//    @Test
//    public void deleteData() {
//        TransportClient client=getClient();
//        DeleteResponse deleteResponse = client.prepareDelete("msg", "tweet", "2").get();
//
//        logger.info("deleteResponse索引名称:" + deleteResponse.getIndex() + "\n deleteResponse类型:" + deleteResponse.getType()
//                + "\n deleteResponse文档ID:" + deleteResponse.getId() + "\n当前实例deleteResponse状态:" + deleteResponse.status());
//        // DocWriteResponse.Result.DELETED DocWriteResponse.Result.NOT_FOUND
//        //关闭客户端
//        client.close();
//    }
//
//}