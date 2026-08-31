import java.io.IOException;
import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * Displays one chat message together with the speaker's image.
 */
public class DialogBox extends HBox {
    @FXML
    private Label dialog;

    @FXML
    private ImageView displayPicture;

    /**
     * Loads the dialog-box view and fills it with the supplied content.
     *
     * @param message Message to display.
     * @param image Image representing the speaker.
     */
    private DialogBox(String message, Image image) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(
                    MainWindow.class.getResource(
                            "/view/DialogBox.fxml"
                    )
            );

            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        dialog.setText(message);
        displayPicture.setImage(image);
    }

    /**
     * Reverses the dialog-box contents and aligns them to the left.
     */
    private void flip() {
        ObservableList<Node> children =
                FXCollections.observableArrayList(
                        getChildren()
                );

        Collections.reverse(children);
        getChildren().setAll(children);
        setAlignment(Pos.TOP_LEFT);
    }

    /**
     * Creates a right-aligned dialog box for a user message.
     *
     * @param message User's message.
     * @param image Image representing the user.
     * @return User dialog box.
     */
    public static DialogBox getUserDialog(
            String message,
            Image image
    ) {
        return new DialogBox(message, image);
    }

    /**
     * Creates a left-aligned dialog box for a Duke response.
     *
     * @param message Duke's response.
     * @param image Image representing Duke.
     * @return Duke dialog box.
     */
    public static DialogBox getDukeDialog(
            String message,
            Image image
    ) {
        DialogBox dialogBox = new DialogBox(
                message,
                image
        );

        dialogBox.flip();
        return dialogBox;
    }
}
