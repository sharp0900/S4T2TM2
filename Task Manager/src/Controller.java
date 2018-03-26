import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.TreeSet;

public class Controller implements Initializable
{
    private TMModel tmModel;
    private TreeSet<String> taskNames;
    private LinkedList<Task> tasks;

    @FXML
    public ListView<String> taskListView;
    @FXML
    public TextArea taskSummaryTextArea;

    public void initialize(URL location, ResourceBundle resources)
    {
        System.out.println("Loading user data...");

        tmModel = new TMModel();
        taskNames = tmModel.taskNames();
        tasks = getAllTasks();

        if(!taskNames.isEmpty())
        {
            for(String s: taskNames)
            {
                taskListView.getItems().add(s);
            }

        }
        taskSummaryTextArea.setText("Select a Task or Create a new Task");
    }
    private LinkedList<Task> getAllTasks()
    {
        LinkedList<Task> allTasks = new LinkedList<>();

        for(String s: taskNames)
        {
            allTasks.add(new Task(s, tmModel.taskDescription(s), tmModel.taskDescription(s), tmModel.taskDeadLine(s), tmModel.taskCategory(s)));
        }
        return allTasks;
    }
    public void showTaskSummary()
    {
        Task t = new Task();
        System.out.println("loading selected task summary...");

        //get selected name from the list of tasks
        String selectedTaskName = taskListView.getSelectionModel().getSelectedItem();

        //load temp task with the selected tasks data
        t.setName(selectedTaskName);
        System.out.println(t.getName());
        t.setDescription(tmModel.taskDescription(selectedTaskName));
        t.setSize(tmModel.taskSize(selectedTaskName));
        t.setElapsedTime(tmModel.taskElapsedTime(selectedTaskName));
        t.setDeadLine(tmModel.taskDeadLine(selectedTaskName));
        t.setCategory(tmModel.taskDeadLine(selectedTaskName));

        taskSummaryTextArea.setText(t.toString());

    }
    public void newTaskButton()
    {
        TaskInput ti = new TaskInput();
        Task newTask = ti.displayTaskDialog("New Task");

        //check if tasks already exists
        if(newTask!=null)
        {

            taskListView.getItems().add(newTask.getName()); //else add the task name to the list

            tmModel.startTask(newTask.getName());
            tmModel.stopTask(newTask.getName());
            tmModel.describeTask(newTask.getName(),newTask.getDescription());
            tmModel.sizeTask(newTask.getName(),newTask.getSize());
            tmModel.deadLineTask(newTask.getName(), newTask.getDeadLine());
            tmModel.categoryTask(newTask.getName(), newTask.getCategory());

            tmModel = new TMModel(); //reload the log file
        }
    }
    private void updateTask(Task t)
    {
        //update task
    }
    public void editTaskButton()
    {
        TaskInput ti = new TaskInput();
        Task oldTask = new Task(), newTask;
        String selectedTask;

        //get old task info
        selectedTask = taskListView.getSelectionModel().getSelectedItem();
        if(selectedTask != null)
        {
            oldTask.setName(selectedTask);
            oldTask.setDescription(tmModel.taskDescription(selectedTask));
            oldTask.setSize(tmModel.taskSize(selectedTask));
            oldTask.setElapsedTime(tmModel.taskElapsedTime(selectedTask));
            oldTask.setCategory(tmModel.taskCategory(selectedTask));
            oldTask.setDeadLine(tmModel.taskDeadLine(selectedTask));
        }
        //fill window with current task info
        showTaskSummary();

        //load the selected task info into TextInputAlert


        //get new task details
        newTask = ti.displayTaskDialog("Edit Task");
        if(newTask!=null)
        {
            if(newTask.getName() != null)
                tmModel.renameTask(oldTask.getName(),newTask.getName());
        }
        //probably need to delete selected task

        //make new task with given info

    }
    public void deleteTaskButton()
    {
        tmModel = new TMModel();
        String selectedTask = taskListView.getSelectionModel().getSelectedItem();
        System.out.println(selectedTask + " deleted...");

        ObservableList<String> taskSelected, allTasks;
        allTasks = taskListView.getItems();
        taskSelected = taskListView.getSelectionModel().getSelectedItems();
        taskSelected.forEach(allTasks::remove);

        // delete task from database
        tmModel.deleteTask(selectedTask); //this isn't deleting for some reason TODO
        //tmModel = new TMModel(); //reload log file
        taskSummaryTextArea.clear();
    }
    public void aboutButton()
    {
        //open window with usage
    }
    public void startTask()
    {
        String selectedTask = taskListView.getSelectionModel().getSelectedItem();
        System.out.println(selectedTask + " started...");

        tmModel.startTask(selectedTask);
    }
    public void stopTask()
    {
        String selectedTask = taskListView.getSelectionModel().getSelectedItem();
        System.out.println(selectedTask + " stopped...");

        tmModel.stopTask(selectedTask);

        //reload task summary view TODO
    }
}