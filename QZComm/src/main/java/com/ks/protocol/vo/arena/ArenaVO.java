package com.ks.protocol.vo.arena;

import java.util.ArrayList;
import java.util.List;

import com.ks.db.model.Arena;
import com.ks.db.model.ArenaShopping;
import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.vo.user.UserBaseinfoVO;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 竞技场VO
 * @author ks
 */
@EqualsAndHashCode(callSuper=true)
@Data
public abstract class ArenaVO extends Message {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc(desc="用户编号")
	private int userId;
	@FieldDesc(desc="cd时间")
	private long cdTime;
//	@FieldDesc(desc="购买挑战次数")
//	private int buyCount;
//	@FieldDesc(desc="刷新商店次数")
//	private int refreshCount;
	@FieldDesc(desc="商店物品")
	private List<ArenaShoppingVO> shopping;
//	@FieldDesc(desc="挑战次数")
//	private int challengeCount;
	@FieldDesc(desc="勇气值")
	private int valour;
	/**用户基本信息*/
	private UserBaseinfoVO info;
	
	public int getValour() {
		return valour;
	}
	public void setValour(int valour) {
		this.valour = valour;
	}
	public void init(Arena o){
		this.userId = o.getUserId();
//	    this.buyCount=o.getBuyCount();
//	    this.refreshCount=o.getRefreshCount();
//		this.challengeCount=o.getChallengeCount();
	    if(shopping==null){
	    	shopping=new ArrayList<ArenaShoppingVO>();
	    }
		this.cdTime = o.getCdTime().getTime();
		for (ArenaShopping as:o.getShoppingList()) {
			ArenaShoppingVO vo= MessageFactory.getMessage(ArenaShoppingVO.class);
			vo.init(as);
			shopping.add(vo);
		}
		this.valour=o.getValour();
	}
	
}
