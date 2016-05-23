package com.ks.logic.test.dao;

import org.junit.Test;

import com.ks.logic.dao.MartialWayDAO;
import com.ks.logic.test.BaseTestCase;

public class UserDAOTestCase extends BaseTestCase {
	@Test
	public void testGetUserIdByUsername() throws Exception{
		final MartialWayDAO dao = new MartialWayDAO();
		dao.gainMartialWayRank(0,10);
	}
}
