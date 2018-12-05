package com.webup.user.es.base;

import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.sort.SortBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.SearchQuery;

import java.io.Serializable;
import java.util.List;

public interface BaseElasticsearch <T, ID extends Serializable>{

    /**
     * 创建索引
     * @param  mapping mapping
     * @return boolean
     */
    boolean addIndex(XContentBuilder mapping);

    /**
     * 删除索引
     * @return boolean
     */
    boolean deleteIndex();

    /**
     * 创建索引
     * @return boolean
     */
    boolean indexExists();

    /**
     *  创建索引并添加文档
     * @throws Exception
     */
    boolean addDocument(T t) throws Exception;
    /**
     * 批量添加索引数据
     * @throws Exception
     */
    boolean bulkAddDocument(List<T> tList) throws Exception;

    /**设置自动提交文档
     * BulkProcessor
     * @throws Exception
     */
    boolean autoBulkAddDocument(List<T> tList) throws Exception;

    /**
     * 使用Bulk批量添加导入数据
     *
     */
    void importBulk(String absFileName);

    /**
     * 使用Bulk批量导出数据
     * @param  fileName fileName
     * @throws Exception
     */
    void exportBulk(String fileName) throws Exception;

    /**
     * 搜索
     * @param id 搜索
     * @return Iterable
     */
    T getById(ID id);

    /**
     * 删除
     * @param id 搜索
     * @return boolean
     */
    boolean deleteById(ID id);

    /**
     * 删除
     * @param queryBuilders 搜索
     */
    long deleteByQuery(List<QueryBuilder> queryBuilders);

    /**
     * 使用matchAllQuery删除所有文档
     */
    void deleteAll();

    /**
     * bulk批量通过指定id删除方法
     */
    boolean deleteByIds(List<ID> ids);

    /**
     * 更新文档
     * @throws Exception
     */
    boolean updateDocument(T t) throws Exception;

    /**
     * 更新文档
     * @throws Exception
     */
    boolean prepareUpdateDocument(T t) throws Exception;

    /**
     * 搜索
     * @param queryBuilder 搜索
     * @return Iterable
     */
    List<T> search(QueryBuilder queryBuilder, SortBuilder sort);

    /**
     * 搜索
     * @param queryBuilder 搜索
     * @param pageable pageable
     * @return Page
     */
    Page<T> searchOfPage(QueryBuilder queryBuilder, Pageable pageable);

    /**
     * 搜索
     * @param queryBuilder 搜索
     * @return Page
     */
    Page<T> searchOfPage(SearchQuery queryBuilder);

    /**
     * 搜索
     * @param obj 搜索
     * @param key key
     * @param pageable pageable
     * @return Page
     */
    Page<T> searchSimilar(T obj, String[] key, Pageable pageable);

    /**
     * 刷新
     */
    void refresh();

    /**
     * 获取实体
     * @return Class
     */
    Class<T> getEntityClass();

    /**
     * 搜索
     * @param sort sort
     * @return Iterable
     */
    List<T> findAll(SortBuilder sort);

    // OK
    List<T> spanQuery();

    /**
     * MultiGetResponse  查询多个xxx的值
     * <a href='https://www.elastic.co/guide/en/elasticsearch/client/java-api/5.5/java-docs-multi-get.html'>
     * @throws Exception
     */
    List<T> multiGetResponse() throws Exception;
    /**
     * MatchPhrasePrefixQueryBuilder  为提供的字段名称和文本创建一个类型为“PHRASE_PREFIX”的匹配查询。
     * @throws Exception
     */
    List<T> matchPhrasePrefixQueryBuilder() throws Exception;

    /**
     * 取查询结果总和count
     */
    void countSum();

    /**
     * MultiSearchResponse 多字段检索
     */
    void multiSearchResponse();

    /**
     * 复杂查询
     */
    void complexSearch1();
    /**
     * 复杂查询2
     */
    void complexSearch2();

    /**
     * 聚合求和sum
     */
    void getPlatformZuOrdersTotalAmount();

    /**
     * 搜索
     * @param pageable pageable
     * @return Page
     */
    Page<T> findAll(Pageable pageable);

    /**
     * 使用Scroll方法分页
     */
    void queryPageScroll();

    /**
     * 分页
     * @throws Exception
     */
    void fenye() throws Exception;

    /**
     * 高亮
     * @throws Exception
     */
    void highlighter() throws Exception;

    /**
     * AnalyzeRequest 分词器
     * <a href='https://www.elastic.co/guide/cn/elasticsearch/guide/current/standard-tokenizer.html'>
     * @throws Exception
     */
    void analyzeRequest() throws Exception;
}
