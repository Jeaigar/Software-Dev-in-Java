import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

// JavaFX application for a clock with adjustable hour, minute, and second fields
public class ClockApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create clock instance
        ClockPane clock = new ClockPane();
        
        // TextFields for adjusting hour, minute, and second
        TextField hourField = new TextField();
        TextField minuteField = new TextField();
        TextField secondField = new TextField();

        // Listener to update hour value when text is changed in hourField
        hourField.textProperty().addListener((observable, oldValue, newValue) -> {
            clock.setHour(Integer.parseInt(newValue));
        });

        // Listener to update minute value when text is changed in minuteField
        minuteField.textProperty().addListener((observable, oldValue, newValue) -> {
            clock.setMinute(Integer.parseInt(newValue));
        });

        // Listener to update second value when text is changed in secondField
        secondField.textProperty().addListener((observable, oldValue, newValue) -> {
            clock.setSecond(Integer.parseInt(newValue));
        });

        // Layout setup using BorderPane
        BorderPane pane = new BorderPane();
        pane.setCenter(clock); // Clock displayed in center
        pane.setTop(hourField); // Hour TextField at the top
        pane.setLeft(minuteField); // Minute TextField on the left
        pane.setRight(secondField); // Second TextField on the right

        // Create scene with the pane and set stage properties
        Scene scene = new Scene(pane, 250, 250);
        primaryStage.setTitle("Clock Application");
        primaryStage.setScene(scene);
        primaryStage.show(); // Display the stage
    }

    // Entry point for JavaFX application
    public static void main(String[] args) {
        launch(args);
    }
}
