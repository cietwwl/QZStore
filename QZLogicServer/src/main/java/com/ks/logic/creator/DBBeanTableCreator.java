package com.ks.logic.creator;

import java.io.File;

import com.ks.access.DBBeanTableUtil;

public class DBBeanTableCreator {
	public static void main(String args[]) throws Exception{
		DBBeanTableUtil.createBeanTables("conf"+File.separatorChar+"DBBeanMapper.properties", "src/main/java", "com.ks.table");
	}
}
