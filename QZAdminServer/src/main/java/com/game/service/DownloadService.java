package com.game.service;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.util.ConnUtil;
import com.execel.formater.TimeFormater;
import com.execel.formater.ValueFormater;
import com.utils.ExcelUtil;
import com.utils.StringUtil;
import com.web.db.game.GameCdKeyInfo;
import com.web.db.game.GameKeepInfo;
import com.web.db.game.GameLevelLossInfo;
import com.web.db.game.GameRegistLossInfo;
import com.web.obj.ParamError;

/**
 * 下载逻辑处理类
 *
 */
public class DownloadService{
	
	/**
	 * //TODO 下载CDKEY-jsp
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public static void downloadCdkey(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ParamError error = new ParamError();
		String code = ServletService.getParamString(request, "code", error);
		int activated = ServletService.getParamInt(request, "activated", error);
		int convert = ServletService.getParamInt(request, "convert", error);
		if(error.isSuccess()){
			List<GameCdKeyInfo> list = new ArrayList<GameCdKeyInfo>();
			Connection conn = ConnUtil.getConnection();
			try{
				Statement stmt = conn.createStatement();
				try{
					String sql = "select * from " + new GameCdKeyInfo().getTableName();
					String condition = "";
					if(activated != -1){
						condition = " n_activated=" + activated;
					}
					if(convert != -1){
						String val = ">";
						if(convert > 0){
							val = "<=";
						}
						if(condition.length() > 0){
							condition += " and n_totalNum " + val + " n_convertNum";
						}else{
							condition += " n_totalNum " + val + " n_convertNum";
						}
					}
					if(code.length() > 0){
						if(condition.length() > 0){
							condition += " and n_code=" + StringUtil.getSqlValue(code);
						}else{
							condition += " n_code=" + StringUtil.getSqlValue(code);
						}
					}
					if(condition.length() > 0){
						condition = " where " + condition;
					}
					sql = sql + condition + " order by n_id desc ";
					ResultSet result = stmt.executeQuery(sql);
					try{
						while(result.next()){
							GameCdKeyInfo log = new GameCdKeyInfo();
							log.read(result);
							list.add(log);
						}
					}finally{
						result.close();
					}
				}finally{
					stmt.close();
				}
			}finally{
				conn.close();
			}
			
			String filedownload = "cdkey数据表.xls";
			String filedisplay = filedownload;
			//filedisplay = new String(filedisplay.getBytes("utf-8"),"iso8859-1");   
			response.addHeader("Content-Disposition", "attachment;filename=" + filedisplay);
			
			OutputStream outp = null;
			FileInputStream in = null;
			try{
				outp = response.getOutputStream();
				List<ValueFormater> formaters = new ArrayList<ValueFormater>();
				ValueFormater f0 = new ValueFormater("cdkey类型", "type");
				formaters.add(f0);
				ValueFormater f1 = new ValueFormater("生成码", "code");
				formaters.add(f1);
				ValueFormater f2 = new ValueFormater("名称", "name");
				formaters.add(f2);
				ValueFormater f3 = new ValueFormater("cdkey", "cdkey");
				formaters.add(f3);
				ValueFormater f4 = new ValueFormater("奖励", "rewards");
				formaters.add(f4);
				ValueFormater f5 = new ValueFormater("是否激活", "activated");
				formaters.add(f5);
				ValueFormater f6 = new ValueFormater("可兑换数量", "totalNum");
				formaters.add(f6);
				ValueFormater f7 = new ValueFormater("已兑换数量", "convertNum");
				formaters.add(f7);
				ExcelUtil.write("cdkey数据表", list, formaters, outp);
				outp.flush();
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				if(in != null){
					in.close();
					in = null;
				}
				if(outp != null){
					outp.close();
					outp = null;
				}
			}
		}
	}
	
	/**
	 * //TODO 下来留存统计-jsp
	 * @param request
	 * @param session
	 * @param response
	 * @throws Exception
	 */
	public static void downloadKeep(HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<GameKeepInfo> losses = new ArrayList<GameKeepInfo>();
		Connection conn = ConnUtil.getConnection();
		try{
			Statement stmt = conn.createStatement();
			try{
				String sql = "select * from " + new GameKeepInfo().getTableName();
				ResultSet result = stmt.executeQuery(sql);
				try{
					while(result.next()){
						GameKeepInfo info = new GameKeepInfo();
						info.read(result);
						losses.add(info);
					}
				}finally{
					result.close();
				}
			}finally{
				stmt.close();
			}
		}finally{
			ConnUtil.closeConnection(conn);
		}
		String filedownload = "game_keep.xls";  
		String filedisplay = filedownload;
		//filedisplay = new String(filedisplay.getBytes("utf-8"),"iso8859-1");   
		response.addHeader("Content-Disposition","attachment;filename=" + filedisplay);  

		OutputStream outp = null;  
		FileInputStream in = null;  
		try{
			outp = response.getOutputStream();
			List<ValueFormater> formaters = new ArrayList<ValueFormater>();
			ValueFormater f1 = new ValueFormater("服务器ID", "serverId");
			formaters.add(f1);
			TimeFormater f2 = new TimeFormater("时间", "time");
			formaters.add(f2);
			ValueFormater f3 = new ValueFormater("创角数", "regist");
			formaters.add(f3);
			ValueFormater f4 = new ValueFormater("新账号数", "newAmount");
			formaters.add(f4);
			ValueFormater f5 = new ValueFormater("1日留存率", "keep1");
			formaters.add(f5);
			ValueFormater f6 = new ValueFormater("2日留存率", "keep2");
			formaters.add(f6);
			ValueFormater f7 = new ValueFormater("3日留存率", "keep3");
			formaters.add(f7);
			ValueFormater f8 = new ValueFormater("4日留存率", "keep4");
			formaters.add(f8);
			ValueFormater f9 = new ValueFormater("5日留存率", "keep5");
			formaters.add(f9);
			ValueFormater f10 = new ValueFormater("6日留存率", "keep6");
			formaters.add(f10);
			ValueFormater f11 = new ValueFormater("7日留存率", "keep7");
			formaters.add(f11);
			ValueFormater f12 = new ValueFormater("15日留存率", "keep15");
			formaters.add(f12);
			ValueFormater f13 = new ValueFormater("30日留存率", "keep30");
			formaters.add(f13);
			
		    ExcelUtil.write("留存统计报表", losses, formaters, outp);
		    outp.flush();
		 }catch(Exception e)  {
		     e.printStackTrace();  
		 }finally{  
		     if(in != null)  
		     {  
		         in.close();  
		         in = null;  
		     }  
		     if(outp != null)  
		     {  
		         outp.close();  
		         outp = null;  
		     }  
		 }
	}
	
