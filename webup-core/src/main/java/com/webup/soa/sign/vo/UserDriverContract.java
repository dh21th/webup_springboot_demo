package com.webup.soa.sign.vo;
/**
 * APP端司机合同操作中生成的临时文件内容
 * @author xiaobei
 * Created by xiaobei on 2017/2/9.
 *
 */
public class UserDriverContract {

	private Short signType;//签章类型：1表示PC端，2表示APP端
	private String fileSuffix;//合同文件后缀
	private String sourceFilePath;//操作前的合同文件在服务器上的保存的全路径
	private String targetFilePath;//操作后的合同文件在服务器上的保存的全路径
	private Integer driverContractId;//司机合同id
	private Integer usertype;//当前操作的用户类型 1 货主 2 物流公司 4司机
	private Short state;//当前合同的状态
	private PersonalInfo signInfo;//电子签章所需的司机信息
	private UserContract userContract;//企业签章时所需的签章信息

	public Short getSignType() {
		return signType;
	}

	public void setSignType(Short signType) {
		this.signType = signType;
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

	public Integer getDriverContractId() {
		return driverContractId;
	}

	public void setDriverContractId(Integer driverContractId) {
		this.driverContractId = driverContractId;
	}

	public Integer getUsertype() {
		return usertype;
	}

	public void setUsertype(Integer usertype) {
		this.usertype = usertype;
	}

	public Short getState() {
		return state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	public PersonalInfo getSignInfo() {
		return signInfo;
	}

	public void setSignInfo(PersonalInfo signInfo) {
		this.signInfo = signInfo;
	}

	public UserContract getUserContract() {
		return userContract;
	}

	public void setUserContract(UserContract userContract) {
		this.userContract = userContract;
	}
}
