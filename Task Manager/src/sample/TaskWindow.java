package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TaskWindow
{
    public void display(String name, String fxmlFileName)
    {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFileName));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle(name);
            stage.setScene(new Scene(root1,500,300));
            stage.show();
        }
        catch (Exception e){
            System.err.println("ERROR: could not open New Task window");
        }
    }
}
