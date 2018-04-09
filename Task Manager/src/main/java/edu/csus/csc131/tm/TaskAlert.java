package edu.csus.csc131.tm;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class TaskAlert
{
    public boolean display(String title, String type, String message)
    {
        boolean choice = false;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(type);
        alert.setContentText(message);

        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == ButtonType.OK)
            choice = true;
        else
            choice = false;

        return choice;
    }
}
