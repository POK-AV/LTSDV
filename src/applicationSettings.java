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
	public static Boolean lookupUser(String name, String password) throws IOException {
		InputStream inputStream = applicationSettings.class.getResourceAsStream("/files/users.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Integer lastRow = sheet.getPhysicalNumberOfRows();
		int currentRow = 1;
		
		while(currentRow < lastRow) {
			System.out.println("Current Row: " + currentRow + " | Contents: " + sheet.getRow(currentRow).getCell(0).getStringCellValue());
			if(sheet.getRow(currentRow).getCell(0).getStringCellValue().equals(name)) {
				System.out.println("Username Match! Username: " + name);
				if(sheet.getRow(currentRow).getCell(1).getStringCellValue().equals(password)) {
					System.out.println("Password Match! Password: " + password);
					return true;
				}else {
					System.out.println("Wrong Password!");
					return false;
				}
			}
			currentRow++;
		}
		return false;
	}
	
}
