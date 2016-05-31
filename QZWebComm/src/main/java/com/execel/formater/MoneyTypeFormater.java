package com.execel.formater;

public class MoneyTypeFormater extends ValueFormater {

	public MoneyTypeFormater(String hname, String fname) {
		super(hname, fname);
	}

	@Override
	public String format(Object obj) throws Exception {
		String str = super.format(obj);
		int moneyType = Integer.parseInt(str);
		if(moneyType == 101){
			return "金币";
		}else if(moneyType == 102){
			return "元宝";
		}
		return str;
	}

	
}
