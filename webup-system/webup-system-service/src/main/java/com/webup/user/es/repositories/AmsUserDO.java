package com.webup.user.es.repositories;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AmsUserDO implements Serializable {
    Integer id;
    String loginName;
    String phone;
    String email;
    String loginpass;
    String headimg;
    Boolean sex;
    String qq;
    String wxname;
    String fax;
    String zipCode;
    String fixedPhone;
    String userAddress;
    Date regTime;
    String openId;
    Boolean openType;
    Boolean binedPhone_flag;
    Boolean binedEmail_flag;
    Boolean allowLogin;
    Boolean verifyedFlag;
    String userName;
    String phonevsid;
    String cername;
    String signimgfile;
    Boolean erpconfiged;
    String salt;
    Integer corpId;
    Integer systemSource;
    String department;
    Integer roleid;
    String roleids;
    Integer userType;
    Integer userArea;
}
