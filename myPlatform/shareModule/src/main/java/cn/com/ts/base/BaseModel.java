package cn.com.ts.base;

import cn.com.ts.base.page.PageBean;

public class BaseModel implements java.io.Serializable {

	PageBean page = new PageBean();

	public PageBean getPage() {
		return page;
	}

	public void setPage(PageBean page) {
		this.page = page;
	}

}
