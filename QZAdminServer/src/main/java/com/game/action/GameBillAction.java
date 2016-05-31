package com.game.action;

import java.sql.Connection;
import java.sql.Statement;

import com.cache.GameServerCache;
import com.db.util.ConnUtil;
import com.game.constant.GameCmd;
import com.game.service.GameRechargeService;
import com.http.message.CommonHttpRequest;
import com.ks.constant.SystemConstant;
import com.ks.exceptions.GameException;
import com.ks.util.XyTimeUtil;
import com.utils.HttpUtil;
import com.utils.JSONUtil;
import com.utils.TimeUtil;
import com.web.db.game.GameBillInfo;
import com.web.db.game.GameServerInfo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.sf.json.JSONObject;


/**
 * 订单发货
 *
 */
@EqualsAndHashCode(callSuper=true)
@Data
public class GameBillAction extends EAction {
	private GameBillInfo bill;
	private int createTime = 0;
	private boolean resend = false;
	
	public GameBillAction(GameBillInfo bill){
		this.bill = bill;
		this.createTime = TimeUtil.getNowSecond();
	}
	
	public GameBillAction(GameBillInfo bill, boolean resend){
		this.bill = bill;
		this.createTime = TimeUtil.getNowSecond();
		this.resend = resend;
	}
	
	@Override
	public boolean execute() throws Exception {
		bill = GameRechargeService.getPayBillInfoByBillno(bill.getBill());
		if(bill != null && (!bill.isComplete() || resend)){
			GameServerInfo server = GameServerCache.getGameServerInfo(bill.getServerId());
			if(server != null){
				CommonHttpRequest req = new CommonHttpRequest(server.getAdminUrl(), CommonHttpRequest.METHOD_POST);
				req.setEncode(true);
				req.addParam("check", server.getAdminCheck());
				req.addParam("action", GameCmd.CMD_PAY_GOODS);
				req.addParam("userId", bill.getUserId());
				req.addParam("payGoodsId", bill.getPayGoodsId());
				String resultstr = HttpUtil.sendPost(req);
				JSONObject result = JSONUtil.parseJSON(resultstr);
				if(result.getInt("code") == GameException.CODE_正常){
					bill.setState(SystemConstant.PAY_BILL_STATE2);
					bill.setCompleteTime(XyTimeUtil.getNowSecond());
					Connection conn = ConnUtil.getConnection();
					try{
						Statement stmt = conn.createStatement();
						try{
							String sql = bill.getUpdateData();
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
