package edu.csus.csc131.tm;

public class Task
{
    private String name;
    private String description;
    private String size;
    private String deadLine;
    private String elapsedTime;
    private String category;

    public Task() { }

    public Task(String name, String description, String size, String deadLine, String category) {
        this.name = name;
        this.description = description;
        this.size = size;
        this.deadLine = deadLine;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }

    public String getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(String elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String toString() {
        return "edu.csus.csc131.tm.Task Name: " + name + "\n" +
                "Description: " + description + "\n" +
                "Size: " + size + "\n" +
                "DeadLine: " + deadLine +"\n" +
                "ElapsedTime: " + elapsedTime + "\n" +
                "Category: " + category + "\n";
    }
}