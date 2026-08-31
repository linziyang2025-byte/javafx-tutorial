import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private final Label text;
    private final ImageView displayPicture;

    /**
     * Creates a dialog box containing the given message and image.
     *
     * @param message Message to display.
     * @param image Image representing the speaker.
     */
    private DialogBox(String message, Image image) {
        text = new Label(message);
        displayPicture = new ImageView(image);

        text.setWrapText(true);
        displayPicture.setFitWidth(100.0);
        displayPicture.setFitHeight(100.0);
        displayPicture.setPreserveRatio(true);

        setAlignment(Pos.TOP_RIGHT);
        getChildren().addAll(text, displayPicture);
    }

    /**
     * Reverses the dialog-box contents and aligns them to the left.
     */
    private void flip() {
        ObservableList<Node> children =
                FXCollections.observableArrayList(
                        getChildren()
                );

        FXCollections.reverse(children);
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
