package DataDrivenSample;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
@Test
public class Test1 {

	public void getData() throws IOException {
//	public static void main(String[] args) throws IOException {	
//		2.once column is identified then scan the entire testcase column to identify any testcase row
//		3. after you grab login testcase row = pull all thedata of that row and feed into test
//		FIleinputstream arguments--FIS class have power to open and read write file
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir")+File.separator +"TestData"+ File.separator +"TestDemo.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		 XSSFSheet sheets = workbook.getSheet("TestSheet");
		 
		 HashMap<String, String> map = new HashMap<String, String>();
		 int rowcount = sheets.getLastRowNum();
		 System.out.println(rowcount);
//		 Thread.sleep(3000);
		 for(int i =1; i<rowcount; i++)
		 {
			String key = sheets.getRow(i).getCell(0).getStringCellValue();
			String value = sheets.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
			System.out.println(value);
		 }
		 workbook.close();		
		
	}
}
