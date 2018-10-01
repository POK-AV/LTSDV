//Made by Trey Carey | 9.16.18

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/*
 * A bug seems to occur when there is no external monitor plugged in, causing all sorts
 * of UI issues, to where the UI gets maximized without command and some Stages will
 * not close. Need to fix.
 */

public abstract class adminInterface extends Application {

public static void makeAdminInterface(){
		
		Stage adminStage = new Stage();
		
		
		BorderPane borderPane = new BorderPane();
		borderPane.setId("background");
		
		Scene adminInterface = new Scene(borderPane, 800, 600);
		
		adminInterface.getStylesheets().add("/files/styles.css");
		
		Label title = new Label(applicationSettings.getApplicationName() + " - ADMIN");
		title.setId("titles");
		BorderPane.setAlignment(title, Pos.CENTER);
		borderPane.setTop(title);
		
		//POK LOGO\\
		ImageView pokLogo = new ImageView("/images/POK Logo.png");
		HBox bottomHBox = new HBox();
		//Code below is a little hacky but it gets the job done.
		bottomHBox.setPadding(new Insets(0, 0, 22, adminInterface.getWidth() / 2 - pokLogo.boundsInParentProperty().get().getWidth() / 2));
		bottomHBox.getChildren().addAll(pokLogo);
		BorderPane.setAlignment(bottomHBox, Pos.CENTER);
		borderPane.setBottom(bottomHBox);
		
		//CENTER PANE LAYOUT\\
		//I am using a pane for the absolute positioning
		Pane centerPaneLayout = new Pane();
		borderPane.setCenter(centerPaneLayout);
		
		//OVERRIDE SD TEXT\\
		Label overrideText = new Label("Override SD Text");
		overrideText.relocate(30, 20); // W, H
		overrideText.setId("adminLabels");
		
		TextField overrideTextField = new TextField();
		overrideTextField.setMinWidth(520);
		overrideTextField.relocate(170, 15); // W, H
		overrideTextField.setId("textFields");
		
		Button overrideTextFieldSubmit = new Button("SUBMIT");
		overrideTextFieldSubmit.relocate(700, 15); // W, H
		overrideTextFieldSubmit.setId("adminButtons");
		overrideTextFieldSubmit.setOnAction(e ->{
			stageDisplay.updateText(overrideTextField.getText());
		});
		
		//IP ADDRESS\\
		Label ipAddressLabel = new Label("Ip Address");
		ipAddressLabel.relocate(30, 70);
		ipAddressLabel.setId("adminLabels");
		
		TextField ipAddressTextField = new TextField();
		ipAddressTextField.setMaxWidth(120);
		ipAddressTextField.relocate(130, 65);
		ipAddressTextField.setId("textFields");
		
		Button ipAddressButton = new Button("SUBMIT");
		ipAddressButton.relocate(260, 65);
		ipAddressButton.setId("adminButtons");
		
		//PORT\\
		Label portLabel = new Label("Port");
		portLabel.relocate(370, 70);
		portLabel.setId("adminLabels");
				
		TextField portTextField = new TextField();
		portTextField.setMaxWidth(120);
		portTextField.relocate(410, 65);
		portTextField.setId("textFields");
		
		Button portButton = new Button("SUBMIT");
		portButton.relocate(540, 65);
		portButton.setId("adminButtons"); //Fix This
				
		centerPaneLayout.getChildren().addAll(overrideText, overrideTextField, overrideTextFieldSubmit, ipAddressLabel, ipAddressTextField, ipAddressButton, portLabel, portTextField, portButton);
		
		adminStage.setTitle(applicationSettings.getApplicationName() + " - ADMIN");
		adminStage.setResizable(false);
		adminStage.setMaxHeight(600);
		adminStage.setMaxWidth(800);
		adminStage.setScene(adminInterface);
		adminStage.show();
		
		adminStage.setOnCloseRequest(e -> {
			applicationSettings.setWindowOpen(false);
		});
	}
	
}
