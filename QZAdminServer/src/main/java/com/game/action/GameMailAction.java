package com.game.action;

import java.sql.Connection;
import java.sql.Statement;

import com.cache.GameServerCache;
import com.db.util.ConnUtil;
import com.game.constant.GameCmd;
import com.game.service.GameMailService;
import com.http.message.CommonHttpRequest;
import com.utils.HttpUtil;
import com.utils.JSONUtil;
import com.web.db.game.GameMailInfo;
import com.web.db.game.GameServerInfo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.sf.json.JSONObject;

/**
 * 邮件发放
 *
 */
@EqualsAndHashCode(callSuper=true)
@Data
public class GameMailAction extends EAction {
	private GameMailInfo mail;
	public GameMailAction(GameMailInfo mail){
		this.mail = mail;
	}
	@Override
	public boolean execute() throws Exception {
		mail = GameMailService.getGameMaillInfo(mail.getId());
		if(mail != null && mail.isState(1) && !mail.isSend()){
			GameServerInfo server = GameServerCache.getGameServerInfo(mail.getServerId());
			//发放邮件请求
			CommonHttpRequest req = new CommonHttpRequest(server.getAdminUrl(), CommonHttpRequest.METHOD_POST);
			req.setEncode(true);
			req.addParam("check", server.getAdminCheck());
			req.addParam("action", GameCmd.CMD_SEND_MAIL);
			req.addParam("title", mail.getTitle());
			req.addParam("content", mail.getContent());
			req.addParam("partner", mail.getPartner());
			req.addParam("sendType", mail.getSendType());
			req.addParam("openids", mail.getOpenids());
			req.addParam("times", mail.getTimes());
			req.addParam("items", mail.getItems());
			req.setTimeout(1000);
			String resultstr = HttpUtil.send(req);
			if(resultstr.trim().length() > 0){
				JSONObject result = JSONUtil.parseJSON(resultstr);
				if(result.getInt("code") == 0){
					mail.setSend(true);
					Connection conn = ConnUtil.getConnection();
					try{
						Statement stmt = conn.createStatement();
						try{
							String sql = mail.getUpdateData();
							stmt.executeUpdate(sql);
						}finally{
							stmt.close();
						}
					}finally{
						conn.close();
					}
				}
			}
		}
		return true;
	}

}
