package com.webup.user.bms.controller;

import com.webup.user.bms.service.BmsUserService;
import com.github.pagehelper.PageHelper;
import com.netflix.hystrix.exception.HystrixRuntimeException;
import com.webup.soa.base.AbstractBaseController;
import com.webup.soa.base.JsonResult;
import com.webup.soa.base.PageResult;
import com.webup.soa.utils.JsonResultUtil;
import com.webup.soa.utils.ValidatorUtil;
import com.webup.user.bms.pojo.BmsUser;
import com.webup.user.bms.pojo.BmsUserQueryParams;
import com.webup.user.es.repositories.Content;
import com.webup.user.es.service.ContentService;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;
import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;
//import javax.servlet.http.HttpServletRequest;

/**
 * @author denghua
 * @version 1.2
 * @project yzys
 * @class_name BmsUserController
 * @date 2017-07-31 17:54
 */
@RestController
@RequestMapping("user")
public class BmsUserController extends AbstractBaseController{

    @Resource
    private BmsUserService bmsUserService;
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    @Resource
    private ContentService contentService;

    /**
     * 列表
     *
     * @return
     */
//    @ResponseBody
    @RequestMapping("list")
    public String list(Pageable pageable) {
        Content content = contentService.getById(1L);

//        QueryBuilder queryBuilder = QueryBuilders.commonTermsQuery("id","1");
//        SearchResponse response = elasticsearchTemplate.getClient().prepareSearch("article").setQuery(queryBuilder).get();
//        System.out.println(response.getHits().getTotalHits());
//        for (SearchHit searchHit: response.getHits()) {
//            System.out.println(searchHit);
//        }
//        SearchQuery searchQuery2= new NativeSearchQueryBuilder().withQuery(matchAllQuery()).build();
//        elasticsearchTemplate.queryForList(searchQuery2, Content.class);

//        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(queryStringQuery("1")).withPageable(pageable).build();
//        elasticsearchTemplate.queryForList(searchQuery, Content.class);

        BmsUser user = bmsUserService.getById(1);
        return user.getLoginName();
//        return "abc1";
    }

    /**
     * 列表
     *
     * @return
     */
//    @ResponseBody
    @RequestMapping(value = "info", method = RequestMethod.GET)
    public JsonResult<BmsUser> info(String name) {
        BmsUser user = null;
        try{
            user = bmsUserService.getUserByLoginName(name);
        }catch (HystrixRuntimeException e){
        }catch (Exception e){
        }
        return JsonResultUtil.createJsonResult(user);
    }

    /**
     * 列表
     * @param request 请求参数，必须含有PageNo和PageSize，以便进行分页
     * @param bmsUserQueryParams 分页查询实体
     * @return
     */
    @RequestMapping(value = "listPageSize", method = RequestMethod.GET)
    public JsonResult<PageResult<BmsUser>> listPageSize(HttpServletRequest request, Integer pageNum,Integer pageSize,BmsUserQueryParams bmsUserQueryParams){
        if(!ValidatorUtil.checkNull(pageNum,pageSize)){
            PageHelper.startPage(pageNum,pageSize);
        }
        PageResult<BmsUser> list = bmsUserService.queryByParams(bmsUserQueryParams);
        return JsonResultUtil.createJsonResult(list);
    }


    /**
     * 列表
     * @param request 请求参数，必须含有PageNo和PageSize，以便进行分页
     * @param bmsUserQueryParams 分页查询实体
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "listPage", method = RequestMethod.GET)
    public JsonResult<PageResult<BmsUser>> listPage(HttpServletRequest request,BmsUserQueryParams bmsUserQueryParams){
        PageResult<BmsUser> list = bmsUserService.queryByParams(bmsUserQueryParams);
        return JsonResultUtil.createJsonResult(list);
    }

}

//
//public class BmsUserController extends AbstractBaseController {
//
////    @Resource
////    private BmsUserService bmsUserService;
//
//    /**
//     * 列表
//     * @param request 请求参数，必须含有PageNo和PageSize，以便进行分页
//     * @param bmsUserQueryParams 分页查询实体
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping("list")
//    public JsonResult<PageResult<BmsUser>> list(HttpServletRequest request, BmsUserQueryParams bmsUserQueryParams){
////        PageResult<BmsUser> list = bmsUserService.queryByParams(bmsUserQueryParams);
////        return JsonResultUtil.createJsonResult(list);
//        return null;
//    }
//
//
//}