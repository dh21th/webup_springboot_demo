package com.webup.soa.base;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public abstract class BaseQueryParams extends IdEntity<Integer> implements Serializable{

	/**
	 * 111
	 */
	private static final long serialVersionUID = 5945384865416749198L;
	
	protected String fuzzy;

	protected String orderBy;//排序sql

	protected String groupBy;//分组sql
	
	protected Integer excludeId,pageNo,pageSize;
	
	protected List<Integer>  excludeIds;
}
