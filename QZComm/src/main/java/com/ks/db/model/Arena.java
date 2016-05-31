package com.ks.db.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.type.TypeReference;

import lombok.Data;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.util.JSONUtil;
/**
 * 竞技场
 * @author ks
 */
@DBBeanSet(tablename="t_arena", primaryKey={"user_id"})
@Data
public class Arena implements Serializable {
	protected static final long serialVersionUID = 1L;
	
	/**用户编号*/
	@DBFieldSet(dbfname="user_id")
	protected int userId;
	/**排名*/
	protected int rank;
	/**胜利次数*/
	@DBFieldSet(dbfname="win_count")
	protected int winCount;
	/**创建时间*/
	@DBFieldSet(dbfname="create_time")
	protected Date createTime = new Date();
	/**修改时间*/
	@DBFieldSet(dbfname="update_time")
	protected Date updateTime = new Date();
	/**勇气值*/
	@DBFieldSet(dbfname="valour")
	protected int valour;
	/**连胜场次*/
	@DBFieldSet(dbfname="streak_win")
	protected int streakWin;
	/**最大连胜场次*/
	@DBFieldSet(dbfname="max_win_streak")
	protected int maxWinStreak;
	/**商店物品*/
	@DBFieldSet(dbfname="shopping")
	protected String shopping;
	/**是否是第一次*/
	@DBFieldSet(dbfname="is_first")
	protected int isFirst;
	/**cd时间*/
	@DBFieldSet(dbfname="cd_time")
	protected Date cdTime = new Date();
	
	@JsonIgnore
	private List<ArenaShopping> shoppingList;
	
	private void initShoppingList(){
		shoppingList = JSONUtil.toObject(shopping, new TypeReference<List<ArenaShopping>>(){});
	}
	
	private void initShoppings(){
		shopping = JSONUtil.toJson(shoppingList);
	}

	public String getShopping() {
		initShoppings();
		return shopping;
	}

	public void setShopping(String shopping) {
		this.shopping = shopping;
		initShoppingList();
	}
	
	/**
	 * 刷新对手的条件
	 * 
	 * @param level
	 * @return
	 */
	public static int[] getCondition(int level){
		int[] condition=null;
		if(level <=45){
			condition=new int[]{1000,1000,1000};
		}else if(level<=76){
			condition=new int[]{1000,1000,1000};
		}else{
			condition=new int[]{1000,1000,1000};
		}
		return condition;	
	}
	
}
