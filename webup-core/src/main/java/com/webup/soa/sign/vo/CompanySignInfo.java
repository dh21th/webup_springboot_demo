package com.webup.soa.sign.vo;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * 企业签章时所用到的信息
 *
 * @author Xiaobei
 * @create 2017-08-30 13:57
 */
public class CompanySignInfo {

    private String companyName;//公司名称

    private String sealType;//所盖印章类型（印章中心文字）

    private String keyWords;//印章位置匹配的关键字

    private Integer contractId;//合同id

    private Integer endState;//本次合同签订成功后的状态

    private String pdfPath;//原合同全路径

    private String signedPdfPath;//签章后合同保存全路径

    private String userName;//公司法人姓名

    private Integer userType;//当前用户类型

    private String userIdNo;//公司统一社会信用代码

    private int index;//匹配的第几个keyWords，-1表示最后一个

    private int leftOffset;//签章向右偏移量，单位：像素

    private String requestUrl;//请求数据库的url

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSealType() {
        return sealType;
    }

    public void setSealType(String sealType) {
        this.sealType = sealType;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Integer getEndState() {
        return endState;
    }

    public void setEndState(Integer endState) {
        this.endState = endState;
    }

    public String getPdfPath() {
        return pdfPath;
    }

    public void setPdfPath(String pdfPath) {
        this.pdfPath = pdfPath;
    }

    public String getSignedPdfPath() {
        return signedPdfPath;
    }

    public void setSignedPdfPath(String signedPdfPath) {
        this.signedPdfPath = signedPdfPath;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getUserIdNo() {
        return userIdNo;
    }

    public void setUserIdNo(String userIdNo) {
        this.userIdNo = userIdNo;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getLeftOffset() {
        return leftOffset;
    }

    public void setLeftOffset(int leftOffset) {
        this.leftOffset = leftOffset;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }
}
