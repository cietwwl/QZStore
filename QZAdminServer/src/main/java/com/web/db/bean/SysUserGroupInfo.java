package com.web.db.bean;

import java.util.List;

import com.db.bean.BaseBean;
import com.utils.StringUtil;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户分组
 *
 */
@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper=true)
@Data
public class SysUserGroupInfo extends BaseBean {
	private String name;  //分组名称
	private int type;  //1超级用户组、2普通用户组
	private String jurisdictions;  //权限 
	public List<Integer> getJurisdictionList(){
		return StringUtil.parseList(jurisdictions, ",");
	}
}
