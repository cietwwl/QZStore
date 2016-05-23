package com.ks.protocol.vo.reward;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.ks.protocol.Message;

@EqualsAndHashCode(callSuper=true)
@Data
public class RewardVO extends Message{
	private static final long serialVersionUID = 1L;
	private List<ItemEffectVO> effects = new ArrayList<>();

}
