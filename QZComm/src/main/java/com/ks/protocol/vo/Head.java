package com.ks.protocol.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.ks.protocol.AbstractHead;

/**
 * UUID包头
 * @author ks
 */
@EqualsAndHashCode(callSuper=true)
@Data
public class Head extends AbstractHead {

	private static final long serialVersionUID = 1L;
	
	/**数据区长度*/
	private short length;
	/**主命令*/
	private short mainCmd;
	/**子命令*/
	private short subCmd;
	/**引导*/
	private int guideId;
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
	
}
