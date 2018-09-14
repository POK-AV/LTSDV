//Made by Trey Carey | 9.14.18

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class mainDashboard extends Application{
	
	public static void makeDashboard(Double accessLevel) {
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
		primaryStage.show();
	}

	public void start(Stage primaryStage) throws Exception {
		
	}

}
