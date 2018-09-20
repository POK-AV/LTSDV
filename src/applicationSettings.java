//Made by Trey Carey | 9.11.18

import java.io.IOException;
import java.io.InputStream;

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
	
	static Label sdText = null;
	
public static Stage startSD(Stage primaryStage) throws InterruptedException {
		
		Stage sdStage = new Stage();
		
		BorderPane borderPane = new BorderPane();
		borderPane.setId("SDbackground");
		
		borderPane.getStylesheets().add("/files/styles.css");
		
		Scene mainDashboard = new Scene(borderPane, 800, 600);
		
		sdText = new Label("This is a Stage Display test, I have to ensure that this text is long to make sure that it is correctly formatting on the screen and not clipping whatsoever.");
		BorderPane.setAlignment(sdText, Pos.CENTER);
		sdText.setPadding(new Insets(50));
		sdText.setId("sdText");
		sdText.setWrapText(true);
		borderPane.setBottom(sdText);
		
		
		sdStage.setTitle(applicationSettings.getApplicationName() + " - VIEWER");
		sdStage.setScene(mainDashboard);
		
		//TODO: Clean up .setX and make it right
		sdStage.setX(-1930.0); //Ghetto, but works for now, tested on LG 4K Curved OLED 70'
		
		/*
		 * Below is an attempt to fix a bug in which the mainDisplay continues to
		 * fullscreen itself even after being implicitly told not too, who even
		 * knows why computers do what they do anymore. Maybe i'm just missing something
		 * obvious. Anyways this seems to work for now, i'll have to do some more
		 * studying later and see if there's something i'm missing that would cause this.
		 */

		/*
		 *Below is a little bit hacky, just like the rest of this project. However
		 * it's what I had to do to get the Stage Display working correctly
		 * Need to add a check to find the second display and see what screen
		 * this needs to go on.
		 *
		 *
		 */

		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

		sdStage.initStyle(StageStyle.UNDECORATED);

		//Set the size of the SD to the screens dimensions
		sdStage.setX(primaryScreenBounds.getMinX());
		sdStage.setY(primaryScreenBounds.getMinY());
		sdStage.setWidth(primaryScreenBounds.getWidth());
		sdStage.setHeight(primaryScreenBounds.getHeight());

		sdStage.show();

		return sdStage;
	}

	public static void updateSDText(String newText) {
		sdText.setText(newText);
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

}
