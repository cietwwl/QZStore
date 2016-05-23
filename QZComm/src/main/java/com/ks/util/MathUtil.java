package com.ks.util;

import java.util.List;
import java.util.Random;

import com.ks.constant.SystemConstant;
import com.ks.model.fight.FightModel;

public class MathUtil {
	private static Random random = new Random();
	/**
	 * 随机出0-n的数(不包含n)
	 * @param n
	 * @return
	 */
	public static int nextInt(int n){
		return random.nextInt(n);
	}
	
	/**
	 * 区间[start, end]随机取值
	 */
	public static int scopeInt(int start, int end){
		if(start < end){
			return random.nextInt(end - start + 1) + start;
		}else if(start == end){
			return random.nextInt(end + 1);
		}
		return 0;
	}
	
	/**
	 * 区间取值
	 * @param str=start_end
	 * @return
	 */
	public static int scopeInt(String str){
		List<Integer> list = XyStringUtil.parseList(str, XyStringUtil.SPLIT_UNDERLINE);
		if(list.size() >= 2){
			return scopeInt(list.get(0), list.get(1));
		}
		return 0;
	}
	
	/**
	 * 得到战斗力
	 * @param models
	 * @return
	 */
	public static int getFighting(List<FightModel> models){
		int fighting = 0;
		for (FightModel fd:models) {
//			String str = "攻击:" + fd.getRealAtk() + ",攻击次数:" + fd.getRealAtkCount() + ",血量:" + fd.getRealMaxHp() + ",品质:" + fd.getQuality() + ",技能:" + fd.getSkillNum();
			fighting+=fd.getRealAtk()*fd.getRealAtkCount()*2+fd.getRealMaxHp()*1+fd.getQuality()*100+(fd.getSkillNum()-1)*200;
//			System.err.println(str);
		}
		return fighting;
	}
	
	/**
	 * 购买体力价格
	 * @param number
	 * @return
	 */
	public static int getBuyStaminaPrice(byte number){
		int money = (int) (20 * Math.pow(2, Math.ceil((number / 2d)) - 1));
		return money > SystemConstant.USER_BUY_STAMINA_MAX_DIAMOND ? SystemConstant.USER_BUY_STAMINA_MAX_DIAMOND : money;
	}
	
	/**
	 * 购买金币价格
	 * @param number
	 * @return
	 */
	public static int getBuyGoldPrice(byte number){
		int money = (int) (10 * Math.pow(2, Math.ceil((number / 2d)) - 1));
		return money > SystemConstant.USER_BUY_GOLD_MAX_DIAMOND ? SystemConstant.USER_BUY_GOLD_MAX_DIAMOND : money;
	}
	

	/**
	 * 购买武道大会次数价格
	 * @param buyCount
	 * @return
	 */
	public static final int getBuyMartialWayCountPrice(int number){
		if(number == 1){
			return 50;
		}else if(number == 2){
			return 100;
		}else if(number == 3){
			return 200;
		}else if(number == 4){
			return 210;
		}else if(number == 5){
			return 220;
		}else if(number == 6){
			return 230;
		}else if(number == 7){
			return 240;
		}else if(number == 8){
			return 250;
		}else if(number == 9){
			return 260;
		}
		return 270;
	}
}
