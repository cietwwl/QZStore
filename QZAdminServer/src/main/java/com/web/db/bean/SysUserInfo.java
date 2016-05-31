package com.web.db.bean;

import com.db.bean.BaseBean;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户
 *
 */
@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper=true)
public class SysUserInfo extends BaseBean {
	private String username;  //用户名
	private String password;  //密码
	private int userGroupId;  //用户分组id
	private String note = "";   //备注
}
