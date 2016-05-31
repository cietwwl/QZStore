package com.web.db.bean;

import com.db.bean.BaseBean;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 权限
 *
 */
@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper=true)
@Data
public class SysJurisdictionInfo extends BaseBean {
	private String name;
	private String desc;
	private int parentId;
}
