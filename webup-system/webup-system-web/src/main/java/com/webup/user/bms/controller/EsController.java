package com.webup.user.bms.controller;

import com.webup.soa.base.JsonResult;
import com.webup.soa.utils.JsonResultUtil;
import com.webup.user.es.repositories.Content;
import com.webup.user.es.service.ContentService;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/es")
public class EsController {
    @Resource
    ContentService contentService;

    @RequestMapping(value = "/deleteIndex")
    public JsonResult deleteIndex(Content content){
        boolean result = contentService.deleteIndex();
        return JsonResultUtil.createJsonResult(result);
    };

    // OK
    @RequestMapping(value = "/indexExists")
    public JsonResult indexExists(Content content){
        boolean result = contentService.indexExists();
        return JsonResultUtil.createJsonResult(result);
    }

    @RequestMapping(value = "/addDocument")
    public JsonResult addDocument(Content content) throws Exception{
        boolean result = contentService.addDocument(content);
        return JsonResultUtil.createJsonResult(result);
    }

    @RequestMapping(value = "/bulkAddDocument")
    public JsonResult bulkAddDocument(List<Content> tList) throws Exception{
        boolean result = contentService.bulkAddDocument(tList);
        return JsonResultUtil.createJsonResult(result);
    }

    @RequestMapping(value = "/autoBulkAddDocument")
    public JsonResult autoBulkAddDocument(List<Content> tList) throws Exception{
        boolean result = contentService.autoBulkAddDocument(tList);
        return JsonResultUtil.createJsonResult(result);
    }

    @RequestMapping(value = "/importBulk")
    public JsonResult importBulk(String absFileName) throws Exception{
        contentService.importBulk(absFileName);
        return JsonResultUtil.createJsonResult(true);
    }

    @RequestMapping(value = "/exportBulk")
    public JsonResult exportBulk(String fileName) throws Exception{
        contentService.exportBulk(fileName);
        return JsonResultUtil.createJsonResult(true);
    }

    // OK
    @RequestMapping(value = "/getById")
    public JsonResult getById(Long id) throws Exception{
        Content result = contentService.getById(id);
        return JsonResultUtil.createJsonResult(result);
    }
    // OK
    @RequestMapping(value = "/deleteById")
    public JsonResult deleteById(Long id) throws Exception{
        boolean result = contentService.deleteById(id);
        return JsonResultUtil.createJsonResult(result);
    }
    // OK
    @RequestMapping(value = "/deleteByQuery")
    public JsonResult deleteByQuery() throws Exception{
        List<QueryBuilder> queryBuilders = new ArrayList<>();
        queryBuilders.add(QueryBuilders.idsQuery("content").addIds("997"));
        long n = contentService.deleteByQuery(queryBuilders);
        return JsonResultUtil.createJsonResult(n);
    }

    @RequestMapping(value = "/deleteAll")
    public JsonResult deleteAll() throws Exception{
        contentService.deleteAll();
        return JsonResultUtil.createJsonResult(true);
    }
    // OK
    @RequestMapping(value = "/deleteByIds")
    public JsonResult deleteByIds() throws Exception{
        List<Long> ids = new ArrayList();
        ids.add(994L);
        ids.add(995L);
        boolean result = contentService.deleteByIds(ids);
        return JsonResultUtil.createJsonResult(result);
    }

    @RequestMapping(value = "/updateDocument")
    public JsonResult updateDocument(Content content) throws Exception{
        boolean result = contentService.updateDocument(content);
        return JsonResultUtil.createJsonResult(result);
    }

    @RequestMapping(value = "/prepareUpdateDocument")
    public JsonResult prepareUpdateDocument(Content content) throws Exception{
        boolean result = contentService.prepareUpdateDocument(content);
        return JsonResultUtil.createJsonResult(result);
    }

    // OK
    @RequestMapping(value = "/search")
    public JsonResult search() throws Exception{
        QueryBuilder queryBuilder = null;
        SortBuilder sort = null;
        List<Content> list= contentService.search(queryBuilder,sort);
        return JsonResultUtil.createJsonResult(list);
    }
    @RequestMapping(value = "/searchOfPage")
    public JsonResult searchOfPage(Pageable pageable) throws Exception{
        QueryBuilder queryBuilder = null;
        Page<Content> result= contentService.searchOfPage(queryBuilder,pageable);
        return JsonResultUtil.createJsonResult(result);
    }

