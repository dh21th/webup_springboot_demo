package com.webup.user.es.service.impl;

import com.webup.user.es.base.impl.AbstractElasticsearch;
import com.webup.user.es.repositories.Content;
import com.webup.user.es.service.ContentService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Slf4j
@Service("ContentService")
public class ContentServiceImpl extends AbstractElasticsearch<Content, Long> implements ContentService {


}
////    @Autowired
//    ContentRepository contentRepository;
////    @Autowired
//    ElasticsearchTemplate elasticsearchTemplate;
//
//    int PAGE_SIZE = 15; //默认分页大小
//
//    int PAGE_NUMBER = 0; //默认当前分页
//
//    String SCORE_MODE_SUM = "sum"; //权重分求和模式
//
//    Float MIN_SCORE = 10.0F; //由于无相关性的分值默认为1， 设置权重分最小值为10
//
//
//    /**
//     * 保存内容到ES
//     */
//    @Override
//    public boolean save(Content content) {
//        Content contentResult = contentRepository.save(content);
//        return true;
//    }
//
//    @Override
//    public boolean modify(Content content) {
//        if(null==content.getId() || !contentRepository.existsById(content.getId())){
//            return false;
//        }
//        Content contentResult = contentRepository.save(content);
//        return true;
//    }
//
//    @Override
//    public boolean deleteById(Long id) {
//        if(!contentRepository.existsById(id)){
//            return false;
//        }
//        contentRepository.deleteById(id);
//        return true;
//    }
//
//    @Override
//    public Long selectById(Long id) {
//        contentRepository.findById(id);
//        return null;
//    }
//
//
//    /**
//     * 在ES中搜索内容
//     */
//    @Override
//    public List<Content> search(int pageNumber, int pageSize, String searchContent){
//        if(pageSize==0) {
//            pageSize = PAGE_SIZE;
//        }
//        if(pageNumber<0) {
//            pageNumber = PAGE_NUMBER;
//        }
//        String queryString = "springboot";//搜索关键字
//        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(queryString);
//        Iterable<Content> searchResult = contentRepository.search(builder);
//        Iterator<Content> iterator = searchResult.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//
//
//
//        Client client = elasticsearchTemplate.getClient();
//        // @Document(indexName = "product", type = "book")
//        SearchRequestBuilder srb = client.prepareSearch("article").setTypes("content");
//        SearchResponse sr = srb.setQuery(QueryBuilders.matchAllQuery()).execute().actionGet(); // 查询所有
//        SearchHits hits = sr.getHits();
//        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//        for (SearchHit hit : hits) {ContentRepository
//            Map<String, Object> source = hit.getSourceAsMap();//.getSource();
//            list.add(source);
//            System.out.println(hit.getSourceAsString());
//        }
//
//
//        SearchQuery searchQuery = null;// getEntitySearchQuery(pageNumber,pageSize,searchContent);
//
//        log.info("\n searchCity: searchContent [" + searchContent + "] \n DSL = \n "
//                + searchQuery.getQuery().toString());
//
//        Page<Content> cityPage = contentRepository.search(searchQuery);
//        return cityPage.getContent();
//    }
//
//    /**
//     * 组装搜索Query对象
//     * @param pageNumber
//     * @param pageSize
//     * @param searchContent
//     * @return
//     */
//    private SearchQuery getEntitySearchQuery(int pageNumber, int pageSize, String searchContent) {
//
////        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery()
////                .add(QueryBuilders.matchPhraseQuery("name", searchContent),
////                        ScoreFunctionBuilders.weightFactorFunction(1000))
////                .scoreMode(SCORE_MODE_SUM).setMinScore(MIN_SCORE);
////                //.add(QueryBuilders.matchPhraseQuery("other", searchContent),
////                //ScoreFunctionBuilders.weightFactorFunction(1000))
////        //设置分页，否则只能按照ES默认的分页给
////        Pageable pageable = new PageRequest(pageNumber, pageSize);
////        return new NativeSearchQueryBuilder().withPageable(pageable).withQuery(functionScoreQueryBuilder).build();
//        return null;
//    }
//
//}
