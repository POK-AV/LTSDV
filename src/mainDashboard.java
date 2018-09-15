//Made by Trey Carey | 9.14.18

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;
import javafx.stage.Stage;


public abstract class mainDashboard extends Application{
	
	public static void makeDashboard(Double accessLevel) {
		startSD();
		Stage primaryStage = new Stage();
		
		BorderPane borderPane = new BorderPane();
		borderPane.setId("background");
		
		Scene mainDashboard = new Scene(borderPane, 800, 600);
		
		mainDashboard.getStylesheets().add("/files/styles.css");
		
		Label title = new Label(applicationSettings.getApplicationName());
		title.setId("titles");
		BorderPane.setAlignment(title, Pos.CENTER);
		borderPane.setTop(title);
		
		//POK LOGO\\
		ImageView pokLogo = new ImageView("/images/POK LOGO.png");
		HBox bottomHBox = new HBox();
		//Code below is a little hacky but it gets the job done.
		bottomHBox.setPadding(new Insets(0, 0, 22, mainDashboard.getWidth() / 2 - pokLogo.boundsInParentProperty().get().getWidth() / 2));
		bottomHBox.getChildren().addAll(pokLogo);
		BorderPane.setAlignment(bottomHBox, Pos.CENTER);
		borderPane.setBottom(bottomHBox);
		
		primaryStage.setTitle(applicationSettings.getApplicationName());
		primaryStage.setResizable(false);
		primaryStage.setScene(mainDashboard);
		primaryStage.setFullScreen(false); //Has to be here to fix both Stages going FullScreen
		primaryStage.show();
	}
	
	public static void startSD() {
		
		System.out.println(Screen.getScreens());
		
		Stage sdStage = new Stage();
		
		BorderPane borderPane = new BorderPane();
		borderPane.setId("SDbackground");
		
		borderPane.getStylesheets().add("/files/styles.css");
		
		Scene mainDashboard = new Scene(borderPane, 800, 600);
		
		Label sdText = new Label("This is a Stage Display test");
		BorderPane.setAlignment(sdText, Pos.CENTER);
		sdText.setPadding(new Insets(50));
		sdText.setId("sdText");
		borderPane.setBottom(sdText);
		
		
		sdStage.setFullScreen(true);
		sdStage.setTitle(applicationSettings.getApplicationName() + " - VIEWER");
		sdStage.setResizable(false);
		sdStage.setScene(mainDashboard);
		sdStage.show();
	}

}