	/**
	 * //TODO 下载等级流失统计-jsp
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public static void downloadLevelLoss(HttpServletRequest request, HttpServletResponse response)throws Exception{
		List<GameLevelLossInfo> losses = new ArrayList<GameLevelLossInfo>();
		Connection conn = ConnUtil.getConnection();//ConnUtil.getConnection(mainConnParam);
		try{
			Statement stmt = conn.createStatement();
			try{
				String sql = "select * from " + new GameLevelLossInfo().getTableName();
				ResultSet result = stmt.executeQuery(sql);
				try{
					while(result.next()){
						GameLevelLossInfo info = new GameLevelLossInfo();
						info.read(result);
						losses.add(info);
					}
				}finally{
					result.close();
				}
			}finally{
				stmt.close();
			}
		}finally{
			ConnUtil.closeConnection(conn);
		}
		String filedownload = "levle_log.xls";  
		String filedisplay = filedownload;
		//filedisplay = new String(filedisplay.getBytes("utf-8"),"iso8859-1");   
		response.addHeader("Content-Disposition","attachment;filename=" + filedisplay);  
		
		OutputStream outp = null;  
		FileInputStream in = null;  
		try{
			outp = response.getOutputStream();
			List<ValueFormater> formaters = new ArrayList<ValueFormater>();
			TimeFormater f1 = new TimeFormater("时间", "time");
			formaters.add(f1);
			ValueFormater f2 = new ValueFormater("等级", "level");
			formaters.add(f2);
			ValueFormater f3 = new ValueFormater("等级人数", "levelAmount");
			formaters.add(f3);
			ValueFormater f5 = new ValueFormater("到达等级人数", "reachLevelAmount");
			formaters.add(f5);
			ValueFormater f6 = new ValueFormater("注册人数", "registAmount");
			formaters.add(f6);
			ValueFormater f7 = new ValueFormater("流失人数", "lossAmount");
			formaters.add(f7);
			ValueFormater f8 = new ValueFormater("服务器ID", "serverId");
			formaters.add(f8);
		    ExcelUtil.write("等级流失报表", losses, formaters, outp);
		    outp.flush();
		 }catch(Exception e)  {
		     e.printStackTrace();  
		 }finally{  
		     if(in != null)  
		     {  
		         in.close();  
		         in = null;  
		     }  
		     if(outp != null)  
		     {  
		         outp.close();  
		         outp = null;  
		     }  
		 }
	}
	
	/**
	 * //TODO 下载注册流失统计-jsp
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public static void downloadRegistLoss(HttpServletRequest request, HttpServletResponse response)throws Exception{
		List<GameRegistLossInfo> losses = new ArrayList<GameRegistLossInfo>();
		Connection conn = ConnUtil.getConnection();
		try{
			Statement stmt = conn.createStatement();
			try{
				String sql = "select * from " + new GameRegistLossInfo().getTableName();
				ResultSet result = stmt.executeQuery(sql);
				try{
					while(result.next()){
						GameRegistLossInfo info = new GameRegistLossInfo();
						info.read(result);
						losses.add(info);
					}
				}finally{
					result.close();
				}
			}finally{
				stmt.close();
			}
		}finally{
			ConnUtil.closeConnection(conn);
		}
		String filedownload = "regist_log.xls";  
		String filedisplay = filedownload;
		//filedisplay = new String(filedisplay.getBytes("utf-8"),"iso8859-1");   
		response.addHeader("Content-Disposition","attachment;filename=" + filedisplay);  
		
		OutputStream outp = null;  
		FileInputStream in = null;  
		try{
			outp = response.getOutputStream();
			List<ValueFormater> formaters = new ArrayList<ValueFormater>();
			TimeFormater f1 = new TimeFormater("时间", "time");
			formaters.add(f1);
			ValueFormater f2 = new ValueFormater("服务器ID", "serverId");
			formaters.add(f2);
			ValueFormater f3 = new ValueFormater("新账号数", "newAmount");
			formaters.add(f3);
			ValueFormater f5 = new ValueFormater("请求注册数量", "requestRegistAmount");
			formaters.add(f5);
			ValueFormater f6 = new ValueFormater("成功创建数量", "registAmount");
			formaters.add(f6);
			ValueFormater f7 = new ValueFormater("进入游戏数量", "enterAmount");
			formaters.add(f7);
			ExcelUtil.write("注册流失报表", losses, formaters, outp);
			outp.flush();
		}catch(Exception e)  {
			e.printStackTrace();  
		}finally{  
			if(in != null)  
			{  
				in.close();  
				in = null;  
			}  
			if(outp != null)  
			{  
				outp.close();  
				outp = null;  
			}  
		}
	}
	
}
