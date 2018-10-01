//Made by Trey Carey | 9.11.18

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.StageStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class applicationSettings {
	
	static String name = "Lower Thirds SDV";
	static double versionNumber = 1.0;
	
	static Boolean fileOpen = false;
	
	static Boolean anotherWindowOpen = false;

	static String operatingSystem = new String(System.getProperty("os.name"));

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
		 * Update 9.14.18, Seems to work now? No changes made?
		 */
		
		while(currentRow < lastRow) {
			if(sheet.getRow(currentRow).getCell(0).getStringCellValue().toLowerCase().equals(name.toLowerCase())) {
				if(sheet.getRow(currentRow).getCell(1).getStringCellValue().toLowerCase().equals(password.toLowerCase())) {
					double accessLevel = sheet.getRow(currentRow).getCell(2).getNumericCellValue();
					return accessLevel;
				}
			}
			currentRow++;
		}
		return 4.0;
	}

	
	public static String getProperty(String property) {
		//String host = "localhost";
		
		return "Hello";
	}
	
	public static Boolean isWindowOpen() {
		if(anotherWindowOpen) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void setWindowOpen(Boolean value) {
		anotherWindowOpen = value;
	}

	public static String getOS(){
		return operatingSystem;
	}

	public static void loadProperties() throws IOException{
		Properties properties = new Properties();
		try {
			InputStream propertiesFile = new FileInputStream("/config.properties");
			properties.load(propertiesFile);
		}catch(FileNotFoundException e){
			e.printStackTrace();
			System.out.println("config.properties file was not found");
		}
	}

}
