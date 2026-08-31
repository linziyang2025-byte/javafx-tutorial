import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Displays the first JavaFX application window.
 */
public class Main extends Application {
    /**
     * Sets up and displays the primary JavaFX stage.
     *
     * @param stage Primary stage supplied by JavaFX.
     */
    @Override
    public void start(Stage stage) {
        Label helloWorld = new Label("Hello World!");
        Scene scene = new Scene(helloWorld);

        stage.setTitle("JavaFX Tutorial");
        stage.setScene(scene);
        stage.show();
    }
}
