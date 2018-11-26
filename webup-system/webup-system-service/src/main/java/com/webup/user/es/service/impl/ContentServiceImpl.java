package com.webup.user.es.service.impl;

import com.webup.user.es.repositories.Content;
import com.webup.user.es.repositories.ContentRepository;
import com.webup.user.es.service.ContentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.SearchQuery;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
public class ContentServiceImpl implements ContentService {
    @Resource
    ContentRepository contentRepository;


    int PAGE_SIZE = 15; //默认分页大小

    int PAGE_NUMBER = 0; //默认当前分页

    String SCORE_MODE_SUM = "sum"; //权重分求和模式

    Float MIN_SCORE = 10.0F; //由于无相关性的分值默认为1， 设置权重分最小值为10


    /**
     * 保存内容到ES
     */
    @Override
    public Long save(Content entity) {
        Content entityResult = contentRepository.save(entity);
        return entityResult.getId();
    }

    @Override
    public Long modify(Content content) {
        return null;
    }

    @Override
    public Long deleteById(Long Id) {
        return null;
    }

    @Override
    public Long selectById(Long Id) {
        return null;
    }


    /**
     * 在ES中搜索内容
     */
    @Override
    public List<Content> search(int pageNumber, int pageSize, String searchContent){
        if(pageSize==0) {
            pageSize = PAGE_SIZE;
        }
        if(pageNumber<0) {
            pageNumber = PAGE_NUMBER;
        }

        SearchQuery searchQuery = null;// getEntitySearchQuery(pageNumber,pageSize,searchContent);

        log.info("\n searchCity: searchContent [" + searchContent + "] \n DSL = \n "
                + searchQuery.getQuery().toString());

        Page<Content> cityPage = contentRepository.search(searchQuery);
        return cityPage.getContent();
    }

//    /**
//     * 组装搜索Query对象
//     * @param pageNumber
//     * @param pageSize
//     * @param searchContent
//     * @return
//     */
//    private SearchQuery getEntitySearchQuery(int pageNumber, int pageSize, String searchContent) {
//        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery()
//                .add(QueryBuilders.matchPhraseQuery("name", searchContent),
//                        ScoreFunctionBuilders.weightFactorFunction(1000))
//                .scoreMode(SCORE_MODE_SUM).setMinScore(MIN_SCORE);
//                //.add(QueryBuilders.matchPhraseQuery("other", searchContent),
//                //ScoreFunctionBuilders.weightFactorFunction(1000))
//        //设置分页，否则只能按照ES默认的分页给
//        Pageable pageable = new PageRequest(pageNumber, pageSize);
//        return new NativeSearchQueryBuilder().withPageable(pageable).withQuery(functionScoreQueryBuilder).build();
//    }

}
