package sample;

public class Task
{
    private String name;
    private String description;
    private String size;
    private String deadLine;
    private String elapsedTime;
    private String category;

    public Task() { }

    public Task(String name) {
        this.name = name;
    }

    public Task(String name, String description, String size, String deadLine, String elapsedTime, String category) {
        this.name = name;
        this.description = description;
        this.size = size;
        this.deadLine = deadLine;
        this.elapsedTime = elapsedTime;
        this.category = category;
    }

    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", size='" + size + '\'' +
                ", deadLine='" + deadLine + '\'' +
                ", elapsedTime='" + elapsedTime + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
