package com.webup.soa.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.webup.soa.base.AbstractBaseController;
import com.webup.soa.base.BaseEnum;
import com.webup.soa.base.JsonResult;
import com.webup.soa.utils.BaseEnumUtils;
import com.google.common.collect.Maps;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
@RequestMapping(value = "/common")
public class EnumController extends AbstractBaseController{

	
//	private static  Map<String,Class<? extends BaseEnum<?>>>   enumMappers= Maps.newHashMap();
//
//
//	@ResponseBody
//	@RequestMapping(value = "/getEnumsForJsonResult")
//	public  <K> JsonResult<List<BaseEnum<K>>>  getEnumsForJsonResult(String enumName){
//		JsonResult<List<BaseEnum<K>>> result = JsonResult.newResult();
//		try {
//			Class   enumType=enumMappers.get(enumName);
//			List<BaseEnum<K>>  enums= BaseEnumUtils.getEnums(enumType);
//			result.setData(enums);
//		}
//		 catch (Exception e) {
//				logger.warn(this.getClass().getName(), "查询枚举类型失败", e);
//				result.setSuccess(false);
//				result.setMessage("查询枚举类型失败");
//			}
//			return result;
//
//
//
//	}
//	/** @param enumMappers
//	 * @Deprecated
//	@ResponseBody
//	@RequestMapping(value = "/getEnums")
//	public  <K> List<BaseEnum<K>>  getEnums(String enumName){
//		Class   enumType=enumMappers.get(enumName);
//		List<BaseEnum<K>>  enums=BaseEnumUtils.getEnums(enumType);
//
//		return enums;
//
//	}
//	 *
//	 */
//
//
//
//	@Resource
//	public  void setEnumMappers(Map<String,Class<? extends BaseEnum<?>>>  enumMappers) {
//		EnumController.enumMappers = enumMappers;
//	}
//
	
	
	
}
