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
		
		Stage primaryStage = new Stage();
		
		Stage stageDisplay = startSD(primaryStage);
		
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
		
		primaryStage.setOnCloseRequest(event -> {
		    stageDisplay.close();
		});
	}
	
	public static Stage startSD(Stage primaryStage) {
		
		System.out.println(Screen.getScreens());
		
		Stage sdStage = new Stage();
		sdStage.setFullScreen(true);
		
		BorderPane borderPane = new BorderPane();
		borderPane.setId("SDbackground");
		
		borderPane.getStylesheets().add("/files/styles.css");
		
		Scene mainDashboard = new Scene(borderPane, 800, 600);
		
		Label sdText = new Label("This is a Stage Display test, I have to ensure that this text is long to make sure that it is correctly formatting on the screen and not clipping whatsoever.");
		BorderPane.setAlignment(sdText, Pos.CENTER);
		sdText.setPadding(new Insets(50));
		sdText.setId("sdText");
		sdText.setWrapText(true);
		borderPane.setBottom(sdText);
		
		
		sdStage.setTitle(applicationSettings.getApplicationName() + " - VIEWER");
		sdStage.setResizable(false);
		sdStage.setScene(mainDashboard);
		sdStage.show();
		
		/*
		 * Below is an attempt to fix a bug in which the mainDisplay continues to
		 * fullscreen itself even after being implicitly told not too, who even
		 * knows why computers do what they do anymore. Maybe i'm just missing something
		 * obvious. Anyways this seems to work for now, i'll have to do some more
		 * studying later and see if there's something i'm missing that would cause this.
		 */
		
		//TODO: Refactor this, make it nice and non-hacky
		primaryStage.setFullScreen(false);
		primaryStage.setMaxHeight(600);
		primaryStage.setMaxWidth(800);
		primaryStage.setFullScreen(false);
		
		
		return sdStage;
	}

}
