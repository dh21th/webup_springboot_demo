package com.webup.soa.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.List;

/**
 *
 * 抽象service类
 * //  implements PageQueryService<Q,T>
 */
@Transactional
public abstract class AbstractBaseClient<K extends Serializable,T extends IdEntity<K>,O extends IdEntity<K>,Q extends BaseQueryParams> {

	protected  Logger logger=LoggerFactory.getLogger(this.getClass());

	public PageResult<T> convertPageResult(List<T> list){
		PageInfo<T> pageInfo = new PageInfo(list);
		PageResult<T> pageResult = new PageResult<>();
		pageResult.setRecords(pageInfo.getList());
		pageResult.setTotalCount(pageInfo.getTotal());
		return pageResult;
	}

	@RequestMapping("/removeById")
	public int removeById(@RequestParam("id") K id) {
		return getService().removeById(id);
	}

	@RequestMapping("/removeByIds")
	public int removeByIds(@RequestParam("ids") String[] ids){return getService().removeByIds(ids);}

	@RequestMapping("/save")
	public int save(@RequestBody O o) {
		return getService().save(o);
	}

	@RequestMapping("/saveSelective")
	public int saveSelective(@RequestBody O o) {
		return getService().saveSelective(o);
	}

	@RequestMapping("/batchSave")
	public int batchSave(@RequestBody List<O> list) {
		return getService().batchSave(list);
	}

	@RequestMapping("/getById")
	@Transactional(readOnly = true)
	public T getById(@RequestParam("id") K id) {
		return getService().getById(id);
	}

	@RequestMapping("/modifyById")
	public int modifyById(@RequestBody O o) {
		return getService().modifyById(o);
	}

	@RequestMapping("/getRecordCount")
	@Transactional(readOnly = true)
	public Long getRecordCount(@RequestBody Q queryParams) {
		return getService().getRecordCount(queryParams);
	}

	@RequestMapping("/queryByParams")
	@Transactional(readOnly = true)
	public PageResult<T> queryByParams(@RequestBody Q queryParams) {
		if(null!=queryParams.getPageNo() && null!=queryParams.getPageSize()){
			PageHelper.startPage(queryParams.getPageNo(),queryParams.getPageSize());
		}
		return getService().queryByParams(queryParams);
	}

	@RequestMapping("/listQueryByParams")
	@Transactional(readOnly = true)
	public List<T> listQueryByParams(@RequestBody Q queryParams) {
		return getService().listQueryByParams(queryParams);
	}


	@RequestMapping("/getCountByParams")
	@Transactional(readOnly = true)
	public Long getCountByParams(@RequestBody Q queryParams) {
		return getService().getCountByParams(queryParams);
	}

	protected abstract BaseService<K,T,O,Q> getService();


}
