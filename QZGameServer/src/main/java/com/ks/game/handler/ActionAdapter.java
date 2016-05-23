package com.ks.game.handler;

import com.ks.action.logic.ArenaAction;
import com.ks.action.logic.FightAction;
import com.ks.action.logic.FriendAction;
import com.ks.action.logic.GuildAction;
import com.ks.action.logic.HeroBreakAction;
import com.ks.action.logic.MailAction;
import com.ks.action.logic.MallAction;
import com.ks.action.logic.MartialWayAction;
import com.ks.action.logic.PlayerAction;
import com.ks.action.logic.TaskAction;
import com.ks.action.logic.UserAchieveAction;
import com.ks.action.logic.UserAction;
import com.ks.action.logic.UserBuffAction;
import com.ks.action.logic.UserEquipmentAction;
import com.ks.action.logic.UserEternalAction;
import com.ks.action.logic.UserHeroAction;
import com.ks.action.logic.UserPropAction;
import com.ks.action.logic.UserTeamAction;
import com.ks.action.logic.UserZoneAction;
import com.ks.action.world.LockAction;
import com.ks.action.world.LoginAction;
import com.ks.action.world.WorldChatAction;
import com.ks.action.world.WorldFightAction;
import com.ks.action.world.WorldMartialWayAction;
import com.ks.app.Application;
import com.ks.rpc.RPCKernel;

public class ActionAdapter {
	
	public final static FightAction fightAction(){
		return RPCKernel.getRemoteByServerType(Application.LOGIC_SERVER, FightAction.class);
	}
	public final static PlayerAction playerAction(){
		return RPCKernel.getRemoteByServerType(Application.LOGIC_SERVER, PlayerAction.class);
	}
	public final static UserHeroAction userHeroAction(){
		return RPCKernel.getRemoteByServerType(Application.LOGIC_SERVER, UserHeroAction.class);
	}
	public final static UserTeamAction userTeamAction(){
		return RPCKernel.getRemoteByServerType(Application.LOGIC_SERVER, UserTeamAction.class);
	}
	public final static UserZoneAction userZoneAction(){
		return RPCKernel.getRemoteByServerType(Application.LOGIC_SERVER, UserZoneAction.class);
	}
	public final static MailAction mailAction(){
		return RPCKernel.getRemoteByServerType(Application.LOGIC_SERVER, MailAction.class);
	}
	public final static ArenaAction arenaAction(){
		return RPCKernel.getRemoteByServerType(Application.LOGIC_SERVER, ArenaAction.class);
	}
	public final static GuildAction guildAction(){
		return RPCKernel.getRemoteByServerType(Application.LOGIC_SERVER, GuildAction.class);
	}
	public final static UserPropAction userPropAction(){
		return RPCKernel.getRemoteByServerType(Application.LOGIC_SERVER, UserPropAction.class);
	}
	public final static UserBuffAction userBuffAction(){
		return RPCKernel.getRemoteByServerType(Application.LOGIC_SERVER, UserBuffAction.class);
	}
	public final static MallAction mallAction(){
		return RPCKernel.getRemoteByServerType(Application.LOGIC_SERVER, MallAction.class);
	}
	public final static UserAchieveAction userAchieveAction(){
		return RPCKernel.getRemoteByServerType(Application.LOGIC_SERVER, UserAchieveAction.class);
	}
	public final static FriendAction friendAction(){
		return RPCKernel.getRemoteByServerType(Application.LOGIC_SERVER, FriendAction.class);
	}
	public final static WorldFightAction worldFightAction(){
		return RPCKernel.getRemoteByServerType(Application.WORLD_SERVER, WorldFightAction.class);
	}
	public final static LoginAction loginAction(){
		return RPCKernel.getRemoteByServerType(Application.WORLD_SERVER, LoginAction.class);
	}
	public final static UserEquipmentAction userEquipmentAction() {
		return RPCKernel.getRemoteByServerType(Application.LOGIC_SERVER, UserEquipmentAction.class);
	}
	public final static UserEternalAction userEternalAction() {
		return RPCKernel.getRemoteByServerType(Application.LOGIC_SERVER, UserEternalAction.class);
	}
	public final static MartialWayAction martialWayAction() {
		return RPCKernel.getRemoteByServerType(Application.LOGIC_SERVER, MartialWayAction.class);
	}
	public final static WorldMartialWayAction worldMartialWayAction() {
		return RPCKernel.getRemoteByServerType(Application.WORLD_SERVER, WorldMartialWayAction.class);
	}
	public final static WorldChatAction worldChatAction() {
		return RPCKernel.getRemoteByServerType(Application.WORLD_SERVER, WorldChatAction.class);
	}
	public final static TaskAction taskAction() {
		return RPCKernel.getRemoteByServerType(Application.LOGIC_SERVER, TaskAction.class);
	}
	public final static HeroBreakAction heroBreakAction() {
		return RPCKernel.getRemoteByServerType(Application.LOGIC_SERVER, HeroBreakAction.class);
	}
	
	public final static UserAction userAction() {
		return RPCKernel.getRemoteByServerType(Application.LOGIC_SERVER, UserAction.class);
	}
	
	public final static LockAction lockAction() {
		return RPCKernel.getRemoteByServerType(Application.WORLD_SERVER, LockAction.class);
	}
}
