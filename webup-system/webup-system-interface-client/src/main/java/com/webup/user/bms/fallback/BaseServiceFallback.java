package com.webup.user.bms.fallback;

import com.webup.soa.base.BaseFeignClient;
import com.webup.soa.base.BaseQueryParams;
import com.webup.soa.base.IdEntity;
import com.webup.soa.base.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.List;

public class BaseServiceFallback<K extends Serializable,T extends IdEntity<K>,O extends IdEntity<K>,Q extends BaseQueryParams> implements BaseFeignClient<K,T,O,Q>{
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseServiceFallback.class);

    /**
     * 根据主键删除
     * @return
     */
    @Override
    public int removeById(K id){
        LOGGER.info("异常发生，进入fallback方法，接收的参数：");
        return 0;
    }

    /**
     * 根据主键查询
     * @param id 主键id
     * @return
     */
    @Override
    public T getById(K id){
        LOGGER.info("异常发生，进入fallback方法，接收的参数：");
        return null;
    }

    /**
     * 根据主键集合批量删除
     * @param ids 主键的集合
     * @return
     */
    @Override
    public int removeByIds(String[] ids){
        LOGGER.info("异常发生，进入fallback方法，接收的参数：");
        return 0;
    }

    /**
     * 全部插入
     * @param t 实体
     * @return
     */
    @Override
    public int  save(O t){
        LOGGER.info("异常发生，进入fallback方法，接收的参数：");
        return 0;
    }

    /**
     * 部分插入
     * @param t 实体
     * @return
     */
    @Override
    public int saveSelective(O t){
        LOGGER.info("异常发生，进入fallback方法，接收的参数：");
        return 0;
    }

    /**
     * 批量插入
     * @param list 实体的list集合
     * @return
     */
    @Override
    public int batchSave(List<O> list){
        LOGGER.info("异常发生，进入fallback方法，接收的参数： {},{}");
        return 0;
    }


    /**
     * 根据主键更新
     * @param t 实体
     * @return
     */
    @Override
    public int modifyById(O t){
        LOGGER.info("异常发生，进入fallback方法，接收的参数：");
        return 0;
    }

    /**
     * 查询数量
     * @param q 实体
     * @return
     */
    @Override
    public Long getRecordCount(Q q){
        LOGGER.info("异常发生，进入fallback方法，接收的参数：");
        return (long)0;
    }
    /**
     *
     * @param q
     * @return
     */
    @Override
    public PageResult<T> queryByParams(Q q){
        LOGGER.info("异常发生，进入fallback方法，接收的参数：");
        return null;
    }

    /**
     *
     * @param q
     * @return
     */
    @Override
    public List<T> listQueryByParams(Q q){
        LOGGER.info("异常发生，进入fallback方法，接收的参数：");
        return null;
    }

    /**
     *
     * @param q
     * @return
     */
    @Override
    public Long getCountByParams(Q q){
        return (long)0;
    }
}
