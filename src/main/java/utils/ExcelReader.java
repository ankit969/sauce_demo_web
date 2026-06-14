package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public final class ExcelReader {
	
	private ExcelReader() {}
	
	public static Map<String, String> getRowDataByTcId(String filePath, String sheetName, String tcId){
		Map<String, String> rowData = new LinkedHashMap<>();
		
		try(FileInputStream fis = new FileInputStream(filePath); Workbook workbook = new XSSFWorkbook(fis);) {
			
			Sheet sheet = workbook.getSheet(sheetName);
			if(sheet == null) {
				throw new RuntimeException("Sheet not found: "+sheetName);
			}
			
			
			Row headerRow = sheet.getRow(0);
			int rowCount = sheet.getPhysicalNumberOfRows();
			int colCount = headerRow.getPhysicalNumberOfCells();
			
			for(int i=1; i<rowCount; i++) {
				Row currentRow = sheet.getRow(i);
				if(currentRow == null) {
					continue;
				}
				
				Cell tcIdCell = currentRow.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
				String currentTcId = getCellValueAsString(tcIdCell).trim();
				
				if(currentTcId.equalsIgnoreCase(tcId)) {
					for(int j=0; j<colCount; j++) {
						String columnName = getCellValueAsString(headerRow.getCell(j)).trim();
						String cellValue = getCellValueAsString(currentRow.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)).trim();
						rowData.put(columnName, cellValue);
					}
					return rowData;
				}
			}
			throw new RuntimeException("TC_ID not fount: "+tcId);
		} catch (IOException e) {
			throw new RuntimeException("Failed to read Excel file: "+filePath, e);
		}
	}
	
	public static Object[][] getSheetDataAsDataProvider(String filePath, String sheetName) {
		try(FileInputStream fis = new FileInputStream(filePath); Workbook workbook = new XSSFWorkbook(fis);){
			
			
			Sheet sheet = workbook.getSheet(sheetName);
			if(sheet == null) {
				throw new RuntimeException("Sheet not found: "+sheetName);
			}
			
			int rowCount = sheet.getPhysicalNumberOfRows();
			
			Object[][] data = new Object[rowCount - 1][1];
			
			for(int i=1; i<rowCount; i++) {
				Row currentRow = sheet.getRow(i);
				String tcId = getCellValueAsString(currentRow.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)).trim();
				data[i - 1][0] = tcId;
			}
			
			return data;
		} catch (IOException e) {
			throw new RuntimeException("Failed to read Excel file: "+filePath, e);
		}
	}

	private static String getCellValueAsString(Cell cell) {
		if(cell == null) {
			return "";
		}
		
		DataFormatter formatter = new DataFormatter();
		return formatter.formatCellValue(cell);
	}

}
