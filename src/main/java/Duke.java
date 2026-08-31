/**
 * Generates responses to messages received from the JavaFX interface.
 */
public class Duke {
    /**
     * Runs the original console entry point.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        System.out.println("Hello!");
    }

    /**
     * Generates a response to a chat message.
     *
     * @param input User's chat message.
     * @return Duke's response.
     */
    public String getResponse(String input) {
        return "Duke heard: " + input;
    }
}
