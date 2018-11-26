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
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

    /**
     * 列表
     *
     * @return
     */
//    @ResponseBody
    @RequestMapping("list")
    public String list() {
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