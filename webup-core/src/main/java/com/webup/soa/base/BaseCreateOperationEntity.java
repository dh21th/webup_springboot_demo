package com.webup.soa.base;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 创建操作的实体
 * @author cgb
 *
 * @param <K>
 */
public class BaseCreateOperationEntity<K> extends IdEntity<K>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8057288451425475301L;

	protected Date createTime;//创建时间

	protected Integer creatorId;// 创建者Id

	protected String creatorName;// 创建者姓名
	
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh_CN", timezone = "GMT+8")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}
	
	public String getCreatorName() {
		return creatorName;
	}
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
}
