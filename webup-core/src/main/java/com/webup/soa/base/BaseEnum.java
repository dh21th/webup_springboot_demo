package com.webup.soa.base;


//@JsonSerialize(using = BaseEnumSerializer.class)
public interface BaseEnum <K>{
	
	K getId();
	
	String getName();
	
}
