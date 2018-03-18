package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Controller
{
    public void newTaskButton()
    {
       openNewTaskWindow("Create New Task");
    }
    public void editTaskButton()
    {
        //load this window with current task info
        openNewTaskWindow("Edit Task");
    }
    public void deleteTaskButton()
    {
        openDeleteTaskAlert();
        // delete task from database
        //update list of tasks
        //update task summary
    }
    public void aboutButton()
    {
        //open window with usage
    }
    public void saveButton()
    {
        //save all textfield entries to database
        //update list of tasks
        //update task summary
    }
    public void cancelButton()
    {
        //close the newTaskWindow
    }
    private void openNewTaskWindow(String title)
    {
       new TaskWindow().display(title,"NewTaskMenu.fxml");
    }
    private void openDeleteTaskAlert()
    {
        new TaskWindow().display("Delete Task","DeleteTaskAlert.fxml");
    }
}
