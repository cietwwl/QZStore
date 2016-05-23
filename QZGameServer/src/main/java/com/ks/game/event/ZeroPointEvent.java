package com.ks.game.event;

import com.ks.event.GameEvent;
import com.ks.game.model.Player;

public class ZeroPointEvent extends GameEvent {
	
	private Player player;
	public ZeroPointEvent(Player player) {
		this.player = player;
	}
	@Override
	public void runEvent() {
		player.lock();
		try{
		}finally{
			player.unlock();
		}
	}

}
