import java.util.TreeSet;

public interface ITMMODEL
{
    // set information in our model
    //
    boolean startTask(String name);
    boolean stopTask(String name);
    boolean describeTask(String name, String description);
    boolean sizeTask(String name, String size);
    boolean deleteTask(String name);
    boolean renameTask(String oldName, String newName);
    boolean categoryTask(String name, String category);
    boolean deadLineTask(String name, String deadLine);

    // return information about our tasks
    //
    String taskElapsedTime(String name);
    String taskSize(String name);
    String taskDescription(String name);
    String taskCategory(String name);
    String taskDeadLine(String name);

    // return information about some tasks
    //
    String minTimeForSize(String size);
    String maxTimeForSize(String size);
    String avgTimeForSize(String size);

    TreeSet<String> taskNamesForSize(String size);

    // return information about all tasks
    //
    String elapsedTimeForAllTasks();
    TreeSet<String> taskNames();
    TreeSet<String> taskSizes();
}