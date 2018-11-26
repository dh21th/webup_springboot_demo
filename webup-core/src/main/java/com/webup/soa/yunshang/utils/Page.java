package com.webup.soa.yunshang.utils;

import java.io.Serializable;
import java.util.List;

public class Page implements Serializable {
	private static final long serialVersionUID = 5427703687931679548L;
	private List<?> results; //结果集
	private int pageNum;// 第几页
	private int pages;// 总页数
	private int pageSize;// 每页记录数
	private long totalSize;//总记录数
	private int statusCode = 200;
	private int size;// 当前页的数量 <= pageSize，该属性来自ArrayList的size属性

	public Page(){}

	/**
	 * 包装Page对象，因为直接返回Page对象，在JSON处理以及其他情况下会被当成List来处理，
	 * 而出现一些问题。
	 * @param list          page结果
	 */
	public Page(List<?> list) {
		if (list instanceof com.github.pagehelper.Page) {
			com.github.pagehelper.Page page = (com.github.pagehelper.Page) list;
			this.pageNum = page.getPageNum();
			this.pageSize = page.getPageSize();
			this.totalSize = page.getTotal();
			this.pages = page.getPages();
			this.results = page;
			this.size = page.size();
		}
	}

	public Page(int pageNum, int pageSize, int pages, List<?> results, int totalSize) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.pages = pages;
		this.results = results;
		this.totalSize = totalSize;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public List<?> getResults() {
		return results;
	}

	public void setResults(List<?> results) {
		this.results = results;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(long totalSize) {
		this.totalSize = totalSize;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Page{" +
				"results=" + results +
				", pageNum=" + pageNum +
				", pages=" + pages +
				", pageSize=" + pageSize +
				", totalSize=" + totalSize +
				", statusCode=" + statusCode +
				", size=" + size +
				'}';
	}
}