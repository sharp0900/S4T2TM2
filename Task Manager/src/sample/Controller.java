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
       openNewTaskWindow();
    }
    public void editTaskButton()
    {
        openNewTaskWindow();
    }
    public void deleteTaskButton()
    {

    }
    private void openNewTaskWindow()
    {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewTaskMenu.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("Create New Task");
            stage.setScene(new Scene(root1));
            stage.show();
        }
        catch (Exception e){
            System.err.println("ERROR: could not open New Task window");
        }
    }
}
