package sems.vo;

public class AjaxResult {
	String 	status;
	Object 	data;
	int 		pageSize;
	
	
	public int getPageSize() {
		return pageSize;
	}
	public AjaxResult setPageSize(int pageSize) {
		this.pageSize = pageSize;
		return this;
	}
	public String getStatus() {
		return status;
	}
	public AjaxResult setStatus(String status) {
		this.status = status;
		return this;
	}
	public Object getData() {
		return data;
	}
	public AjaxResult setData(Object data) {
		this.data = data;
		return this;
	}
	
}
