//Made by Trey Carey | 9.11.18

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
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
	
	public static void openFile() throws IOException {
		InputStream inputStream = applicationSettings.class.getResourceAsStream("/files/users.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheetAt(0);
		System.out.println(sheet.getRow(1).getCell(1));
		fileOpen = true;
	}
	
	public static Boolean lookupUser() throws IOException {
		if(fileOpen == false) {
			openFile();
			lookupUser();
		}else {
			
		}
		return false;
	}
	
}
