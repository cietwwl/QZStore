package com.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;


public class StringUtil {
	public static boolean isEmpty(String str){
		return str == null || str.isEmpty();
	}
	public static String parseString(Collection<?> list, String split){
		StringBuffer sb = new StringBuffer();
		for(Object obj : list){
			sb.append(obj).append(split);
		}
		if(sb.length() > 0)
			return sb.substring(0, sb.length() - split.length());
		return sb.toString();
	}
	public static List<Integer> parseList(String str, String split){
		List<Integer> list = new ArrayList<Integer>();
		String ss[] = str.split(split);
		for(String s : ss){
			if(s.length() > 0){
				list.add(Integer.parseInt(s));
			}
		}
		return list;
	}
	public static List<String> parseListByString(String str, String split){
		List<String> list = new ArrayList<String>();
		String ss[] = str.split(split);
		for(String s : ss){
			if(s.length() > 0){
				list.add(s);
			}
		}
		return list;
	}
	public static String getSqlValue(Object object) throws Exception{
		if(object == null){
			return null;
		}
		String str = object.toString();
		if(object instanceof String){
			str = str.replaceAll("\\\\", "\\\\\\\\");
			str = str.replaceAll("\'","\\\\'");
			str = "'" + str + "'";
		}else if(object instanceof Date){
			str = "'" + TimeUtil.formatDate((Date)object, TimeUtil.DATE_FORMATER.yyyy_MM_dd_HH_mm_ss) + "'";
		}
		return str;
	}
	public static String getLikeSqlValue(String str, boolean prefix, boolean suffix) throws Exception{
		str = str.replaceAll("\\\\", "\\\\\\\\");
		str = str.replaceAll("\'","\\\\'");
		if(prefix){
			str = "%" + str;
		}
		if(suffix){
			str = str + "%";
		}
		str = "'" + str + "'";
		return str;
	}
	public static String encode(String content, String oldCharsetName, String charsetName) throws Exception{
		return new String(content.getBytes(oldCharsetName), charsetName);
	}
	public static String replace(String content, Map<String, String> map){
		String s1 = "{";
		String s2 = "}";
		int begin = content.indexOf(s1);
		int end = content.indexOf(s2);
		while(begin >= 0 && end > begin){
			String str = content.substring(begin + 1, end);
			content = content.substring(0, begin) + map.get(str) + content.substring(end + 1, content.length());
			begin = content.indexOf(s1, begin + 1);
			end = content.indexOf(s2, begin + 1);
		}
		return content;
	}
	
	public static String encodeQQParam(String str){
		StringBuffer sb = new StringBuffer();
		for(char c : str.toCharArray()){
			String s = String.valueOf(c);
			if(!Pattern.matches("[\\w\\!\\*\\(\\)]", s)){
				int n = (int)c;
				String hex = "%" + Integer.toHexString(n);
				sb.append(hex.toUpperCase());
			}else{
				sb.append(s);
			}
		}
		return sb.toString();
	}
	
	public static void main(String args[]) throws Exception{
		String str = "你妹啊!-!.";
		System.out.println(encodeQQParam(str));
	}
}
