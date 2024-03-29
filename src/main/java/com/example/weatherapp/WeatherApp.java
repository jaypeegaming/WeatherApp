// JavaFX and related classes are imported.
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WeatherApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // A new TextField is created with a prompt text.
        TextField locationInput = new TextField();
        locationInput.setPromptText("Enter Location");

        // A new Label is created to display the weather information.
        Label weatherInfo = new Label("Weather information will be shown here.");

        // A new VBox layout is created. This layout arranges its children in a single vertical column.
        VBox layout = new VBox(10, locationInput, weatherInfo);

        // A new Scene is created, which is the container for all content in a scene graph.
        Scene scene = new Scene(layout, 300, 250);

        // Setting the title of primary stage (the application window).
        primaryStage.setTitle("Weather Information App");

        // Setting the scene for the primary stage.
        primaryStage.setScene(scene);

        // Showing the primary stage i.e. display the application window.
        primaryStage.show();
    }

    public static void main(String[] args) {
        // Launching the JavaFX Application. 
        // This method is static and hence should be called from a static context only.
        launch(args);
    }
}