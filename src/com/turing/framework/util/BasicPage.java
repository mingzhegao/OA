package com.turing.framework.util;

import java.util.List;

public abstract class BasicPage {

	private int pageNo = 1;		//第几页
	private int pageSize = 5;	//每页多少行数据
	private int rowCount = 0;	//总记录数
	private int pageCount = 0;	//到底分几页
	private int start;		//从第几条开始查询 (pageNo-1)*pageSize
	private int end;		//查询到第几条  pageNo*pageSize
	private List list;		//查询的分页数据
	
	public int getPageNo() {
		if (pageCount!=0 && pageNo>pageCount) {
			pageNo=pageCount;
		}
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
		setPageCount(this.rowCount / this.pageSize + (this.rowCount % this.pageSize == 0 ? 0 : 1));
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	//重写getStart方法，获取从第几条开始查询
	public int getStart() {
		return (this.getPageNo()-1)*pageSize;
	}
	public void setStart(int start) {
		this.start = start;
	}
	//重写getEnd方法，获取查询到第几条
	public int getEnd() {
		return this.getPageNo()*pageSize;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
}
