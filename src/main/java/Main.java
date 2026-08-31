import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Loads and displays the FXML-based JavaFX chat window.
 */
public class Main extends Application {
    private final Duke duke = new Duke();

    /**
     * Loads the main FXML view and displays the primary stage.
     *
     * @param stage Primary stage supplied by JavaFX.
     */
    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(
                    Main.class.getResource(
                            "/view/MainWindow.fxml"
                    )
            );

            AnchorPane mainWindow = fxmlLoader.load();
            Scene scene = new Scene(mainWindow);

            stage.setTitle("Duke");
            stage.setMinHeight(220.0);
            stage.setMinWidth(417.0);
            stage.setScene(scene);

            fxmlLoader.<MainWindow>getController()
                    .setDuke(duke);

            stage.show();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
