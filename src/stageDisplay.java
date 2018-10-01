//Made by Trey Carey | 9.30.18

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class stageDisplay {

    static Label sdText = null;

    public static Stage startSD() {

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
         *Below is a little bit hacky, just like the rest of this project. However
         * it's what I had to do to get the Stage Display working correctly
         * Need to add a check to find the second display and see what screen
         * this needs to go on.
         *
         * Need to check instead of hardcoding this later on
         *
         */

        //Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        sdStage.initStyle(StageStyle.UNDECORATED);

        //Set the size of the SD to the screens dimensions
        //TODO: Check this instead of hard-coding it.
        sdStage.setWidth(1920);
        sdStage.setHeight(1080);

        sdStage.show();

        return sdStage;
    }

    public static void updateText(String newText) {
        sdText.setText(newText);
    }

}
