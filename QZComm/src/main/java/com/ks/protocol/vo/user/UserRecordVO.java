package com.ks.protocol.vo.user;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.ks.db.model.UserRecord;
import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;

@EqualsAndHashCode(callSuper=true)
@Data
public class UserRecordVO extends Message{
	private static final long serialVersionUID = 1L;
	@FieldDesc(desc="首次充值支付ids")
	private List<Integer> firstRechangeIds;
	
	public void init(UserRecord record){
		firstRechangeIds = record.getFirstRechargeList();
	}

}
