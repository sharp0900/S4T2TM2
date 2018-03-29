package edu.csus.csc131.tm;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.Optional;

public class TaskInput
{
    private Label nameLabel;
    private Label descLabel;
    private Label sizeLabel;
    private Label deadLineLabel;
    private Label categoryLabel;

    private TextField nameText;
    private TextField descText;
    private TextField sizeText;
    private TextField deadLineText;
    private TextField categoryText;

    public TaskInput(Task task)
    {
        nameLabel = new Label("Task Name: ");
        descLabel = new Label("Description: ");
        sizeLabel = new Label("Size: ");
        deadLineLabel = new Label("Deadline: ");
        categoryLabel = new Label("Category: ");

        nameText = new TextField(task.getName());
        descText = new TextField(task.getDescription());
        sizeText = new TextField(task.getSize());
        deadLineText = new TextField(task.getDeadLine());
        categoryText = new TextField(task.getCategory());
    }
    public TaskInput()
    {
        nameLabel = new Label("Task Name: ");
        descLabel = new Label("Description: ");
        sizeLabel = new Label("Size: ");
        deadLineLabel = new Label("Deadline: ");
        categoryLabel = new Label("Category: ");

        nameText = new TextField();
        descText = new TextField();
        sizeText = new TextField();
        deadLineText = new TextField();
        categoryText = new TextField();
    }
    public Task displayTaskDialog(String titleTxt)
    {
        Task tempTask = null;

        Dialog<Task> dialog = new Dialog<>();
        dialog.setTitle(titleTxt);
        dialog.setHeaderText("Enter Task Information");
        dialog.setResizable(true);


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
        dialog.setResultConverter(b -> {
            if(b==buttonTypeOk)
                return new Task(nameText.getText(),descText.getText(),sizeText.getText(),deadLineText.getText(),categoryText.getText());
            else return null;
        });

        Optional<Task> result = dialog.showAndWait();
        if (result.isPresent())
            tempTask = result.get();

        return tempTask;
    }

}