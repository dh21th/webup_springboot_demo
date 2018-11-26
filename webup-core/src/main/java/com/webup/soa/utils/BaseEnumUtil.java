package com.webup.soa.utils;

import java.lang.reflect.Method;
import java.util.List;
import com.google.common.collect.Lists;
import com.webup.soa.base.BaseEnum;
import com.webup.soa.exception.ApplicationException;

/**
 * 
 * @author cgb
 *后期做缓存
 */
public class BaseEnumUtil {

	
	/*@SuppressWarnings("unchecked")
	public static <K,E  extends BaseEnum<K>> List<BaseEnumEntity<K>> getEnumEntitys(Class<E> enumType){
		List<BaseEnumEntity<K>>  result=Lists.newArrayList();
		try {
			Method m = enumType.getMethod("values");
			E[] enumsArray = (E[])m.invoke(null, null);
			for(E e : enumsArray){
				result.add(new BaseEnumEntity<K>(e.getIndex(),e.getDescription(), e.toString()));
			}
		} catch (Exception e) {
			throw new ApplicationException("get enum by v",e);
		}
		
		return result;
	}*/
	
	@SuppressWarnings("unchecked")
	public static <K,E  extends BaseEnum<K>> List<E> getEnums(Class<E> enumType){
		try {
			Method m = enumType.getMethod("values");
			E[] enumsArray = (E[])m.invoke(null, null);
			return Lists.newArrayList(enumsArray);
		} catch (Exception e) {
			throw new ApplicationException("get enum by v",e);
		}
		
		
	}
	
	@SuppressWarnings("unchecked")
	public static <K,E extends BaseEnum<K>> E indexOf(Class<E> enumType,K index){
		Method m;
		try {
			m = enumType.getMethod("values");
			E[] list = (E[])m.invoke(null, null);
			for(E e : list){
				if(e.getId().equals(index)){
					return e;
				}
			}
		} catch (Exception e) {
			throw new ApplicationException("get enum by v",e);
		}
		return null;
	}
	
}
