package com.webup.user.bms.service;

import com.webup.user.bms.pojo.BmsUser;
import com.webup.user.bms.pojo.BmsUserQueryParams;
import com.webup.user.bms.pojo.BmsUserUpdateParams;
import com.webup.soa.base.BaseService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author denghua
 * @version 1.2
 * @project yzys
 * @class_name BmsUserService
 * @date 2017-07-31 17:54
 */
public interface BmsUserService extends BaseService<Integer, BmsUser, BmsUserUpdateParams, BmsUserQueryParams> {
    /**
     * 查询
     * @param name name
     * @return BmsUser
     * @throws Exception
     */
    BmsUser getUserByLoginName(String name) throws Exception;
}


//@FeignClient(name = CommonConst.FeignClientServerName) //,fallback = BmsUserService.BmsUserClientFallback.class
//@YzFeignClient
//public interface BmsUserService extends BaseService<Integer, BmsUser, BmsUserUpdateParams, BmsUserQueryParams> {
//
//    /**
//     * 查询
//     * @return String
//     */
//    BmsUser getUserByLoginName(String name);
//
//    /**
//     * 根据主键查询
//     * @param id 主键id
//     * @return
//    @Override
//    public BmsUser getById(Integer id);
//     */
//
//}
