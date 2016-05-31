package com.ks.db.model;

import java.io.Serializable;
import java.util.Date;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.constant.SystemConstant;
import com.ks.exceptions.GameException;
import com.ks.util.Calculate;

import lombok.Data;
/**
 * 用户探索
 * @author ks
 */
@Data
@DBBeanSet(tablename="t_user_explore", primaryKey={"user_id", "explore_id"})
public class UserExplore implements Serializable {
	private static final long serialVersionUID = 1L;
	/**用户编号*/
	@DBFieldSet(dbfname="user_id")
	private int userId;
	/**探索编号*/
	@DBFieldSet(dbfname="explore_id")
	private int exploreId;
	/**用户英雄编号*/
	@DBFieldSet(dbfname="user_hero_id")
	private int userHeroId;
	/**探索类型*/
	@DBFieldSet(dbfname="explore_type")
	private int exploreType;
	/**状态*/
	@DBFieldSet(dbfname="state")
	private int state;
	/**结束时间*/
	@DBFieldSet(dbfname="end_time")
	private Date endTime = new Date();
	/**创建时间*/
	@DBFieldSet(dbfname="create_time")
	private Date createTime = new Date();
	/**修改时间*/
	@DBFieldSet(dbfname="update_time")
	private Date updateTime = new Date();
	
	/**
	 * 获得探索时间
	 * @param exploreType 探索类型
	 * @return 探索时间 毫秒
	 */
	public static long getExploreTime(int exploreType){
		switch (exploreType) {
		case SystemConstant.EXPLORE_TYPE_1_HOUR:
			return 1*60*60*1000L;
		case SystemConstant.EXPLORE_TYPE_3_HOUR:
			return 3*60*60*1000L;
		case SystemConstant.EXPLORE_TYPE_10_HOUR:
			return 10*60*60*1000L;
		case SystemConstant.EXPLORE_TYPE_20_HOUR:
			return 20*60*60*1000L;
		default:
			throw new GameException(GameException.CODE_参数错误, "");
		}
	}
	/**
	 * 获得探索奖励数量
	 * @param exploreType 探索类型
	 * @return 探索奖励数量
	 */
	public static int getExploreAwardNum(int exploreType){
		switch (exploreType) {
		case SystemConstant.EXPLORE_TYPE_1_HOUR:
			return Calculate.randomContains(2, 3);
		case SystemConstant.EXPLORE_TYPE_3_HOUR:
			return Calculate.randomContains(3, 5);
		case SystemConstant.EXPLORE_TYPE_10_HOUR:
			return Calculate.randomContains(6, 8);
		case SystemConstant.EXPLORE_TYPE_20_HOUR:
			return Calculate.randomContains(8, 10);
		default:
			throw new GameException(GameException.CODE_参数错误, "");
		}
	}
	/**
	 * 获得探索数值
	 * @param heroQuality 英雄品质
	 * @return 探索数组
	 */
	public static int getExploreArray(int heroQuality){
		if(heroQuality<4){
			return 1;
		}else if(heroQuality<7){
			return 2;
		}else{
			return 3;
		}
	}
	/**
	 * 获得探索需要等级
	 * @param exploreId 探索编号
	 * @return 需要等级
	 */
	public static int getExploreLevel(int exploreId){
		switch (exploreId) {
		case 1:
			return 10;
		case 2:
			return 30;
		case 3:
			return 60;
		default:
			throw new GameException(GameException.CODE_参数错误, "");
		}
	}
}
