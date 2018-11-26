package com.webup.user.bms.service.impl;

import com.webup.user.bms.mapper.BmsUserMapper;
import com.webup.user.bms.pojo.BmsUser;
import com.webup.user.bms.pojo.BmsUserQueryParams;
import com.webup.user.bms.pojo.BmsUserUpdateParams;
import com.webup.user.bms.service.BmsUserService;
import com.webup.soa.base.AbstractBaseService;
import com.webup.soa.base.BaseMapper;
import com.webup.soa.utils.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author denghua
 * @version 1.2
 * @project yzys
 * @class_name BmsUserServiceImpl
 * @date 2017-07-31 17:54
 */
@Service("BmsUserService")
public class BmsUserServiceImpl extends AbstractBaseService<Integer, BmsUser, BmsUserUpdateParams, BmsUserQueryParams> implements BmsUserService {

    @Resource
    private BmsUserMapper bmsUserMapper;


    @Override
    protected BaseMapper getMapper() {
        return bmsUserMapper;
    }


    @Override
    public BmsUser getUserByLoginName(String name) throws Exception {
        try{
            System.out.println("getUserByLoginName : " + DateUtils.getFormatCurrentTime());
            Thread.sleep(10000);
            BmsUserQueryParams userQueryParams = new BmsUserQueryParams();
            userQueryParams.setLoginName(name);
            return bmsUserMapper.getUserByLoginName(userQueryParams);
        }catch (InterruptedException e){
            return null;
        }
    }
}
