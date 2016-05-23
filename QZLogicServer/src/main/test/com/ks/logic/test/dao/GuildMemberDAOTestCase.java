package com.ks.logic.test.dao;

import org.junit.Test;

import com.ks.db.model.GuildMember;
import com.ks.logic.dao.GuildMemberDAO;
import com.ks.logic.test.BaseTestCase;

public class GuildMemberDAOTestCase extends BaseTestCase {
	
	@Test
	public void testAddGuildMember(){
		GuildMemberDAO dao = new GuildMemberDAO();
		int userId=1;
		for(int i=1;i<=50000;i++){
			for(int j=1;j<=100;j++){
				GuildMember gm = new GuildMember();
				gm.setUserId(userId);
				gm.setGuildId(i);
				gm.setPlayerName("");
				dao.addGuildMember(gm);
				
				userId++;
			}
		}
	}
}
