//Made by Trey Carey | 9.11.18

import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class applicationSettings {
	
	static String name = "Lower Thirds SDV";
	static double versionNumber = 1.0;
	
	static Boolean fileOpen = false;
	
	public static String getApplicationName() {
		String applicationName = name + " " + versionNumber;
		return applicationName;
	}
	
	@SuppressWarnings("resource")
	public static String lookupUser(String name, String password) throws IOException {
		InputStream inputStream = applicationSettings.class.getResourceAsStream("/files/users.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Integer lastRow = sheet.getPhysicalNumberOfRows();
		int currentRow = 1;
		
		while(currentRow < lastRow) {
			if(sheet.getRow(currentRow).getCell(0).getStringCellValue().equals(name)) {
				if(sheet.getRow(currentRow).getCell(1).getStringCellValue().equals(password)) {
					if(sheet.getRow(currentRow).getCell(2).getNumericCellValue() == 1) {
						return "1";
					}else if(sheet.getRow(currentRow).getCell(2).getNumericCellValue() == 2){
						return "2";
					}
				}else if(sheet.getRow(currentRow).getCell(2).getNumericCellValue() == 3){
					return "3";
				}
			}
			currentRow++;
		}
		return "4";
	}
	
}
