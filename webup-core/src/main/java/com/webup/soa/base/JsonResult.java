package com.webup.soa.base;

import java.io.Serializable;

/**
 * 
 * @author cgb
 *后台响应json格式标准
 */
public class JsonResult<T> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3863559687276427577L;

	private boolean success=true;
	private T  data;//数据
	private T otherData;//其他数据
	public String message;

	private Integer code;
	
	
	private String token;
	
	public JsonResult(){};
	
	public JsonResult(T data, Boolean success, String message) {
		this.data=data;
		this.success=success;
		this.message=message;
	}

	public JsonResult(T data, Boolean success, String message,T otherData) {
		this.data=data;
		this.success=success;
		this.message=message;
		this.otherData = otherData;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getOtherData() {
		return otherData;
	}

	public void setOtherData(T otherData) {
		this.otherData = otherData;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	public  static <T> JsonResult<T> newResult(){
		
		return new JsonResult<T>();
	}
	

}
