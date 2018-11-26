package com.webup.soa.base;

import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * 抽象service类
 *
 */
@Transactional
public abstract class AbstractBaseService<K extends Serializable,T extends IdEntity<K>,O extends IdEntity<K>,Q extends BaseQueryParams> implements PageQueryService<Q,T> {

	protected  Logger logger=LoggerFactory.getLogger(this.getClass());

	@Override
	public PageResult<T> queryPageByParams(Q pageQueryParams){
		return null;
	}

	public PageResult<T> convertPageResult(List<T> list){
		PageInfo<T> pageInfo = new PageInfo(list);
		PageResult<T> pageResult = new PageResult<>();
		pageResult.setRecords(pageInfo.getList());
		pageResult.setTotalCount(pageInfo.getTotal());
		return pageResult;
	}
	public PageResult convertPageResultFromObject(List list){
		PageInfo pageInfo = new PageInfo(list);
		PageResult pageResult = new PageResult<>();
		pageResult.setRecords(pageInfo.getList());
		pageResult.setTotalCount(pageInfo.getTotal());
		return pageResult;
	}

	public int removeById(K id) {
		return getMapper().deleteById(id);
	}

	public int removeByIds(String[] ids){return getMapper().deleteByIds(ids);}

	public int save(O o) {
		return getMapper().insert(o);
	}

	public int saveSelective(O o) {
		return getMapper().insertSelective(o);
	}

	public int batchSave(List<O> list) {
		return getMapper().batchInsert(list);
	}


	@Transactional(readOnly = true)
	public T getById(K id) {
		return getMapper().selectById(id);
	}

	public int modifyById(O o) {
		return getMapper().updateById(o);
	}

	@Transactional(readOnly = true)
	public Long getRecordCount(Q queryParams) {
		return getMapper().selectCountByParams(queryParams);
	}

	@Transactional(readOnly = true)
	public PageResult<T> queryByParams(Q queryParams) {
		List<T> list = getMapper().selectByParams(queryParams);
		return convertPageResult(list);
	}

	@Transactional(readOnly = true)
	public List<T> listQueryByParams(Q queryParams) {
		return getMapper().selectByParams(queryParams);
	}


	@Transactional(readOnly = true)
	public Long getCountByParams(Q queryParams) {
		return getMapper().selectCountByParams(queryParams);
	}

	protected abstract BaseMapper<K,T,O,Q> getMapper();
}

