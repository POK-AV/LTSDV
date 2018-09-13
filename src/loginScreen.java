//Made by Trey Carey | 9.11.18

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
	static PasswordField passwordField;
	static TextField passwordFieldUnmasked;
	static CheckBox showPassword;

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
		passwordField = new PasswordField();
		passwordField.setText("PASSWORD");
		passwordField.setMinWidth(textFieldSize);
		passwordField.relocate(300, 135);
		passwordField.setId("textFields");
		
		//PASSWORD FIELD\\
		passwordFieldUnmasked = new TextField();
		passwordFieldUnmasked.setText("PASSWORD");
		passwordFieldUnmasked.setMinWidth(textFieldSize);
		passwordFieldUnmasked.relocate(300, 135);
		passwordFieldUnmasked.setId("textFields");
		passwordFieldUnmasked.setVisible(false);
		
		//ERROR LABEL\\
		Label errorLabel = new Label("Incorrect Username or Password");
		errorLabel.relocate(298, 70);
		errorLabel.setId("errorLabel");
		errorLabel.setVisible(false);
		
		
		
		//LOGIN BUTTON\\
		Button loginButton = new Button("LOGIN");
		loginButton.relocate(488, 170);
		loginButton.setId("buttons");
		
		EventHandler<ActionEvent> loginClicked = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				String userFound =  null;
				try {
					userFound = applicationSettings.lookupUser(usernameField.getText(), passwordField.getText());
				} catch (IOException e) {
					e.printStackTrace();
				}//END of Try/Catch
				if(userFound.equals("1")) { //1 is Admin Access
					//TODO: Implement Login
					System.out.println("Admin Login");
					errorLabel.setVisible(false);
					
				}else if(userFound.equals("2")){ //2 is Elevated Access
					//TODO: Elevated Access
					System.out.println("Elevated Login");
					errorLabel.setVisible(false);
					
				}else if(userFound.equals("2")){ 
					//TODO: Basic Access
					System.out.println("Basic Login");
					errorLabel.setVisible(false);
				}else{//Show Error
					errorLabel.setVisible(true);
					//TODO: Show Error
				}//End If Statement
			}
			
		};
		
		loginButton.setOnAction(loginClicked);
		
		//CHECKBOX\\
		showPassword = new CheckBox("SHOW PASSWORD");
		showPassword.setId("checkboxes");
		showPassword.relocate(300, 175);
		showPassword.setOnAction(e -> showPassword());
		
		//Add everything to Pane\\
		borderPane.setCenter(centerPaneLayout);
		centerPaneLayout.getChildren().addAll(usernameField, passwordField, passwordFieldUnmasked, loginButton, showPassword, errorLabel);
		
		//STAGE STUFF\\
		primaryStage.setScene(loginScreen);
		primaryStage.setResizable(false);
		primaryStage.setTitle(applicationSettings.getApplicationName());
		primaryStage.show();
	}
	
	public static void showPassword() {
		if(showPassword.isSelected()) {
			passwordFieldUnmasked.setText(passwordField.getText());
			passwordFieldUnmasked.setVisible(true);
			passwordField.setVisible(false);
		}else {
			passwordField.setText(passwordFieldUnmasked.getText());
			passwordField.setVisible(true);
			passwordFieldUnmasked.setVisible(false);
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
