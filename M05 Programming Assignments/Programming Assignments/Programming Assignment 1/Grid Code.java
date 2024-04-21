import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

// JavaFX application to display images in a grid
public class ImageGrid extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane(); // Create GridPane for arranging images

        // Loop to add images to the grid
        for (int i = 1; i <= 4; i++) {
            // Load image from file with name "Image" followed by i, e.g., "Image1.jpg"
            Image image = new Image("file:Image" + i + ".jpg");
            ImageView imageView = new ImageView(image); // Create ImageView to display the image
            grid.add(imageView, (i - 1) % 2, (i - 1) / 2); // Add image to the grid at appropriate position
        }

        Scene scene = new Scene(grid, 500, 500); // Create scene with the grid and set size
        primaryStage.setTitle("Image Grid"); // Set title for the stage
        primaryStage.setScene(scene); // Set the scene to the stage
        primaryStage.show(); // Display the stage
    }

    // Main method to launch the JavaFX application
    public static void main(String[] args) {
        launch(args);
    }
}