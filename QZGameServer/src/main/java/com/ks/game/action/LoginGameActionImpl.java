package com.ks.game.action;

import com.ks.action.game.LoginGameAction;
import com.ks.game.model.Player;
import com.ks.manager.PlayerManager;

public final class LoginGameActionImpl implements
		LoginGameAction {

	@Override
	public void repeatLogin(String sessionId) {
		Player player = PlayerManager.getOnlinePlayer(sessionId);
		if(player!=null){
			player.lock();
			try{
				PlayerManager.removeOnlinePlayer(sessionId);
			}finally{
				player.unlock();
			}
		}
	}

	@Override
	public void addOnlinePlayer(String sessionId,Player player) {
		PlayerManager.addOnlinePlayer(sessionId, player);
	}
	
}