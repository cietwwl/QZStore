package com.ks.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * xy
 *
 */
public class XyStringUtil{

	/******************************* 分隔符 ********************************/
	/**分隔符-拆("=")*/
	public static final String SPLIT_EQUAL = "=";
	/**分隔符-拆("|")*/
	public static final String SPLIT_VERTICALLINE = "\\|";
	/**分隔符-拆("_")*/
	public static final String SPLIT_UNDERLINE = "\\_";
	/**分隔符-拆("$")*/
	public static final String SPLIT_DOLLAR = "\\$";
	/**分隔符-拆("&")*/
	public static final String SPLIT_AND = "&";
	/**分隔符-拆(";")*/
	public static final String SPLIT_SEMICOLON = ";";
	/**分隔符-拆("#")*/
	public static final String SPLIT_WELL = "#";
	/**分隔符-合("=")*/
	public static final String JOIN_EQUAL = "=";
	/**分隔符-合("|")*/
	public static final String JOIN_VERTICALLINE = "|";
	/**分隔符-合("_")*/
	public static final String JOIN_UNDERLINE = "_";
	/**分隔符-合("$")*/
	public static final String JOIN_DOLLAR = "$";
	/**分隔符-合("&")*/
	public static final String JOIN_AND = "&";
	/**分隔符-合(";")*/
	public static final String JOIN_SEMICOLON = ";";
	/**分隔符-合("#")*/
	public static final String JOIN_WELL = "#";
	/**分隔符-合("x")*/
	public static final String MULTIPLE_SIGN = "×";
	
	public static int parseIpToInt32(String ip) throws Exception{
		List<Integer> list = parseList(ip, "\\.");
		return (list.get(0) << 24) | (list.get(1) << 16) | (list.get(2) << 8) | list.get(3);
	}

	public static Map<Integer, Integer> parseMap(String str, String split1, String split2){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		String ss[] = str.split(split1);
		for(String s : ss){
			if(s.length() > 0){
				String p[] = s.split(split2);
				map.put(Integer.parseInt(p[0]), Integer.parseInt(p[1]));
			}
		}
		return map;
	}

