package com.ks.protocol.vo.fight;

import java.util.List;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
import com.ks.protocol.vo.reward.ItemEffectVO;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 战斗结果
 * @author ks
 */
@EqualsAndHashCode(callSuper=true)
@Data
public class FightResultVO extends Message {
	private static final long serialVersionUID = 1L;
	@FieldDesc(desc="星级")
	private int star;
	@FieldDesc(desc="获得副本奖励")
	private List<ItemEffectVO> rewards;
	@FieldDesc(desc="掉落物品")
	private List<ItemEffectVO> drops;
	
}