    @RequestMapping(value = "/searchSimilar")
    public JsonResult searchSimilar(Content content,String[] key ,Pageable pageable) throws Exception{
        Page<Content> result= contentService.searchSimilar(content,key,pageable);
        return JsonResultUtil.createJsonResult(result);
    }

    @RequestMapping(value = "/refresh")
    public JsonResult refresh() throws Exception{
        contentService.refresh();
        return JsonResultUtil.createJsonResult(true);
    }

    // OK
    @RequestMapping(value = "/getEntityClass")
    public JsonResult getEntityClass(){
        Class<Content> contentClass = contentService.getEntityClass();
        return JsonResultUtil.createJsonResult(contentClass.getName());
    }

    // OK
    @RequestMapping(value = "/findAll")
    public JsonResult findAll() throws Exception{
        SortBuilder sort = null;//SortBuilder.fieldOrScoreSort("id").order(SortOrder.DESC);
        List<Content> result= contentService.findAll(sort);
        return JsonResultUtil.createJsonResult(result);
    }

    // OK
    @RequestMapping(value = "/spanQuery")
    public JsonResult spanQuery() throws Exception{
        contentService.spanQuery();
        return JsonResultUtil.createJsonResult(true);
    }

    // OK
    @RequestMapping(value = "/multiGetResponse")
    public JsonResult multiGetResponse() throws Exception{
        List<Content> result= contentService.multiGetResponse();
        return JsonResultUtil.createJsonResult(result);
    }

    // OK
    @RequestMapping(value = "/matchPhrasePrefixQueryBuilder")
    public JsonResult matchPhrasePrefixQueryBuilder() throws Exception{
        List<Content> result= contentService.matchPhrasePrefixQueryBuilder();
        return JsonResultUtil.createJsonResult(result);
    }

    @RequestMapping(value = "/countSum")
    public JsonResult countSum() throws Exception{
        contentService.countSum();
        return JsonResultUtil.createJsonResult(true);
    }

    @RequestMapping(value = "/multiSearchResponse")
    public JsonResult multiSearchResponse() throws Exception{
        contentService.multiSearchResponse();
        return JsonResultUtil.createJsonResult(true);
    }

    @RequestMapping(value = "/complexSearch1")
    public JsonResult complexSearch1() throws Exception{
        contentService.complexSearch1();
        return JsonResultUtil.createJsonResult(true);
    }

    @RequestMapping(value = "/complexSearch2")
    public JsonResult complexSearch2() throws Exception{
        contentService.complexSearch2();
        return JsonResultUtil.createJsonResult(true);
    }

    @RequestMapping(value = "/getPlatformZuOrdersTotalAmount")
    public JsonResult getPlatformZuOrdersTotalAmount() throws Exception{
        contentService.getPlatformZuOrdersTotalAmount();
        return JsonResultUtil.createJsonResult(true);
    }

    @RequestMapping(value = "/pageFindAll")
    public JsonResult pageFindAll(Pageable pageable) throws Exception{
        Page<Content> result= contentService.findAll(pageable);
        return JsonResultUtil.createJsonResult(result);
    }

    @RequestMapping(value = "/queryPageScroll")
    public JsonResult queryPageScroll() throws Exception{
        contentService.queryPageScroll();
        return JsonResultUtil.createJsonResult(true);
    }

    @RequestMapping(value = "/fenye")
    public JsonResult fenye() throws Exception{
        contentService.fenye();
        return JsonResultUtil.createJsonResult(true);
    }

    @RequestMapping(value = "/highlighter")
    public JsonResult highlighter() throws Exception{
        contentService.highlighter();
        return JsonResultUtil.createJsonResult(true);
    }

    @RequestMapping(value = "/analyzeRequest")
    public JsonResult analyzeRequest() throws Exception{
        contentService.analyzeRequest();
        return JsonResultUtil.createJsonResult(true);
    }




}
