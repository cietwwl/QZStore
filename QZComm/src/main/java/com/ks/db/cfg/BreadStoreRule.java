package com.ks.db.cfg;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.util.MathUtil;
import com.ks.util.XyStringUtil;

@DBBeanSet(tablename="t_bread_store_rule", createDeleteSql=false, createSelectSql=false, createInsertSql=false, createUpdateSql=false)
public class BreadStoreRule implements Serializable{
	private static final long serialVersionUID = 1L;

	/**等级区间*/
	@DBFieldSet(dbfname="n_levels")
	private String levels;
	/**星级概率*/
	@DBFieldSet(dbfname="n_starProbabilitys")
	private String starProbabilitys;
	/**总概率*/
	private int probability;
	/**等级区间list*/
	private List<Integer> levelList;
	/**星级概率map*/
	private Map<Integer, Integer> probabilityMap;

	public String getLevels(){
		return levels;
	}
	public void setLevels(String levels){
		this.levels = levels;
		initLevelList();
	}
	public String getStarProbabilitys(){
		return starProbabilitys;
	}
	public void setStarProbabilitys(String starProbabilitys){
		this.starProbabilitys = starProbabilitys;
		initProbabilityMap();
	}
	public int getStar(){
		if(probability > 0){
			int random = MathUtil.nextInt(probability);
			for(Entry<Integer, Integer> entry : probabilityMap.entrySet()){
				if(random < entry.getValue().intValue()){
					return entry.getKey();
				}else{
					random -= entry.getValue();
				}
			}
		}
		return 1;
	}
	public boolean hasLevel(int level){
		if(levelList.size() >= 2){
			return levelList.get(0).intValue() <= level && level <= levelList.get(1).intValue();
		}
		return false;
	}
	private void initLevelList(){
		levelList = XyStringUtil.parseList(levels, XyStringUtil.SPLIT_UNDERLINE);
	}
	private void initProbabilityMap(){
		probabilityMap = XyStringUtil.parseMap(starProbabilitys, XyStringUtil.SPLIT_VERTICALLINE, XyStringUtil.SPLIT_UNDERLINE);
		for(Entry<Integer, Integer> entry : probabilityMap.entrySet()){
			probability += entry.getValue();
		}
	}
}
