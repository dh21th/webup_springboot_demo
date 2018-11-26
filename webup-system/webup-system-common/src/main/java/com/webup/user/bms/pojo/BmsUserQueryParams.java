package com.webup.user.bms.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.webup.soa.base.BaseQueryParams;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author denghua
 * @version 1.2
 * @project yzys
 * @class_name BmsUserQueryParams
 * @date 2017-07-31 17:54
 */
public class BmsUserQueryParams extends BaseQueryParams {

    private String loginName; //用户名

    private String phone; //手机

    private String email; //邮箱

    private String loginpass; //登录密码

    private String headimg; //头像

    private Integer sex; //性别 0 男 1 女

    private String qq; //QQ

    private String wxname; //微信号码

    private String fax; //传真号

    private String fixedPhone; //固话

    private String userAddress; //地址

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh_CN", timezone = "GMT+8")
    private Date regTime; //注册时间

    private Boolean binedPhoneFlag; //手机是否绑定

    private Boolean binedEmailFlag; //邮箱是否绑定

    private Boolean allowLogin; //是否允许登陆 0 禁止登陆 1 允许登陆（默认值=1）

    private Boolean verifyedFlag; //是否认证通过

    private String userName; //姓名

    private String phonevsid; //手机号登录随机码

    private String cername; //验证名称

    private String signimgfile; //签名文件

    private String salt; //加密盐值

    private Integer roleId;

    private Integer updatorId;

    //属性的get和set方法

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoginpass() {
        return loginpass;
    }

    public void setLoginpass(String loginpass) {
        this.loginpass = loginpass;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWxname() {
        return wxname;
    }

    public void setWxname(String wxname) {
        this.wxname = wxname;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getFixedPhone() {
        return fixedPhone;
    }

    public void setFixedPhone(String fixedPhone) {
        this.fixedPhone = fixedPhone;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public Boolean getBinedPhoneFlag() {
        return binedPhoneFlag;
    }

    public void setBinedPhoneFlag(Boolean binedPhoneFlag) {
        this.binedPhoneFlag = binedPhoneFlag;
    }

    public Boolean getBinedEmailFlag() {
        return binedEmailFlag;
    }

    public void setBinedEmailFlag(Boolean binedEmailFlag) {
        this.binedEmailFlag = binedEmailFlag;
    }

    public Boolean getAllowLogin() {
        return allowLogin;
    }

    public void setAllowLogin(Boolean allowLogin) {
        this.allowLogin = allowLogin;
    }

    public Boolean getVerifyedFlag() {
        return verifyedFlag;
    }

    public void setVerifyedFlag(Boolean verifyedFlag) {
        this.verifyedFlag = verifyedFlag;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhonevsid() {
        return phonevsid;
    }

    public void setPhonevsid(String phonevsid) {
        this.phonevsid = phonevsid;
    }

    public String getCername() {
        return cername;
    }

    public void setCername(String cername) {
        this.cername = cername;
    }

    public String getSignimgfile() {
        return signimgfile;
    }

    public void setSignimgfile(String signimgfile) {
        this.signimgfile = signimgfile;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getUpdatorId() {
        return updatorId;
    }

    public void setUpdatorId(Integer updatorId) {
        this.updatorId = updatorId;
    }
}