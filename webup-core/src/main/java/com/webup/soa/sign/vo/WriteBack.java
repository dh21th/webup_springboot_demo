package com.webup.soa.sign.vo;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * 回写业务系统实体
 *
 * @author Xiaobei
 * @create 2017-08-30 17:21
 */
public class WriteBack {

    private Integer id;//合同表中的主键

    private String requestUrl;//回调业务的请求url

    private Integer signstate;//当前用户的签章状态

    private Integer userType;//用户类型：甲方或乙方

    private Integer state;//签章系统后的合同状态

    private Integer orderId;//订单ID

    private Integer source;//请求来源

    private String responseMsg;//出错信息

    private String sign;//签名 防止 伪装请求/防篡改/ 防重发” 识别的重要依据。

    private String timestamp;//签名后回调业务系统的时间字符串

    private String signPath;//签章后地址

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public Integer getSignstate() {
        return signstate;
    }

    public void setSignstate(Integer signstate) {
        this.signstate = signstate;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSignPath() {
        return signPath;
    }
    public void setSignPath(String signPath) {
        this.signPath = signPath;
    }
}
