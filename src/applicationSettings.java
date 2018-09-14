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
	public static double lookupUser(String name, String password) throws IOException {
		InputStream inputStream = applicationSettings.class.getResourceAsStream("/files/users.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Integer lastRow = sheet.getPhysicalNumberOfRows();
		int currentRow = 1;
		
		/*
		 * Currently this breaks for Alan Moreno, don't know why, need to fix
		 */
		
		//TODO: Fix this breaking on Alan Moreno
		while(currentRow < lastRow) {
			if(sheet.getRow(currentRow).getCell(0).getStringCellValue().toLowerCase().equals(name.toLowerCase())) {
				if(sheet.getRow(currentRow).getCell(1).getStringCellValue().toLowerCase().equals(password.toLowerCase())) {
					double accessLevel = sheet.getRow(currentRow).getCell(2).getNumericCellValue();
					System.out.println(accessLevel);
					return accessLevel;
				}
			}
			currentRow++;
		}
		return 4.0;
	}
	
}
