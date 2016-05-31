package com.game.action;

public abstract class EAction {
	public boolean ready(){
		return true;
	}
	public abstract boolean execute() throws Exception;
}
