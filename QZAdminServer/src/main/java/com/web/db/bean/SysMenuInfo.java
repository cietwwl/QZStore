package com.web.db.bean;

import com.db.bean.BaseBean;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 菜单
 *
 */
@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper=true)
@Data
public class SysMenuInfo extends BaseBean {
	private int parentId;  //父ID
	private String name;   //菜单名称
	private String url;  //菜单请求地址
	private int enable;   //是否启用(不启用不显示
	
}
