package com.ks.protocol.vo.mall;

import com.ks.protocol.Message;

public class PayBillVO extends Message{
	private static final long serialVersionUID = 1L;
	
	private String bill;
	
	public String getBill(){
		return bill;
	}
	public void setBill(String bill){
		this.bill = bill;
	}
	

}
