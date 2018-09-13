//Made by Trey Carey | 9.11.18

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class loginScreen extends Application{
	
	static int textFieldSize = 250;

	Scene loginScreen;
	public void start(Stage primaryStage) throws Exception {
		
		BorderPane borderPane = new BorderPane();
		borderPane.setId("background");
		
		loginScreen = new Scene(borderPane, 800, 600);
		loginScreen.getStylesheets().add("/files/styles.css");
		
		
		//TITLE\\
		Label title = new Label(applicationSettings.getApplicationName());
		title.setId("titles");
		BorderPane.setAlignment(title, Pos.CENTER);
		borderPane.setTop(title);
		
		//POK LOGO\\
		ImageView pokLogo = new ImageView("/images/POK LOGO.png");
		HBox bottomHBox = new HBox();
		//Code below is a little hacky but it gets the job done.
		bottomHBox.setPadding(new Insets(0, 0, 22, loginScreen.getWidth() / 2 - pokLogo.boundsInParentProperty().get().getWidth() / 2));
		bottomHBox.getChildren().addAll(pokLogo);
		BorderPane.setAlignment(bottomHBox, Pos.CENTER);
		borderPane.setBottom(bottomHBox);
		
		//CENTER PANE LAYOUT\\
		//I am using a pane for the absolute positioning
		Pane centerPaneLayout = new Pane();
		
		//USERNAME FIELD\\
		TextField usernameField = new TextField();
		usernameField.setText("USERNAME");
		usernameField.setMinWidth(textFieldSize);
		usernameField.relocate(300, 100);
		usernameField.setId("textFields");
		
		//PASSWORD FIELD\\
		PasswordField passwordField = new PasswordField();
		passwordField.setText("PASSWORD");
		passwordField.setMinWidth(textFieldSize);
		passwordField.relocate(300, 135);
		passwordField.setId("textFields");
		
		
		//LOGIN BUTTON\\
		Button loginButton = new Button("LOGIN");
		loginButton.relocate(488, 170);
		loginButton.setId("buttons");
		
		//Add everything to Pane\\
		borderPane.setCenter(centerPaneLayout);
		centerPaneLayout.getChildren().addAll(usernameField, passwordField, loginButton);
		
		//STAGE STUFF\\
		primaryStage.setScene(loginScreen);
		primaryStage.setResizable(false);
		primaryStage.setTitle(applicationSettings.getApplicationName());
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
