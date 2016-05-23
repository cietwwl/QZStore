package com.ks.db.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import lombok.Data;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.object.CommonReward;
import com.ks.util.XyStringUtil;

/**
 * 用户记录
 *
 */
@Data
@DBBeanSet(tablename="t_user_record", primaryKey="id")
public class UserRecord {

	/**用户id*/
	@DBFieldSet(dbfname="id")
	private int id;
	/**已领取系统邮件ids*/
	@DBFieldSet(dbfname="sysMailIds")
	private String sysMailIds = "";
	/**通用奖励*/
	@DBFieldSet(dbfname="commonRewards")
	private String commonRewards = "";  
	/**首次充值*/
	@DBFieldSet(dbfname="firstRecharges")
	private String firstRecharges = "";
	/**试练副本挑战ids*/
	@DBFieldSet(dbfname="trialsIds")
	private String trialsIds = "";
	
	private List<Integer> sysMailList = new ArrayList<>();
	private Map<Integer, CommonReward> commonRewardMap = new HashMap<Integer, CommonReward>();
	private List<Integer> firstRechargeList = new ArrayList<>();
	private List<Integer> trialsIdList = new ArrayList<>();
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	/**
	 * 是否已领取系统邮件
	 */
	public boolean isReceiveSysMail(int id){
		return sysMailList.contains(id);
	}
	public void addReceiveSysMail(int id){
		sysMailList.add(id);
	}
	public void removeSysMail(Integer id){
		sysMailList.remove(id);
	}
	public void setSysMailIds(String sysMailIds){
		this.sysMailIds = sysMailIds;
		initSysMailList();
	}
	public String getSysMailIds(){
		return sysMailIds;
	}
	public void setCommonRewards(String value){
		this.commonRewards = value;
		initCommonRewardMap();
	}
	public String getCommonRewards(){
		return commonRewards;
	}
	private void initSysMailList(){
		if(sysMailIds != null && sysMailIds.length() > 0){
			sysMailList = XyStringUtil.parseList(sysMailIds, XyStringUtil.SPLIT_UNDERLINE);
		}else{
			sysMailList = new ArrayList<Integer>();
		}
	}
	public void initSysMailIds(){
		sysMailIds = XyStringUtil.parseString(sysMailList, XyStringUtil.JOIN_UNDERLINE);
	}
	private void initCommonRewardMap(){
		commonRewardMap = new ConcurrentHashMap<Integer, CommonReward>();
		if(commonRewards != null && commonRewards.length() > 0){
			List<List<Integer>> lists = XyStringUtil.parseLists(commonRewards, XyStringUtil.SPLIT_VERTICALLINE, XyStringUtil.SPLIT_UNDERLINE);
			for(List<Integer> list : lists){
				if(list.size() >= 2){
					commonRewardMap.put(list.get(0), new CommonReward(list.get(0), list.get(1)));
				}
			}
		}
	}
	public void initCommonRewards(){
		List<List<Integer>> lists = new ArrayList<>();
		for(CommonReward reward :  commonRewardMap.values()){
			List<Integer> list = new ArrayList<>();
			list.add(reward.getId());
			list.add(reward.getState());
			lists.add(list);
		}
		commonRewards = XyStringUtil.parseString(lists, XyStringUtil.JOIN_VERTICALLINE, XyStringUtil.JOIN_UNDERLINE);
	}
	public CommonReward getCommonReward(int id){
		return commonRewardMap.get(id);
	}
	public Set<Integer> getCommonRewardIds(){
		return commonRewardMap.keySet();
	}
	public void addCommonReward(CommonReward reward){
		commonRewardMap.put(reward.getId(), reward);
	}
	public void delCommonReward(int id){
		commonRewardMap.remove(id);
	}
	public void setFirstRecharges(String value){
		this.firstRecharges = value;
		initFirstRechargeList();
	}
	public String getFirstRecharges(){
		return firstRecharges;
	}
	private void initFirstRechargeList(){
		if(firstRecharges != null && firstRecharges.length() > 0){
			firstRechargeList = XyStringUtil.parseList(firstRecharges, XyStringUtil.SPLIT_UNDERLINE);
		}
	}
	public void initFirstRecharges(){
		this.firstRecharges = XyStringUtil.parseString(firstRechargeList, XyStringUtil.JOIN_UNDERLINE);
	}
	public boolean isFirstRecharge(int payId){
		return !firstRechargeList.contains(payId);
	}
	public void addFirstRecharge(int payId){
		firstRechargeList.add(payId);
	}
	
	public void setTrialsIds(String trialsIds){
		this.trialsIds = trialsIds;
		initTrialsIdList();
	}
	public String getTrialsIds(){
		initTrialsIds();
		return trialsIds;
	}
	private void initTrialsIds(){
		this.trialsIds = XyStringUtil.parseString(trialsIdList, XyStringUtil.JOIN_UNDERLINE);
	}
	private void initTrialsIdList(){
		this.trialsIdList = XyStringUtil.parseList(trialsIds, XyStringUtil.SPLIT_UNDERLINE);
	}
	public void addTrialsId(int id){
		if(!trialsIdList.contains(id)){
			trialsIdList.add(id);
		}
	}
	
}
