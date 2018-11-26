package com.webup.soa.utils;

import com.github.pagehelper.PageInfo;
import com.webup.soa.common.Page;

/******************************************
 * @author: 大鹏 (xupenghong@elion.com.cn)
 * @createDate: 2017/8/23
 * @company: (C) Copyright 亿兆华盛 2017
 * @since: JDK 1.8
 * @projectName:IntelliJ IDEA
 * @Description:类功能描述
 ******************************************/
public class PageUtil {

    public static Page packagePage(PageInfo pageInfo) {
        Page page = new Page();
        page.setCurrentPage(pageInfo.getPageNum());
        page.setPageSize(pageInfo.getPageSize());
        page.setTotalSize(pageInfo.getTotal());
        page.setResults(pageInfo.getList());
        page.setTotalPages(pageInfo.getPages());
        page.setSize(pageInfo.getList().size());
        return page;
    }

}
