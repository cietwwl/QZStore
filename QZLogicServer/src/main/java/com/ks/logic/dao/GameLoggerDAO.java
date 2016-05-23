package com.ks.logic.dao;

import java.util.List;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBBeanSetInsertSqlSet;
import com.ks.access.DBBeanSetSqlSetList;
import com.ks.access.GameDAOTemplate;
import com.ks.constant.SystemConstant;
import com.ks.db.log.DiamondLogger;
import com.ks.db.log.EquipmentLogger;
import com.ks.db.log.EternalLogger;
import com.ks.db.log.ExpLogger;
import com.ks.db.log.GameLogger;
import com.ks.db.log.GoldLogger;
import com.ks.db.log.GpLogger;
import com.ks.db.log.HeroExpPoolLogger;
import com.ks.db.log.HeroLogger;
import com.ks.db.log.LoginLogger;
import com.ks.db.log.OnlineReportLogger;
import com.ks.db.log.PropLogger;
import com.ks.db.log.RegistLossLogger;
import com.ks.db.log.SlateLogger;
import com.ks.db.log.StaminaLogger;
import com.ks.exceptions.GameException;
/**
 * 游戏日志
 * @author ks
 */
public class GameLoggerDAO extends GameDAOTemplate {
	/**
	 * 添加游戏日志
	 * @param logger
	 */
	@DBBeanSetSqlSetList(inserts={
			@DBBeanSetInsertSqlSet(name="addGameLogger", dbbean=DiamondLogger.class),
			@DBBeanSetInsertSqlSet(name="addGameLogger", dbbean=EquipmentLogger.class),
			@DBBeanSetInsertSqlSet(name="addGameLogger", dbbean=EternalLogger.class),
			@DBBeanSetInsertSqlSet(name="addGameLogger", dbbean=ExpLogger.class),
			@DBBeanSetInsertSqlSet(name="addGameLogger", dbbean=GoldLogger.class),
			@DBBeanSetInsertSqlSet(name="addGameLogger", dbbean=GpLogger.class),
			@DBBeanSetInsertSqlSet(name="addGameLogger", dbbean=HeroExpPoolLogger.class),
			@DBBeanSetInsertSqlSet(name="addGameLogger", dbbean=HeroLogger.class),
			@DBBeanSetInsertSqlSet(name="addGameLogger", dbbean=PropLogger.class),
			@DBBeanSetInsertSqlSet(name="addGameLogger", dbbean=SlateLogger.class),
			@DBBeanSetInsertSqlSet(name="addGameLogger", dbbean=StaminaLogger.class)
			})
	public void addGameLogger(GameLogger logger){
		String sql = DBBeanRowMapperManager.getDynamicSql(toClazz(logger), "addGameLogger");
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(toClazz(logger), "addGameLogger", logger);
		saveOrUpdate(sql, params.toArray());
	}
	
	@SuppressWarnings("rawtypes")
	private Class toClazz(GameLogger logger){
		switch (logger.getLoggerType()) {
		case SystemConstant.LOGGER_TYPE_HERO:
			return HeroLogger.class;
		case SystemConstant.LOGGER_TYPE_DIAMOND:
			return DiamondLogger.class;
		case SystemConstant.LOGGER_TYPE_GOLD:
			return GoldLogger.class;
		case SystemConstant.LOGGER_TYPE_GP:
			return GpLogger.class;
		case SystemConstant.LOGGER_TYPE_EXP:
			return ExpLogger.class;
		case SystemConstant.LOGGER_TYPE_PROP:
			return PropLogger.class;
		case SystemConstant.LOGGER_TYPE_STAMINA:
			return StaminaLogger.class;
		case SystemConstant.LOGGER_TYPE_HERO_EXP_POOL:
			return HeroExpPoolLogger.class;
		case SystemConstant.LOGGER_TYPE_EQUIPMENT:
			return EquipmentLogger.class;
		case SystemConstant.LOGGER_TYPE_ETERNAL:
			return EternalLogger.class;
		case SystemConstant.LOGGER_TYPE_SLATE:
			return SlateLogger.class;
		default:
			throw new GameException(GameException.CODE_参数错误, "");
		}
	}
	
	@DBBeanSetSqlSetList(inserts={@DBBeanSetInsertSqlSet(name="addRegistLossLogger", dbbean=RegistLossLogger.class)})
	public void addRegistLossLogger(RegistLossLogger logger){
		String sql = DBBeanRowMapperManager.getDynamicSql(RegistLossLogger.class, "addRegistLossLogger");
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(RegistLossLogger.class, "addRegistLossLogger", logger);
		saveOrUpdate(sql, params.toArray());
	}
	
	@DBBeanSetSqlSetList(inserts={@DBBeanSetInsertSqlSet(name="addOnlineReportLogger", dbbean=OnlineReportLogger.class)})
	public void addOnlineReportLogger(OnlineReportLogger logger){
		String sql = DBBeanRowMapperManager.getDynamicSql(OnlineReportLogger.class, "addOnlineReportLogger");
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(OnlineReportLogger.class, "addOnlineReportLogger", logger);
		saveOrUpdate(sql, params.toArray());
	}
	
	@DBBeanSetSqlSetList(inserts={@DBBeanSetInsertSqlSet(name="addLoginLogger", dbbean=LoginLogger.class)})
	public void addLoginLogger(LoginLogger logger){
		String sql = DBBeanRowMapperManager.getDynamicSql(LoginLogger.class, "addLoginLogger");
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(LoginLogger.class, "addLoginLogger", logger);
		saveOrUpdate(sql, params.toArray());
	}
}