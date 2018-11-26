package com.webup.soa.base;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.List;

/**
 * 最基本的增删改查  service
 * @author cgb
 *
 * @param <K> 主键类型
 * @param <T> 返回的实体类型
 * @param <O> 操作的实体类型
 * @param <Q> 查询的实体类型
 */
public interface BaseFeignClient<K extends Serializable,T extends IdEntity<K>,O extends IdEntity<K>,Q extends BaseQueryParams> {

    /**
     * 根据主键删除
     * @param k 主键
     * @return
     */
    @RequestMapping("/removeById")
    public int removeById(@RequestParam("k") K k);

    /**
     * 根据主键集合批量删除
     * @param ids 主键的集合
     * @return
     */
    @RequestMapping("/removeByIds")
    int removeByIds(@RequestParam("ids") String[] ids);

    /**
     * 全部插入
     * @param t 实体
     * @return
     */
    @RequestMapping("/save")
    public int  save(@RequestBody O t);

    /**
     * 部分插入
     * @param t 实体
     * @return
     */
    @RequestMapping("/saveSelective")
    public int saveSelective(@RequestBody O t);

    /**
     * 批量插入
     * @param list 实体的list集合
     * @return
     */
    @RequestMapping("/batchSave")
    public int batchSave(@RequestBody List<O> list);

    /**
     * 根据主键查询
     * @param id 主键id
     * @return
     */
    @RequestMapping("/getById")
    public T getById(@RequestParam("id") K id);

    /**
     * 根据主键更新
     * @param t 实体
     * @return
     */
    @RequestMapping("/modifyById")
    public int modifyById(@RequestBody O t);

    /**
     * 查询数量
     * @param t 实体
     * @return
     */
    @RequestMapping("/getRecordCount")
    public Long getRecordCount(@RequestBody Q t);

    /**
     *
     * @param queryParams
     * @return
     */
    @RequestMapping("/queryByParams")
    public PageResult<T> queryByParams(@RequestBody Q queryParams);

    /**
     *
     * @param queryParams
     * @return
     */
    @RequestMapping("/listQueryByParams")
    public List<T> listQueryByParams(@RequestBody Q queryParams);

    /**
     *
     * @param queryParams
     * @return
     */
    @RequestMapping("/getCountByParams")
    public Long getCountByParams(@RequestBody Q queryParams);

}
