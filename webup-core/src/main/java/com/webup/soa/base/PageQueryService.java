package com.webup.soa.base;


/**
 * 查询服务接口
 * 
 * 
 * @author cgb
 *
 */
public interface PageQueryService<Q extends BaseQueryParams,D> {
	PageResult<D> queryPageByParams(Q pageQueryParams);
}
