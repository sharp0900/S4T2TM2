package edu.csus.csc131.tm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TaskManagerMain extends Application {

    Stage window;
    public void start(Stage primaryStage) throws Exception
    {
        window = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("/MainMenu.fxml"));
        window.setTitle("Task Manager");
        window.setScene(new Scene(root, 800, 500));
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}