package com.example.demo11;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The HelloApplication class is the main entry point for the BMI Calculator application.
 * It sets up the JavaFX user interface, including the menu and the main layout.
 */
public class HelloApplication extends Application {

    /**
     * The start method sets up the JavaFX Stage (window) and initializes the scene with the FXML layout.
     * @param primaryStage the primary window of the application
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML layout file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = loader.load(); // Load the FXML
        HelloController controller = loader.getController(); // Get the controller for handling events

        // Create the MenuBar for the application
        MenuBar menuBar = new MenuBar();

        // Create the "File" menu and its items (Clear and Exit)
        Menu fileMenu = new Menu("File");
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.setOnAction(e -> javafx.application.Platform.exit()); // Exit the application when clicked
        MenuItem clearItem = new MenuItem("Clear");
        clearItem.setOnAction(e -> {
            controller.clearFields(); // Clear input fields via the controller
        });
        fileMenu.getItems().addAll(clearItem, exitItem); // Add menu items to the File menu

        // Create the "Help" menu and its item (About)
        Menu helpMenu = new Menu("Help");
        MenuItem aboutItem = new MenuItem("About");
        helpMenu.getItems().add(aboutItem); // Add the About item to the Help menu

        // Add the menus (File and Help) to the menu bar
        menuBar.getMenus().addAll(fileMenu, helpMenu);

        // Set up a BorderPane layout to hold the menu bar at the top and the main FXML layout at the center
        BorderPane layout = new BorderPane();
        layout.setTop(menuBar); // Menu bar at the top
        layout.setCenter(root); // FXML layout at the center

        // Create a scene and set it up with the primary stage
        Scene scene = new Scene(layout);
        primaryStage.setTitle("BMI Calculator"); // Set the title of the window
        primaryStage.setScene(scene); // Set the scene in the stage
        primaryStage.show(); // Display the window
    }

    /**
     * The main method launches the JavaFX application.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application
    }
}
