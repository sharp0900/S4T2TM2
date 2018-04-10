package edu.csus.csc131.tm;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class TaskAlert
{
    public boolean display(String title, String message)
    {
        boolean choice;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setGraphic(null);
        alert.setTitle(title);
        alert.setContentText(message);

        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == ButtonType.OK)
            choice = true;
        else
            choice = false;

        return choice;
    }
}
