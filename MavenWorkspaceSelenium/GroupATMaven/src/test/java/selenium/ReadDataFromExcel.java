package selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ReadDataFromExcel {

	public static void main(String[] args) throws IOException 
	{
		String filePath="C:\\Akash\\eclipse-workspace";
		String fileName="guru99_demo_cred.xlsx";
		String sheetName="Sheet1";
		
		File file = new File(filePath+"\\"+fileName);
		FileInputStream inputStream = new FileInputStream(file);
		
		Workbook workbook = null;
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		
		workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		int rowCount= sheet.getLastRowNum();
		System.out.println(rowCount);
		
		
		
		
		Row row = sheet.getRow(0);
		int colCount = row.getLastCellNum();
		System.out.println(colCount);
		String[][] loginCred = new String[rowCount][colCount];
		
		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				Row row1 = sheet.getRow(i);
				loginCred[i-1][j] = row1.getCell(j).getStringCellValue();
			}
		}
		
		for(int i=0;i<rowCount;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				System.out.print(" "+loginCred[i][j]);
			}
			System.out.println();
		}
		
		System.out.println(loginCred);
		String userId = row.getCell(0).getStringCellValue();
		System.out.print(userId+"|| ");
		
		String pass = row.getCell(1).getStringCellValue();
		System.out.print(pass+"|| ");		

	}

}
