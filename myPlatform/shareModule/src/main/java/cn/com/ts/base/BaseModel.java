package cn.com.ts.base;

import cn.com.ts.base.page.Page;

public class BaseModel<T> {

	Page<T> page;
	
	public Page<T> getPage() {
		return page;
	}

	public void setPage(Page<T> page) {
		this.page = page;
	}

}
