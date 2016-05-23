package com.ks.protocol.vo.goods;

import java.util.List;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
/**
 * 获得游戏奖励
 * @author ks
 */
public class GainGameAwardVO extends Message{

	private static final long serialVersionUID = 1L;
	@FieldDesc(desc="获得的物品")
	private List<GoodsVO> goodses;
	@FieldDesc(desc="获得的物品")
	private GainAwardVO awards;
	public List<GoodsVO> getGoodses() {
		return goodses;
	}
	public void setGoodses(List<GoodsVO> goodses) {
		this.goodses = goodses;
	}
	public GainAwardVO getAwards() {
		return awards;
	}
	public void setAwards(GainAwardVO awards) {
		this.awards = awards;
	}
	
}
