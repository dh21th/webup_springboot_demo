package com.webup.soa.base;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 供需要记录基本日志的业务实体继承使用，
 * 带基本操作日志的实体
 * 
 * @author cgb
 *
 */
public class BaseOperationEntity<K> extends BaseCreateOperationEntity<K> {

	private static final long serialVersionUID = -7856463419828351715L;

	protected Boolean deleteFlag=false;//设置默认值，因为大多数条件下都为false

	protected Date updateTime;// 更新时间

	protected Long updatorId;// 更新者id

	protected String updatorName;// 更新者姓名
	
	
	public Boolean getDeleteFlag() {
		return deleteFlag;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh_CN", timezone = "GMT+8")
	public Date getUpdateTime() {
		return updateTime;
	}

	public Long getUpdatorId() {
		return updatorId;
	}

	

	public void setDeleteFlag(Boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public void setUpdatorId(Long updatorId) {
		this.updatorId = updatorId;
	}

	

	public String getUpdatorName() {
		return updatorName;
	}

	public void setUpdatorName(String updatorName) {
		this.updatorName = updatorName;
	}

}
