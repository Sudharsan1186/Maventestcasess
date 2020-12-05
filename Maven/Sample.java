package monday.fiveoctober;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Sample {

	public static String[][] read() throws IOException
	{
		XSSFWorkbook ws = new XSSFWorkbook("./data/Create Lead.xlsx");
		
        XSSFSheet sheet = ws.getSheetAt(0);
        
        int lastRow = sheet.getLastRowNum();
        
        short cellNum = sheet.getRow(0).getLastCellNum();
        
        String[][] data = new String[lastRow][cellNum];
        
    	for (int i = 1; i <= lastRow; i++) 
    	{
			
			for (int j = 0; j < cellNum; j++) 
			
			 {
               String Cellvalue = sheet.getRow(i).getCell(j).getStringCellValue();
               
               
        
        
	}
}
		return data;
}
	

}
