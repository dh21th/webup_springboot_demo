package com.webup.soa.utils;

import com.webup.soa.base.JsonResult;
import com.webup.soa.common.CommonConst;

public class JsonResultUtil {
	
	private static final String DEFAULT_MESSAGE = "操作成功";
	private static final String DEFAULT_MESSAGE_FAIL = "抱歉，操作失败";
	public static <T> JsonResult<T> createJsonResult(T data) {
		JsonResult<T> temResult = new JsonResult<T>();
		temResult.setData(data);
		temResult.setSuccess(true);
		temResult.setMessage(DEFAULT_MESSAGE);
		return temResult;
	}
	public static <T> JsonResult<T> createJsonResult(T data,T otherDate) {
		JsonResult<T> temResult = new JsonResult<T>();
		temResult.setData(data);
		temResult.setOtherData(otherDate);
		temResult.setSuccess(true);
		temResult.setMessage(DEFAULT_MESSAGE);
		return temResult;
	}
	public static <T> JsonResult<T> createNoParaResult() {
		JsonResult<T> temResult = new JsonResult<T>();
		temResult.setSuccess(false);
		temResult.setCode(CommonConst.Result.PARAM_ERROR);
		temResult.setMessage(DEFAULT_MESSAGE_FAIL);
		return temResult;
	}

	public static <T> JsonResult<T> createCodeResult(Integer code) {
		JsonResult<T> temResult = new JsonResult<T>();
		temResult.setCode(code);
		temResult.setSuccess(code.equals(CommonConst.Result.FLAG_TRUE));
		temResult.setMessage(DEFAULT_MESSAGE);
		return temResult;
	}

	public static <T> JsonResult<T> createBooleanJsonResult(boolean isSuccess) {
		JsonResult<T> temResult = new JsonResult<T>();
		temResult.setSuccess(isSuccess);
		temResult.setMessage(isSuccess?DEFAULT_MESSAGE:DEFAULT_MESSAGE_FAIL);
		return temResult;
	}
	public static <T> JsonResult<T> createBooleanJsonResult(boolean isSuccess, String msg) {
		JsonResult<T> temResult = new JsonResult<T>();
		temResult.setSuccess(isSuccess);
		temResult.setMessage(msg);
		return temResult;
	}

	public static <T> JsonResult<T> createJsonResult(T data, boolean isSuccess) {
		JsonResult<T> temResult = new JsonResult<T>();
		temResult.setData(data);
		temResult.setSuccess(isSuccess);
		temResult.setMessage(DEFAULT_MESSAGE);
		return temResult;
	}
	
	public static <T> JsonResult<T> createJsonResult(T data, boolean isSuccess, String msg) {
		JsonResult<T> temResult = new JsonResult<T>();
		temResult.setData(data);
		temResult.setSuccess(isSuccess);
		temResult.setMessage(msg);
		return temResult;
	}
	public static <T> JsonResult<T> createJsonResult(T data, String msg) {
		JsonResult<T> temResult = new JsonResult<T>();
		temResult.setData(data);
		temResult.setSuccess(true);
		temResult.setMessage(msg);
		return temResult;
	}
	public static JsonResult createJsonResult(boolean isSuccess) {
		JsonResult temResult = new JsonResult();
		temResult.setSuccess(isSuccess);
		temResult.setMessage(isSuccess?DEFAULT_MESSAGE:DEFAULT_MESSAGE_FAIL);
		return temResult;
	}
}
