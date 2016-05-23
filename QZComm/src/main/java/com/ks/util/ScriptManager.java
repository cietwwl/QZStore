package com.ks.util;

import java.util.Map;
import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;
import org.apache.log4j.Logger;

import com.ks.logger.LoggerFactory;
/**
 * 表达式执行工具
 * @author hanjie.l
 *
 */
public class ScriptManager {
	
	private static final JexlEngine jexl = new JexlEngine();
	
	private static final Logger LOGGER = LoggerFactory.get(ScriptManager.class);
    
    /**
     * 执行表达式返回Boolean结果
     * @param expression
     * @param map
     * @return
     */
    public static boolean invokeBooleanExpression(Expression expression, Map<String, Object> map){
    	
    	try {
    		return (Boolean)expression.evaluate(new MapContext(map));
		} catch (Exception e) {
			LOGGER.error("表达式执行报错", e);
		}
    	
    	return false;
    }
    
    /**
     * 创建表达式
     * @param expression
     * @return
     */
    public static Expression createExpression(String expression){
    	Expression result = null;
		try {
			result = jexl.createExpression(expression);
		} catch (Exception e) {
			throw new RuntimeException("表达式转换报错", e);
		}
		return result;
    }

}
