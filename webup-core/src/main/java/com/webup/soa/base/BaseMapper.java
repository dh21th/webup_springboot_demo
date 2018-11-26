package com.webup.soa.base;

import java.io.Serializable;
import java.util.List;
/**
 * 最基本的增删改查  mapper
 * @author cgb
 *
 * @param <K> 主键类型
 * @param <T> 返回的实体类型
 * @param <O> 操作的实体类型
 * @param <Q> 查询的实体类型
 */
public interface BaseMapper<K extends Serializable,T extends IdEntity<K>,O extends IdEntity<K>,Q extends BaseQueryParams> {

	/**
	 * 根据主键删除
	 * @param k 主键
	 * @return
     */
	int deleteById(K k);

	/**
	 * 根据主键集合批量删除
	 * @param ids 主键的集合
	 * @return
	 */
	int deleteByIds(String[] ids);

	/**
	 * 全部插入
	 * @param t 实体
	 * @return
     */
	int  insert(O t);

	/**
	 * 部分插入
	 * @param t 实体
	 * @return
     */
	int insertSelective(O t);

	/**
	 * 批量插入
	 * @param list 实体的list集合
	 * @return
     */
	int batchInsert(List<O> list);

	/**
	 * 根据主键查询
	 * @param id 主键id
	 * @return
     */
	T selectById(K id);

	/**
	 * 根据主键更新
	 * @param t 实体
	 * @return
     */
	int updateById(O t);

	/**
	 * 查询数量
	 * @param t 实体
	 * @return
     */
	@Deprecated
	Long selectCount(O t);

	/**
	 *
	 * @param queryParams
     * @return
     */
	List<T> selectByParams(Q queryParams);

	/**
	 *
	 * @param queryParams
     * @return
     */
	Long selectCountByParams(Q queryParams);


}
