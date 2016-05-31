package com.game.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

import com.db.util.ConnUtil;
import com.web.db.game.GameMailInfo;
import com.web.db.game.GameBillInfo;

public class EActionPool {
	private static LinkedBlockingQueue<EAction> actionQueue;
	public static void init(){
		try{
			actionQueue = new LinkedBlockingQueue<EAction>();
			Connection conn = ConnUtil.getConnection();
			try{
				Collection<EAction> mailActions = loadMail(conn);
				actionQueue.addAll(mailActions);
				Collection<EAction> billActions = loadBills(conn);
				actionQueue.addAll(billActions);
			}finally{
				ConnUtil.closeConnection(conn);
			}
			new EActionThead().start();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	private static Collection<EAction> loadMail(Connection conn) throws Exception{
		List<EAction> actions = new ArrayList<EAction>();
		Statement stmt = conn.createStatement();
		try{
			String sql = "select * from " + new GameMailInfo().getTableName() +  " where n_state=1 and n_send=false";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				GameMailInfo info = new GameMailInfo();
				info.read(rs);
				actions.add(new GameMailAction(info));
			}
		}finally{
			stmt.close();
		}
		return actions;
	}
	private static Collection<EAction> loadBills(Connection conn) throws Exception{
		List<EAction> actions = new ArrayList<EAction>();
		Statement stmt = conn.createStatement();
		try{
			String sql = "select * from " + new GameBillInfo().getTableName() + " where n_confirmTime>0 and n_completeTime=0";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				GameBillInfo info = new GameBillInfo();
				info.read(rs);
				actions.add(new GameBillAction(info));
			}
		}finally{
			stmt.close();
		}
		return actions;
	}
	
	public static void addAction(EAction action) throws Exception{
		actionQueue.put(action);
	}
	public static boolean isEmpty(){
		return actionQueue.isEmpty();
	}
	
	private static int init = 0;
	public static class EActionThead extends Thread{
		@Override
		public void run() {
			super.run();
			if(init == 0){
				init++;
				try{
					super.sleep(10000);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			EAction action = null;
			while(true){
				try{
					action = actionQueue.take();
					if(action.ready()){
						action.execute();
					}else{
						actionQueue.put(action);
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
}
