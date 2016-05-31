package com.execel.formater;

public class ConsumeTypeFormater extends ValueFormater {

	public ConsumeTypeFormater(String hname, String fname) {
		super(hname, fname);
	}

	@Override
	public String format(Object obj) throws Exception {
		String str = super.format(obj);
		int consumeType = Integer.parseInt(str);
		if(consumeType == 1){
			return "获得";
		}else{
			return "消耗";
		}
	}

	
}
