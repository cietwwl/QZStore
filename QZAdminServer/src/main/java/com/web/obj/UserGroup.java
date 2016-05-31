package com.web.obj;

import java.util.ArrayList;
import java.util.List;

import com.game.constant.WebConstant;
import com.web.db.bean.SysUserGroupInfo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=true)
@Data
public class UserGroup extends SysUserGroupInfo {
	private List<Integer> jlist = new ArrayList<Integer>();
	public UserGroup(SysUserGroupInfo info){
		this.setId(info.getId());
		this.setName(info.getName());
		this.setType(info.getType());
		this.setJurisdictions(info.getJurisdictions());
		this.setJlist(info.getJurisdictionList());
	}
	
	public boolean hasJurisdict(int jid){
		return getType() == WebConstant.USER_GROUP_TYPE_ADMIN || jlist.contains(jid);
	}
}
