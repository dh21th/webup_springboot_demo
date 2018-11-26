package com.webup.soa.sign.vo;
/**
 * PC端合同操作中生成的临时文件内容
 * @author xiaobei
 * Created by xiaobei on 2017/2/7.
 *
 */
public class UserContract {

	private Integer signType;//签章类型：1表示PC端，2表示APP端
	private Integer contractId;//合同id
	private Integer usertype;//当前操作的用户类型 1 货主 2 物流公司 4司机
	private Integer source;//签章请求系统来源 1 物流平台 2 云商平台
	private String fileSuffix;//合同文件后缀
	private String sourceFilePath;//操作前的合同文件在服务器上的保存的全路径
	private String targetFilePath;//操作后的合同文件在服务器上的保存的全路径
	private String requestUrl;//合同相关操作后回写数据库的路径
	private Integer state;//正常操作之后的状态
	private Integer currentState;//当前订单的状态
	private CompanyInfo signInfo;//企业信息
	private CompanySignInfo companySignInfo;//电子签章时用到的信息
	private Integer signState;//合同签章状态

	public Integer getSignState() {
		return signState;
	}

	public void setSignState(Integer signState) {
		this.signState = signState;
	}

	public Integer getSignType() {
		return signType;
	}

	public void setSignType(Integer signType) {
		this.signType = signType;
	}

	public Integer getContractId() {
		return contractId;
	}

	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}

	public Integer getUsertype() {
		return usertype;
	}

	public void setUsertype(Integer usertype) {
		this.usertype = usertype;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	public String getFileSuffix() {
		return fileSuffix;
	}

	public void setFileSuffix(String fileSuffix) {
		this.fileSuffix = fileSuffix;
	}

	public String getSourceFilePath() {
		return sourceFilePath;
	}

	public void setSourceFilePath(String sourceFilePath) {
		this.sourceFilePath = sourceFilePath;
	}

	public String getTargetFilePath() {
		return targetFilePath;
	}

	public void setTargetFilePath(String targetFilePath) {
		this.targetFilePath = targetFilePath;
	}

	public String getRequestUrl() {
		return requestUrl;
	}

	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getCurrentState() {
		return currentState;
	}

	public void setCurrentState(Integer currentState) {
		this.currentState = currentState;
	}

	public CompanyInfo getSignInfo() {
		return signInfo;
	}

	public void setSignInfo(CompanyInfo signInfo) {
		this.signInfo = signInfo;
	}

	public CompanySignInfo getCompanySignInfo() {
		return companySignInfo;
	}

	public void setCompanySignInfo(CompanySignInfo companySignInfo) {
		this.companySignInfo = companySignInfo;
	}
}
