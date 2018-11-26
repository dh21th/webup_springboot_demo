package com.webup.soa.common;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/******************************************
 * @author: 大鹏 (xupenghong@elion.com.cn)
 * @createDate: 2017/10/23
 * @company: (C) Copyright 亿兆华盛 2017
 * @since: JDK 1.8
 * @projectName:IntelliJ IDEA
 * @Description:类功能描述
 ******************************************/
@Data
@ToString
public class Page<T> implements Serializable {

    private List<T> results;    //  结果集

    private int currentPage;    // 第几页

    private int totalPages;     // 总页数

    private int pageSize;       // 每页记录数

    private long totalSize;     //  总记录数

    private int size;           // 当前页的数量 <= pageSize，该属性来自ArrayList的size属性

}
