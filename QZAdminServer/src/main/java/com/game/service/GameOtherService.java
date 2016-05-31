package com.game.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.cache.GameServerCache;
import com.game.constant.GameCmd;
import com.http.message.CommonHttpRequest;
import com.utils.HttpUtil;
import com.utils.JSONUtil;
import com.utils.StringUtil;
import com.web.db.game.GameServerInfo;
import com.web.obj.ParamError;

import net.sf.json.JSONObject;

/**
 * 其他逻辑
 *
 */
public class GameOtherService{

	
	/**
	 * //TODO 发送通知-jsp
	 * @param contents
	 * @param colorId
	 * @param interval
	 * @param cycleNum
	 * @param serverIdStr
	 * @return 
	 */
	public static JSONObject noticeSend(HttpServletRequest request){
		ParamError error = new ParamError();
		String contents = ServletService.getParamString(request, "content", error);
		int colorId = ServletService.getParamInt(request, "colorId", error);
		int interval = ServletService.getParamInt(request, "secondNum", error);
		int cycleNum = ServletService.getParamInt(request, "sendNum", error);
		String serverIdStr = ServletService.getParamString(request, "servers", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			List<Integer> serverIds = StringUtil.parseList(serverIdStr, ";");
			int code = -1;
			resp = new JSONObject();
			if(contents.length() > 0 && serverIds.size() > 0){
				List<GameServerInfo> servers = GameServerCache.getGameServers();
				code = 0;
				for(Integer id : serverIds){
					for(GameServerInfo server : servers){
						if(server.getId() == id){
							CommonHttpRequest req = new CommonHttpRequest(server.getAdminUrl(), CommonHttpRequest.METHOD_POST);
							req.addParam("check", server.getAdminCheck());
							req.addParam("contents", contents);
							req.addParam("colorId", colorId);
							req.addParam("interval", interval);
							req.addParam("cycleNum", cycleNum);
							req.addParam("action", GameCmd.CMD_PUBLISH_NOTICE);
							try{
								HttpUtil.sendPost(req);
							}catch(Exception e){
								e.printStackTrace();
							}
						}
					}
				}
			}else{
				resp.put("tip", "服务器和内容不能为空!");
			}
			resp.put("code", code);
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	
	/**
	 * //TODO  获取公共频道聊天信息-jsp
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getChatMsgs(HttpServletRequest request, HttpSession session)throws Exception{
		ParamError error = new ParamError();
		int type = ServletService.getParamInt(request, "type", error);
		int time = ServletService.getParamInt(request, "time", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			GameServerInfo server = (GameServerInfo) session.getAttribute("selserver");
			try{
				CommonHttpRequest req = new CommonHttpRequest(server.getAdminUrl(), CommonHttpRequest.METHOD_POST);
				req.addParam("check", server.getAdminCheck());
				req.addParam("type", type);
				req.addParam("time", time);
				req.addParam("action", GameCmd.CMD_MONITOR_CHAT);
				String resultstr = HttpUtil.sendPost(req);
				resp = new JSONObject();
				JSONObject result = JSONUtil.parseJSON(resultstr);
				resp.put("code", result.getInt("code"));
				resp.put("data", result.get("data"));
			}catch(Exception e){
				error.setCode(-1);
				resp = error.getErrorData();
			}
			resp.put("serverName", server.getServerName());
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	
	/**
	 * //TODO gm修改-jsp
	 * @param server
	 * @param partner
	 * @param username
	 * @param items
	 * @param delItems
	 * @return
	 */
	public static JSONObject gmModify(HttpServletRequest request, HttpSession session){
		ParamError error = new ParamError();
		int partner = ServletService.getParamInt(request, "partner", error);
		String username = ServletService.getParamString(request, "username", error);
		String items = ServletService.getParamString(request, "items", error);
		String delItems = ServletService.getParamString(request, "delItems", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			GameServerInfo server = (GameServerInfo) session.getAttribute("selserver");
			if(server == null){
				resp = error.getServerError();
			}else{
				CommonHttpRequest req = new CommonHttpRequest(server.getAdminUrl(), CommonHttpRequest.METHOD_POST);
				req.addParam("check", server.getAdminCheck());
				req.addParam("partner", partner);
				req.addParam("username", username);
				req.addParam("items", items);
				req.addParam("delItems", delItems);
				req.addParam("action", GameCmd.CMD_ADD_ITEMS_ACTION);
				int code = 0;
				try{
					String resultstr = HttpUtil.sendPost(req);
					JSONObject result = JSONUtil.parseJSON(resultstr);
					code = result.getInt("code");
				}catch(Exception e){
					e.printStackTrace();
				}
				resp = new JSONObject();
				resp.put("code", code);
				if(code != 0){
					resp.put("tip", "修改失败![" + code + "]");
				}
			}
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
}