	public static List<List<Integer>> parseLists(String str, String split1, String split2){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(str.length() > 0){
			String ss[] = str.split(split1);
			for(String s : ss){
				String ps[] = s.split(split2);
				List<Integer> list1 = new ArrayList<Integer>();
				for(String p : ps){
					if(p.length() > 0){
						list1.add(Integer.parseInt(p));
					}
				}
				list.add(list1);
			}
		}
		return list;
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
	
	public static List<List<Double>> parseListsByDouble(String str, String split1, String split2) throws Exception{
		List<List<Double>> list = new ArrayList<List<Double>>();
		if(str.length() > 0){
			String ss[] = str.split(split1);
			for(String s : ss){
				String ps[] = s.split(split2);
				List<Double> list1 = new ArrayList<Double>();
				for(String p : ps){
					if(p.length() > 0){
						list1.add(Double.parseDouble(p));
					}
				}
				list.add(list1);
			}
		}
		return list;
	}
	
	public static List<List<Float>> parseListsByFloat(String str, String split1, String split2) throws Exception{
		List<List<Float>> list = new ArrayList<List<Float>>();
		if(str.length() > 0){
			String ss[] = str.split(split1);
			for(String s : ss){
				String ps[] = s.split(split2);
				List<Float> list1 = new ArrayList<Float>();
				for(String p : ps){
					if(p.length() > 0){
						list1.add(Float.parseFloat(p));
					}
				}
				list.add(list1);
			}
		}
		return list;
	}

	public static String parseString(Collection<Integer> list, String join){
		if(list != null && !list.isEmpty()){
			StringBuffer sb = new StringBuffer();
			for(Integer id : list){
				sb.append(id).append(join);
			}
			if(sb.length() > 0)
				return sb.substring(0, sb.length() - join.length());
			return sb.toString();
		}
		return "";
	}

	public static String parseString(List<List<Integer>> lists, String join1, String join2){
		if(lists != null && !lists.isEmpty()){
			StringBuffer sb = new StringBuffer();
			for(List<Integer> list : lists){
				sb.append(parseString(list, join2)).append(join1);
			}
			if(sb.length() > 0)
				return sb.substring(0, sb.length() - join1.length());
			return sb.toString();
		}
		return "";
	}

	public static String parseString(Map<Integer, Integer> map, String join1, String join2){
		StringBuffer sb = new StringBuffer();
		for(Map.Entry<Integer, Integer> entry : map.entrySet()){
			sb.append(entry.getKey()).append(join2).append(entry.getValue()).append(join1);
		}
		if(sb.length() > 0)
			return sb.substring(0, sb.length() - join1.length());
		return sb.toString();
	}
	
	public static String parseStringByDouble(List<List<Double>> lists, String join1, String join2){
		StringBuffer sb = new StringBuffer();
		for(List<Double> list : lists){
			sb.append(parseStringByDouble(list, join2)).append(join1);
		}
		if(sb.length() > 0)
			return sb.substring(0, sb.length() - join1.length());
		return sb.toString();
	}
	
	public static String parseStringByDouble(Collection<Double> list, String join){
		StringBuffer sb = new StringBuffer();
		for(Double value : list){
			sb.append(value).append(join);
		}
		if(sb.length() > 0)
			return sb.substring(0, sb.length() - join.length());
		return sb.toString();
	}
	
	public static String parseStringByFloat(List<List<Float>> lists, String join1, String join2){
		StringBuffer sb = new StringBuffer();
		for(List<Float> list : lists){
			sb.append(parseStringByFloat(list, join2)).append(join1);
		}
		if(sb.length() > 0)
			return sb.substring(0, sb.length() - join1.length());
		return sb.toString();
	}
	
	public static String parseStringByFloat(Collection<Float> list, String join){
		StringBuffer sb = new StringBuffer();
		for(Float value : list){
			sb.append(value).append(join);
		}
		if(sb.length() > 0)
			return sb.substring(0, sb.length() - join.length());
		return sb.toString();
	}
	
	public static String parseStringByString(Collection<String> list, String join){
		StringBuffer sb = new StringBuffer();
		for(String id : list){
			sb.append(id).append(join);
		}
		if(sb.length() > 0)
			return sb.substring(0, sb.length() - join.length());
		return sb.toString();
	}
	
	public static String parseStringByString(List<List<String>> lists, String join1, String join2){
		StringBuffer sb = new StringBuffer();
		for(List<String> list : lists){
			sb.append(parseStringByString(list, join2)).append(join1);
		}
		if(sb.length() > 0)
			return sb.substring(0, sb.length() - join1.length());
		return sb.toString();
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

	public static String encode(String content, String oldCharsetName, String charsetName) throws Exception{
		return new String(content.getBytes(oldCharsetName), charsetName);
	}

	public static String toDBC(String input){
		if(null != input){
			char c[] = input.toCharArray();
			for(int i = 0; i < c.length; i++){
				if('\u3000' == c[i]){
					c[i] = ' ';
				}else if(c[i] > '\uFF00' && c[i] < '\uFF5F'){
					c[i] = (char) (c[i] - 65248);
				}
			}
			String dbc = new String(c);
			return dbc;
		}else{
			return null;
		}
	}

	public static String toDBCLowerCaseTrim(String input){
		if(input != null){
			return toDBC(input).toLowerCase().trim();
		}
		return null;
	}

	public static String encodeQQParam(String str){
		StringBuffer sb = new StringBuffer();
		for(char c : str.toCharArray()){
			String s = String.valueOf(c);
			if(!Pattern.matches("[\\w\\!\\*\\(\\)]", s)){
				int n = (int) c;
				String hex = "%" + Integer.toHexString(n);
				sb.append(hex.toUpperCase());
			}else{
				sb.append(s);
			}
		}
		return sb.toString();
	}

	public static String getSqlValue(Object object) throws Exception{
		String str = object.toString();
		if(object instanceof String){
			str = str.replaceAll("\\\\", "\\\\\\\\");
			str = str.replaceAll("\'", "\\\\'");
			str = "'" + str + "'";
		}
		return str;
	}

	public static String getLikeSqlValue(String str, boolean prefix, boolean suffix) throws Exception{
		str = str.replaceAll("\\\\", "\\\\\\\\");
		str = str.replaceAll("\'", "\\\\'");
		if(prefix){
			str = "%" + str;
		}
		if(suffix){
			str = str + "%";
		}
		str = "'" + str + "'";
		return str;
	}

	public static void main(String args[]){
		System.out.println(Integer.toHexString(0x3480ff));
	}
}
