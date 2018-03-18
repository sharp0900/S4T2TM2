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
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewTaskMenu.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle(title);
            stage.setScene(new Scene(root1,500,350));
            stage.show();
        }
        catch (Exception e){
            System.err.println("ERROR: could not open New Task window");
        }
    }
}
