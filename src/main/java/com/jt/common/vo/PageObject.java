package com.jt.common.vo;
import java.io.Serializable;
import java.util.List;
/**
 * VO: Value Object
 * 用于封装当前页数据以及分页信息
 */
public class PageObject<T> implements Serializable {
	private static final long serialVersionUID = 6780580291247550747L;
	/** 当前页码 */
	private Integer pageCurrent = 1;
	/** 页面大小(每页最多显示多少条记录) */
	private Integer pageSize = 3;
	/** 总记录数 */
	private Integer rowCount;
	/** 总页数 */
	private Integer pageCount;
	/** 当前页实体数据 */
	private List<T> records;
	public Integer getPageCurrent() {
		return pageCurrent;
	}
	public void setPageCurrent(Integer pageCurrent) {
		this.pageCurrent = pageCurrent;
	}
	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getRowCount() {
		return rowCount;
	}

	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}

	public Integer getPageCount() {
		pageCount = rowCount / pageSize;
		if (rowCount % pageSize != 0) {
			pageCount++;
		}
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public List<T> getRecords() {
		return records;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}
	@Override
	public String toString() {
		return "PageObject [pageCurrent=" + pageCurrent + ", pageSize=" + pageSize + ", rowCount=" + rowCount
				+ ", pageCount=" + pageCount + ", records=" + records + "]";
	}

}
