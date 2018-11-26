package com.webup.soa.sign.vo;

/**
 * 个人签章时所用到的信息
 *
 * @author Xiaobei
 * @create 2017-08-30 13:57
 */
public class PersonalSignInfo {

    private String signImgFile;//签名文件全路径

    private String driverContractId;//当前签署合同的合同id

    private String usertype;//当前签署合同的用户类型 1 货主 2 物流公司 4司机

    private String endState;//合同签章后的状态

    private String docPath;//合同文件的存放路径

    private String pdfFilePath;//原合同转换为pdf格式后的存放全路径

    private String signedPdfPath;//合同签章后的保存全路径名

    private String userName;//司机姓名

    private String userIdNo;//司机身份证号

    private String TelNo;//司机电话号码

    private String signKeyWords;//印章位置

    private String contractfilePath;//合同在数据库中的保存全路径

    public String getSignImgFile() {
        return signImgFile;
    }

    public void setSignImgFile(String signImgFile) {
        this.signImgFile = signImgFile;
    }

    public String getDriverContractId() {
        return driverContractId;
    }

    public void setDriverContractId(String driverContractId) {
        this.driverContractId = driverContractId;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getEndState() {
        return endState;
    }

    public void setEndState(String endState) {
        this.endState = endState;
    }

    public String getDocPath() {
        return docPath;
    }

    public void setDocPath(String docPath) {
        this.docPath = docPath;
    }

    public String getPdfFilePath() {
        return pdfFilePath;
    }

    public void setPdfFilePath(String pdfFilePath) {
        this.pdfFilePath = pdfFilePath;
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

    public String getUserIdNo() {
        return userIdNo;
    }

    public void setUserIdNo(String userIdNo) {
        this.userIdNo = userIdNo;
    }

    public String getTelNo() {
        return TelNo;
    }

    public void setTelNo(String telNo) {
        TelNo = telNo;
    }

    public String getSignKeyWords() {
        return signKeyWords;
    }

    public void setSignKeyWords(String signKeyWords) {
        this.signKeyWords = signKeyWords;
    }

    public String getContractfilePath() {
        return contractfilePath;
    }

    public void setContractfilePath(String contractfilePath) {
        this.contractfilePath = contractfilePath;
    }

    @Override
    public String toString() {
        return "PersonalSignInfo{" +
                "signImgFile='" + signImgFile + '\'' +
                ", driverContractId='" + driverContractId + '\'' +
                ", usertype='" + usertype + '\'' +
                ", endState='" + endState + '\'' +
                ", docPath='" + docPath + '\'' +
                ", pdfFilePath='" + pdfFilePath + '\'' +
                ", signedPdfPath='" + signedPdfPath + '\'' +
                ", userName='" + userName + '\'' +
                ", userIdNo='" + userIdNo + '\'' +
                ", TelNo='" + TelNo + '\'' +
                ", signKeyWords='" + signKeyWords + '\'' +
                ", contractfilePath='" + contractfilePath + '\'' +
                '}';
    }
}
