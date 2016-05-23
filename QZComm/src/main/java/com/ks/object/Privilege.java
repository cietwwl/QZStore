package com.ks.object;

import com.ks.constant.SystemConstant;

public class Privilege {
	private int type;  //特权类型
	private String value = "";  //值
	public Privilege(int type, String value)throws Exception{
		this.type = type;
		this.value = value;
	}
	public int getType(){
		return type;
	}
	public int getValueInt(){
		if(value.length() > 0){
			return Integer.parseInt(value);
		}
		return 0;
	}
	public String getValueString(){
		return value;
	}
	
	public void merge(Privilege privilege){
		if(type != SystemConstant.PRIVILEGE_TYPE_SEND_DROP){
			if(type == SystemConstant.PRIVILEGE_TYPE_SIGN_BOX_DOUBLE_DAY){
				if(privilege.getValueInt() > getValueInt()){
					value = privilege.getValueString();
				}
			}else{
				value = String.valueOf(getValueInt() + privilege.getValueInt());
			}
		}else{
			value = privilege.getValueString();
		}
	}
}
