package com.web.db.bean;

import com.db.bean.BaseBean;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 权限请求
 *
 */
@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper=true)
@Data
public class SysRequestInfo extends BaseBean {
	private String name;   //权限名称
	private String url;	//权限地址
	private int jurisdictionId;  //权限id
}
