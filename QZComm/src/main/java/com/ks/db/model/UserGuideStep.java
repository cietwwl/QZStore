package com.ks.db.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.cache.JedisFieldSet;
import com.ks.util.XyStringUtil;

import lombok.Data;

@Data
@DBBeanSet(tablename="t_user_guide_step", primaryKey={"id"})
public class UserGuideStep implements Serializable{
	private static final long serialVersionUID = 1L;

	@DBFieldSet(dbfname="id")
	@JedisFieldSet()
	private int id;
	@DBFieldSet(dbfname="guide_ids")
	@JedisFieldSet()
	private String guideIds = "";
	@DBFieldSet(dbfname="create_time")
	@JedisFieldSet()
	private int createTime;
	@DBFieldSet(dbfname="update_time")
	@JedisFieldSet()
	private int updateTime;
	
	public List<Integer> guideList = new ArrayList<>();
	
	public void initGuideIds(){
		if(guideList != null){
			guideIds = XyStringUtil.parseString(guideList, XyStringUtil.JOIN_UNDERLINE);
		}else{
			guideIds = "";
		}
	}
	public void initGuideList(){
		if(guideIds != null){
			guideList = XyStringUtil.parseList(guideIds, XyStringUtil.SPLIT_UNDERLINE);
		}
	}
	public String getGuideIds(){
		initGuideIds();
		return guideIds;
	}
	public void setGuideIds(String guideIds){
		this.guideIds = guideIds;
		initGuideList();
	}
	public boolean hasGuide(int guideId){
		return guideList.contains(guideId);
	}
	public void addGuideId(int guideId){
		guideList.add(guideId);
	}

}
