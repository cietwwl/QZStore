package com.ks.logic.creator;

import java.io.File;

import com.ks.access.DBBeanSqlTemplateUtil;

public class DBBeanSqlTemplateCreator {
	public static void main(String args[]) throws Exception{
		String dbfile = "conf"+File.separatorChar+"DBBeanMapper.properties";
		String daofile = "conf"+File.separatorChar+"DynamicSqlMapper.properties";
		DBBeanSqlTemplateUtil.createDBBeanSqlTemplates(dbfile, daofile, "src/main/java", "com.ks.logic.db_template");
	}
}
