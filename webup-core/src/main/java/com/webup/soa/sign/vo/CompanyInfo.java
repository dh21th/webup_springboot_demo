package com.webup.soa.sign.vo;
/**
 * 企业签章时所需源信息
 * @author xiaobei
 * Created by xiaobei on 2017/2/7.
 *
 */
public class CompanyInfo {
	
	private String companyName;//企业名称
	private String sealType;//印章类型
	private String legalman;//企业法人
	private String corpno;//统一社会信用代码
	private String signKeyWords;//签章关键字
	
//	public CompanyInfo(String companyName, String sealType, String legalman, String corpno, String signKeyWords) {
//		this.companyName = companyName;
//		this.sealType = sealType;
//		this.legalman = legalman;
//		this.corpno = corpno;
//		this.signKeyWords = signKeyWords;
//	}
	
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
	public String getLegalman() {
		return legalman;
	}
	public void setLegalman(String legalman) {
		this.legalman = legalman;
	}
	public String getCorpno() {
		return corpno;
	}
	public void setCorpno(String corpno) {
		this.corpno = corpno;
	}
	public String getSignKeyWords() {
		return signKeyWords;
	}
	public void setSignKeyWords(String signKeyWords) {
		this.signKeyWords = signKeyWords;
	}
	@Override
	public String toString() {
		return "CompanyInfo [companyName=" + companyName + ", sealType=" + sealType + ", legalman=" + legalman
				+ ", corpno=" + corpno + ", signKeyWords=" + signKeyWords + "]";
	}
	
}
