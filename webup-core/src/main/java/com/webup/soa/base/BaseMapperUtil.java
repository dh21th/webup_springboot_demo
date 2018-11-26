package com.webup.soa.base;

import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.List;
/**
 * dao工具类
 * 
 * @author cgb
 *
 * @param <K>
 * @param <T>
 */
public abstract class BaseMapperUtil{
	
	public static <K extends Serializable,E extends IdEntity<K>,Q extends BaseQueryParams,O extends IdEntity<K> >  PageResult<E> queryPageByParams(BaseMapper<K,E,O,Q> dao,Q  queryParams) {
		
		PageResult<E> result = new PageResult<E>();
		Long totalCount=dao.selectCountByParams(queryParams);
		List<E> records=null;
		if(totalCount!=null&&totalCount>0){
			records=dao.selectByParams(queryParams);
		}else{
			totalCount=0L;
			records= Lists.newArrayList();
		}
		
		result.setRecords(records);
		result.setTotalCount(totalCount);
		
		return result;
	}
	
	
	public static <K extends Serializable,E extends IdEntity<K>,Q extends BaseQueryParams,O extends IdEntity<K>>  List<E> queryByParams(BaseMapper<K,E,O,Q> dao,Q  queryParams) {
		
		List<E> records=dao.selectByParams(queryParams);
		return records;
	}
	public static <K extends Serializable,E extends IdEntity<K>,Q extends BaseQueryParams,O extends IdEntity<K>> Long  queryCountByParams(BaseMapper<K,E,O,Q> dao,Q  queryParams) {
		
		Long totalCount=dao.selectCountByParams(queryParams);
		return totalCount;
	}
	
	
	
	
	
}
