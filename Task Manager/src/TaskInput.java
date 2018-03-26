import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

import java.util.Optional;

public class TaskInput
{
    public Task displayTaskDialog(String titleTxt)
    {
        Task tempTask = null;

        Dialog<Task> dialog = new Dialog<>();
        dialog.setTitle(titleTxt);
        dialog.setHeaderText("Enter Task Information");
        dialog.setResizable(true);

        Label nameLabel = new Label("Task Name: ");
        Label descLabel = new Label("Description: ");
        Label sizeLabel = new Label("Size: ");
        Label deadLineLabel = new Label("Deadline: ");
        Label categoryLabel = new Label("Category: ");

        TextField nameText = new TextField();
        TextField descText = new TextField();
        TextField sizeText = new TextField();
        TextField deadLineText = new TextField();
        TextField categoryText = new TextField();

        GridPane grid = new GridPane();
        grid.add(nameLabel, 1, 1);
        grid.add(nameText, 2, 1);

        grid.add(descLabel, 1, 2);
        grid.add(descText, 2, 2);

        grid.add(sizeLabel, 1, 3);
        grid.add(sizeText, 2, 3);

        grid.add(deadLineLabel, 1, 4);
        grid.add(deadLineText, 2, 4);

        grid.add(categoryLabel, 1, 5);
        grid.add(categoryText, 2, 5);

        dialog.getDialogPane().setContent(grid);

        ButtonType buttonTypeOk = new ButtonType("Save", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        dialog.getDialogPane().getButtonTypes().add(buttonTypeCancel);


        //get the task information from the task window
        dialog.setResultConverter(new Callback<ButtonType, Task>()
        {
            public Task call(ButtonType b)
            {
                if(b==buttonTypeOk)
                    return new Task(nameText.getText(),descText.getText(),sizeText.getText(),deadLineText.getText(),categoryText.getText());
                else return null;
            }
        });

        Optional<Task> result = dialog.showAndWait();
        if (result.isPresent())
            tempTask = result.get();

        return tempTask;
    }

}
