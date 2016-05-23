package com.ks.protocol.vo.guild;

import java.util.List;

import com.ks.db.model.GuildAccuse;
import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;

public abstract class GuildAccuseVO extends Message {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc(desc="发起人")
	private int originator;
	@FieldDesc(desc="玩家名")
	private String playerName;
	@FieldDesc(desc="响应人")
	private List<Integer> resper;
	
	public void init(GuildAccuse o){
		this.originator = o.getOriginator();
		this.playerName = o.getPlayerName();
		this.resper = o.getResperList();
	}

	public int getOriginator() {
		return originator;
	}
	public void setOriginator(int originator) {
		this.originator = originator;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public List<Integer> getResper() {
		return resper;
	}
	public void setResper(List<Integer> resper) {
		this.resper = resper;
	}
}
