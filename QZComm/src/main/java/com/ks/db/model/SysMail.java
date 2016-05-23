package com.ks.db.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.constant.SystemConstant;
import com.ks.util.XyStringUtil;
import com.ks.util.XyTimeUtil;


/**
 * 系统邮件
 *
 */
@Data
@DBBeanSet(tablename="t_sys_mail", primaryKey="id")
public class SysMail {
	@DBFieldSet(dbfname="id")
	private int id;   //邮件自增长id
	@DBFieldSet(dbfname="partner")
	private int partner;  //平台编号
	@DBFieldSet(dbfname="sendType")
	private int sendType;  //发送类型:1指定玩家，2当前在线，3指定时间段, 4当前全服，5长期全服
	@DBFieldSet(dbfname="endId")
	private int endId;    //结束id
	@DBFieldSet(dbfname="uids")
	private String uids = "";   //用户id
	@DBFieldSet(dbfname="title")
	private String title = "";  //标题
	@DBFieldSet(dbfname="content")
	private String content = "";   //内容
	@DBFieldSet(dbfname="items")
	private String items = "";   //物品(type_id_num_level|type_id_num_level)
	@DBFieldSet(dbfname="startTime")
	private int startTime;   //开始时间
	@DBFieldSet(dbfname="endTime")
	private int endTime;   //结束时间
	@DBFieldSet(dbfname="time")
	private int time;   //发送时间
	
	public SysMail(){
		this.time = XyTimeUtil.getNowSecond();
	}
	public void initUids(List<Integer> list){
		this.uids = XyStringUtil.parseString(list, XyStringUtil.JOIN_UNDERLINE);
	}
	public boolean isGain(int uid){
		if(sendType == SystemConstant.SYS_MAIL_TYPE_SERVER_FOREVER){
			return true;
		}else if(sendType == SystemConstant.SYS_MAIL_TYPE_CUR_SERVER){
			return uid <= endId;
		}else if(sendType == SystemConstant.SYS_MAIL_TYPE_TIMES){
			int now = XyTimeUtil.getNowSecond();
			return startTime < now && now < endTime; 
		}else if(sendType == SystemConstant.SYS_MAIL_TYPE_LOGIN || sendType == SystemConstant.SYS_MAIL_TYPE_USER){
			return XyStringUtil.parseList(uids, XyStringUtil.SPLIT_UNDERLINE).contains(uid);
		}
		return false;
	}
	public List<Goods> getGoods(){
		List<Goods> list = new ArrayList<Goods>();
		if(items.length() > 0){
			List<List<Integer>> lists = XyStringUtil.parseLists(items, XyStringUtil.SPLIT_VERTICALLINE, XyStringUtil.SPLIT_UNDERLINE);
			for(List<Integer> ids : lists){
				if(ids.size() >= 3){
					list.add(Goods.createGoods(ids.get(1), ids.get(0), ids.get(2), ids.get(3)));
				}
			}
		}
		return list;
	}
}
