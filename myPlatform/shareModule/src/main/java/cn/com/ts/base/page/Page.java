package cn.com.ts.base.page;

import java.util.List;

public interface Page<T> {
	
	public int getCurrentPage();

	public void setCurrentPage(int currentPage);

	public int getPageSize();

	public void setPageSize(int pageSize);

	public int getTotalRecord();

	public void setTotalRecord(int totalRecord);

	public int getTotalPage();

	public void setTotalPage(int totalPage);

	public int getCurrentRecord();

	public void setCurrentRecord(int currentRecord);

	public List<T> getList();

	public void setList(List<T> list);

}
