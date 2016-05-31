package com.utils;

import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;

import com.execel.formater.ValueFormater;

public class ExcelUtil {
	public static void write(String sheetname, List<?> list, List<ValueFormater> formaters, OutputStream stream) throws Exception{
		int rindex = 0;
		int cindex = 0;
		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet(sheetname);
		
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		HSSFRow row = sheet.createRow(rindex++);
		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		
		for(ValueFormater formater : formaters){
			sheet.setColumnWidth(cindex, 4500);
			HSSFCell cell = row.createCell(cindex);
			cell.setCellValue(formater.getHname());
			cell.setCellStyle(style);
			cindex++;
		}
		if(!list.isEmpty()){
			for(Object object : list){
				row = sheet.createRow(rindex++);
				cindex = 0;
				for(ValueFormater formater : formaters){
					HSSFCell cell = row.createCell(cindex++);
					cell.setCellType(XSSFCell.CELL_TYPE_STRING);
					cell.setCellValue(formater.format(object));
					cell.setCellStyle(style);
				}
			}
		}
		wb.write(stream);
	}
}
