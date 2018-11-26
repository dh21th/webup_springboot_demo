package com.webup.soa.sign.vo;
/**
 * 个人签章时所需源信息
 * @author Legend
 *
 */
public class PersonalInfo {

	private String name;//姓名
	private String idCard;//身份证号
	private String telNo;//联系方式
	private String signImgFile;//签名文件保存路径
	private String signKeyWords;//签章位置（关键字）
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getTelNo() {
		return telNo;
	}
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
	public String getSignImgFile() {
		return signImgFile;
	}
	public void setSignImgFile(String signImgFile) {
		this.signImgFile = signImgFile;
	}
	public String getSignKeyWords() {
		return signKeyWords;
	}
	public void setSignKeyWords(String signKeyWords) {
		this.signKeyWords = signKeyWords;
	}
	@Override
	public String toString() {
		return "PersonalInfo [name=" + name + ", idCard=" + idCard + ", telNo=" + telNo + ", signImgFile="
				+ signImgFile + ", signKeyWords=" + signKeyWords + "]";
	}
}
