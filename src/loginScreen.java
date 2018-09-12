//Made by Trey Carey | 9.11.18

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class loginScreen extends Application{

	Scene loginScreen;
	public void start(Stage primaryStage) throws Exception {
		
		BorderPane borderPane = new BorderPane();
		
		loginScreen = new Scene(borderPane, 800, 600);
		
		primaryStage.setScene(loginScreen);
		primaryStage.setResizable(false);
		primaryStage.setTitle(applicationSettings.getApplicationName());
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
