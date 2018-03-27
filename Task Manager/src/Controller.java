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
    //private LinkedList<Task> tasks;

    @FXML
    public ListView<String> taskListView;
    @FXML
    public TextArea taskSummaryTextArea;

    public void initialize(URL location, ResourceBundle resources)
    {
        System.out.println("Loading user data...");

        tmModel = new TMModel();
        taskNames = tmModel.taskNames();
        //tasks = getAllTasks();

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
    private Task getTask(String taskName)
    {
        Task t = new Task();
        t.setName(taskName);
        t.setDescription(tmModel.taskDescription(taskName));
        t.setSize(tmModel.taskSize(taskName));
        t.setElapsedTime(tmModel.taskElapsedTime(taskName));
        t.setDeadLine(tmModel.taskDeadLine(taskName));
        t.setCategory(tmModel.taskDeadLine(taskName));
        return t;
    }
    public void showTaskSummary()
    {
        Task t;
        System.out.print("loading selected task summary: ");

        //get selected name from the list of tasks

        String selectedTaskName = taskListView.getSelectionModel().getSelectedItem();
        if(selectedTaskName!=null)
        {
            System.out.println(selectedTaskName);

            //load temp task with the selected tasks data
            t = getTask(selectedTaskName);

            taskSummaryTextArea.setText(t.toString());
        }
        else taskSummaryTextArea.setText("Select a Task or Create a new Task");
    }
    private void makeNewTask(Task newTask)
    {
        if(newTask!=null)
        {
            System.out.println(newTask.getName() + " created...");
            taskListView.getItems().add(newTask.getName()); //else add the task name to the list

            tmModel.startTask(newTask.getName());
            tmModel.stopTask(newTask.getName());
            tmModel.describeTask(newTask.getName(),newTask.getDescription());
            tmModel.sizeTask(newTask.getName(),newTask.getSize());
            tmModel.deadLineTask(newTask.getName(), newTask.getDeadLine());
            tmModel.categoryTask(newTask.getName(), newTask.getCategory());
        }
    }
    public void newTaskButton()
    {
        TaskInput ti = new TaskInput();
        Task newTask = ti.displayTaskDialog("New Task");

        makeNewTask(newTask);
        reloadTextArea();
    }
    public void editTaskButton()
    {
        TaskInput editWindow;
        Task oldTask = new Task(), newTask;
        String selectedTask;

        //get old task info
        selectedTask = taskListView.getSelectionModel().getSelectedItem();
        if(selectedTask != null)
            oldTask = getTask(selectedTask);

        //load the selected task info into TextInputAlert
        editWindow = new TaskInput(oldTask);

        //get new task details
        newTask = editWindow.displayTaskDialog("Edit Task");
        if(newTask!=null)
        {
            if(newTask.getName() != null)
                tmModel.renameTask(oldTask.getName(),newTask.getName());

            deleteTaskButton();
            makeNewTask(newTask);
        }
        reloadTextArea();
    }
    public void deleteTaskButton()
    {
        int selectedId;
        String selectedTask = taskListView.getSelectionModel().getSelectedItem();
        System.out.println(selectedTask + " deleted...");

        ObservableList<String> allTasks;
        allTasks = taskListView.getItems();

        selectedId = taskListView.getSelectionModel().getSelectedIndex();
        allTasks.remove(selectedId);

        tmModel.deleteTask(selectedTask);
        taskSummaryTextArea.clear();
        reloadTextArea();
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

        reloadTextArea();
    }
    private void reloadTextArea()
    {
        tmModel = new TMModel();
        showTaskSummary();
    }
}