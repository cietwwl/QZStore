package com.ks.protocol.vo;

import com.ks.protocol.AbstractHead;

/**
 * UUID包头
 * @author ks
 */
public class Head extends AbstractHead {

	private static final long serialVersionUID = 1L;
	
	/**数据区长度*/
	private short length;
	/**主命令*/
	private short mainCmd;
	/**子命令*/
	private short subCmd;
	/**session编号*/
	private String sessionId = new String(new byte[36]);
	/**效验字段*/
	private short checkVal;
	/**是否被压缩*/
	private boolean compressed;
	public void init(short mainCmd,short subCmd){
		this.mainCmd=mainCmd;
		this.subCmd = subCmd;
		checkVal = 0;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public short getCheckVal() {
		return checkVal;
	}
	public void setCheckVal(short checkVal) {
		this.checkVal = checkVal;
	}
	public short getLength() {
		return length;
	}
	public void setLength(short length) {
		this.length = length;
	}
	public short getMainCmd() {
		return mainCmd;
	}
	public void setMainCmd(short mainCmd) {
		this.mainCmd = mainCmd;
	}
	public short getSubCmd() {
		return subCmd;
	}
	public void setSubCmd(short subCmd) {
		this.subCmd = subCmd;
	}
	public boolean isCompressed() {
		return compressed;
	}
	public void setCompressed(boolean compressed) {
		this.compressed = compressed;
	}
	
}
