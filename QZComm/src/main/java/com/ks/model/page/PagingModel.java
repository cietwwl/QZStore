package com.ks.model.page;

import java.io.Serializable;
import java.util.List;
/**
 * 分页模型
 * @author ks
 */
public class PagingModel implements Serializable {
	private static final long serialVersionUID = 1L;
	/**数据条数*/
	private int dataCount;
	/**数据*/
	private List<? extends Serializable> data;
	public int getDataCount() {
		return dataCount;
	}
	public void setDataCount(int dataCount) {
		this.dataCount = dataCount;
	}
	public List<? extends Serializable> getData() {
		return data;
	}
	public void setData(List<? extends Serializable> data) {
		this.data = data;
	}
}
