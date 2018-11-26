package com.webup.user.bms.mapper;

import com.webup.user.bms.pojo.BmsUser;
import com.webup.user.bms.pojo.BmsUserQueryParams;
import com.webup.user.bms.pojo.BmsUserUpdateParams;
import com.webup.soa.base.BaseMapper;
import com.webup.user.bms.pojo.BmsUser;
import com.webup.user.bms.pojo.BmsUserQueryParams;
import com.webup.user.bms.pojo.BmsUserUpdateParams;

/**
 * @author denghua
 * @version 1.2
 * @project yzys
 * @table_name bms_user
 * @date 2017-07-31 17:54
 */
public interface BmsUserMapper extends BaseMapper<Integer, BmsUser, BmsUserUpdateParams, BmsUserQueryParams> {

    BmsUser getUserByLoginName(BmsUserQueryParams userQueryParams);
}