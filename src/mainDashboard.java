//Made by Trey Carey | 9.14.18

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public abstract class mainDashboard extends Application{
	
	public static void makeDashboard(Double accessLevel) throws InterruptedException{
		
		Stage primaryStage = new Stage();
		
		Stage stageDisplay = applicationSettings.startSD(primaryStage);
		
		BorderPane borderPane = new BorderPane();
		borderPane.setId("background");
		
		Scene mainDashboard = new Scene(borderPane, 800, 600);
		
		mainDashboard.getStylesheets().add("/files/styles.css");
		
		Label title = new Label(applicationSettings.getApplicationName());
		title.setId("titles");
		BorderPane.setAlignment(title, Pos.CENTER);
		borderPane.setTop(title);
		
		//POK LOGO\\
		ImageView pokLogo = new ImageView("/images/POK Logo.png");
		HBox bottomHBox = new HBox();
		//Code below is a little hacky but it gets the job done.
		bottomHBox.setPadding(new Insets(0, 0, 22, mainDashboard.getWidth() / 2 - pokLogo.boundsInParentProperty().get().getWidth() / 2));
		bottomHBox.getChildren().addAll(pokLogo);
		BorderPane.setAlignment(bottomHBox, Pos.CENTER);
		borderPane.setBottom(bottomHBox);
		
		//CENTER VBOX\\
		VBox centerVBox = new VBox(40);
		
		//BIBLES\\
		Button biblesButton = new Button("BIBLES");
		biblesButton.setId("settingsButtons");
		
		//LOWER THIRDS\\
		Button lowerThirds = new Button("LOWER THIRDS");
		lowerThirds.setId("settingsButtons");
		
		//LYRICS\\
		Button lyricsButton = new Button("LYRICS");
		lyricsButton.setId("settingsButtons");
		
		//ADMIN THINGS\\
		Button adminArea = new Button("ADMIN AREA");
		adminArea.setId("settingsButtons");
		adminArea.setOnAction(e ->{
			try {
				adminInterface.makeAdminInterface();
				applicationSettings.setWindowOpen(true);
				//primaryStage.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
				
		if(accessLevel == 1.0) {
			centerVBox.getChildren().addAll(adminArea);
			centerVBox.setPadding(new Insets(50, 190, 0, 190));
		}else {
			centerVBox.setPadding(new Insets(90, 190, 0, 190));
		}
		
		borderPane.setCenter(centerVBox);
		centerVBox.getChildren().addAll(biblesButton, lowerThirds, lyricsButton);
		
		primaryStage.setTitle(applicationSettings.getApplicationName());
		primaryStage.setResizable(false);
		primaryStage.setScene(mainDashboard);
		primaryStage.show();


		primaryStage.setOnCloseRequest(event -> {
			if(applicationSettings.isWindowOpen()) {
				//Do Nothing?
			}else {
				stageDisplay.close();
			}
		});
	}

}
