package com.zhc.commonjava.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellReference;

import com.microsoft.schemas.office.visio.x2012.main.CellType;

public class ReadExcelUtils {

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {

		InputStream inputStream = new FileInputStream("https://hwtraining.obs.cn-north-1.myhwclouds.com/forum/hwtraining_teacher_studentinf.xls");
		// InputStream inp = new
		// FileInputStream("C:/Users/H__D/Desktop/workbook.xls");

		Workbook workbook = WorkbookFactory.create(inputStream);
		Sheet sheet = workbook.getSheetAt(0);

		DataFormatter formatter = new DataFormatter();
		int i = 1;
		for (Row row : sheet) {
			System.out.print("Row: " + i++);
			Short num = row.getLastCellNum();
			System.out.println(" Number: " + num);
			String inviter = formatter.formatCellValue(row.getCell(0));
			String classId = formatter.formatCellValue(row.getCell(1));
			String companyName = formatter.formatCellValue(row.getCell(2));
			String industry = formatter.formatCellValue(row.getCell(3));
			String name = formatter.formatCellValue(row.getCell(4));
			String title = formatter.formatCellValue(row.getCell(5));
			String phoneNumber = formatter.formatCellValue(row.getCell(6));
			String email = formatter.formatCellValue(row.getCell(7));
			String hwcloudId = formatter.formatCellValue(row.getCell(8));
			String comment = formatter.formatCellValue(row.getCell(9));
			String studentId = formatter.formatCellValue(row.getCell(10));
			String addsql = "insert into hwtraining_teacher_studentinf value('" + inviter + "','" + classId + "','"
					+ companyName + "','" + industry + "','" + name + "','" + title + "','" + phoneNumber + "','"
					+ email + "','" + hwcloudId + "','" + comment + "','" + studentId + "',null,null)";
			System.out.println(addsql);
			/*
			 * for (Cell cell : row) { CellReference cellRef = new
			 * CellReference(row.getRowNum(), cell.getColumnIndex()); // 单元格名称
			 * 
			 * System.out.print(cellRef.formatAsString()); System.out.print(
			 * " - ");
			 * 
			 * 
			 * // 通过获取单元格值并应用任何数据格式（Date，0.00，1.23e9，$ 1.23等），获取单元格中显示的文本 String
			 * text = formatter.formatCellValue(cell); System.out.print(text +
			 * " ");
			 * 
			 * // 获取值并自己格式化
			 * 
			 * switch (cell.getCellType()) { case Cell.CELL_TYPE_STRING:// 字符串型
			 * System.out.println(cell.getRichStringCellValue().getString()) ;
			 * break; case Cell.CELL_TYPE_NUMERIC:// 数值型 if
			 * (DateUtil.isCellDateFormatted(cell)) { // 如果是date类型则
			 * ，获取该cell的date值 System.out.println(cell.getDateCellValue()); }
			 * else {// 纯数字 System.out.println(cell.getNumericCellValue()); }
			 * break; case Cell.CELL_TYPE_BOOLEAN:// 布尔
			 * System.out.println(cell.getBooleanCellValue()); break; case
			 * Cell.CELL_TYPE_FORMULA:// 公式型
			 * System.out.println(cell.getCellFormula()); break; case
			 * Cell.CELL_TYPE_BLANK:// 空值 System.out.println(); break; case
			 * Cell.CELL_TYPE_ERROR: // 故障 System.out.println(); break; default:
			 * System.out.println(); }
			 * 
			 * }
			 */
			System.out.println();
		}

	}
	public void exportExcel(){
		
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("table");  //创建table工作薄
		Object[][] datas = {{"区域", "总销售额(万元)", "总利润(万元)简单的表格"}, {"江苏省" , 9045,  2256}, {"广东省", 3000, 690}};
		HSSFRow row;
		HSSFCell cell;
		for(int i = 0; i < datas.length; i++) {
			row = sheet.createRow(i);//创建表格行
			for(int j = 0; j < datas[i].length; j++) {
				cell = row.createCell(j);//根据表格行创建单元格
				cell.setCellValue(String.valueOf(datas[i][j]));
			}
		}
		try {
			wb.write(new FileOutputStream("/Users/mike/table.xls"));
		} catch (FileNotFoundException e) {
			  
			// TODO Auto-generated catch block  
			e.printStackTrace();  
			
		} catch (IOException e) {
			  
			// TODO Auto-generated catch block  
			e.printStackTrace();  
			
		}
	}

}