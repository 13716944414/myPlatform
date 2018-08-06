package cn.com.ts.base;

import java.util.List;

public class PageBean<T> {

	// 已知数据
	private int currentPage;//当前页码,页面传参
	
	private int pageSize;//每页显示记录数,页面传参
	
	private int totalRecord;//总记录数,通过数据库查询得到
	
	// 需要计算得来
	private int totalPage;//总页数, totalRecord / pageSize
	
	private int currentRecord;//当前页记录起始索引,也就是在数据库中要从第几行开始拿数据
	
	private List<T> list;//查询的结果集

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

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		if(this.totalRecord % this.pageSize == 0){
			this.totalPage = this.totalRecord / this.pageSize;
		}else{
			this.totalPage = this.totalRecord / this.pageSize + 1;
		}
	}

	public int getCurrentRecord() {
		return currentRecord;
	}

	public void setCurrentRecord(int currentRecord) {
		if(this.currentPage <= 1){
			this.currentRecord = 0;
		}else{
			this.currentRecord = (this.currentPage - 1) * this.pageSize;
		}
		
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
}
