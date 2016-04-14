package com.cardvalue.wechat.util;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;

public class ExcelHelper {

	public static HSSFWorkbook createWorkbook(){
		return new HSSFWorkbook();
	}
	
	public static HSSFSheet createSheet(HSSFWorkbook workbook, String name){
		return workbook.createSheet(name);
	}
	
	@SuppressWarnings("rawtypes")
	public static void build(HSSFSheet worksheet, int startRowIndex, int startColIndex, List<ColumnConfig> configs, List contents) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		// Create font style for the headers
		Font font = worksheet.getWorkbook().createFont();
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);

		// Create cell style for the headers
		HSSFCellStyle headerCellStyle = worksheet.getWorkbook().createCellStyle();
		headerCellStyle.setFillBackgroundColor(HSSFColor.GREY_25_PERCENT.index);
		headerCellStyle.setAlignment(CellStyle.ALIGN_CENTER);
		headerCellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		headerCellStyle.setWrapText(true);
		headerCellStyle.setFont(font);
		headerCellStyle.setBorderBottom(CellStyle.BORDER_THIN);

		// Create the column headers
		HSSFRow rowHeader = worksheet.createRow(startRowIndex);
		rowHeader.setHeight((short) 500);
		int index = 0;
		for(ColumnConfig config : configs){
			HSSFCell cell = rowHeader.createCell(startColIndex + index);
			cell.setCellValue(config.getHeader());
			cell.setCellStyle(headerCellStyle);
			index++;
		}
		startRowIndex++;
		for(int i = 0;i < contents.size();i++){
			Object exp = contents.get(i);
			HSSFRow row = worksheet.createRow(startRowIndex + i);
			for(int j = 0;j < configs.size() ;j++){
				HSSFCell cell = row.createCell(startColIndex + j);
				String property = configs.get(j).getProperty();
				cell.setCellValue(BeanUtils.getSimpleProperty(exp, property));
			}
		}
	}
	
}
