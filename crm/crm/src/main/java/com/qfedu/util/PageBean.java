package com.qfedu.util;

import java.util.List;

/**
 * 分页器
 * @author 骆昊
 *
 * @param <E>
 */
public class PageBean<E> {
	private List<E> dataList;		// 数据
	private int currentPage;		// 当前页码
	private int pageSize;			// 页码大小
	private int totalPage;			// 总页数

	public PageBean() {
	}

	public PageBean(List<E> dataList, int currentPage, int pageSize, int totalPage) {
		this.dataList = dataList;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalPage = totalPage;
	}

	public List<E> getDataList() {
		return dataList;
	}

	public void setDataList(List<E> dataList) {
		this.dataList = dataList;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

}
