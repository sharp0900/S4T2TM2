package sample;

import javafx.beans.property.SimpleStringProperty;

public class Task
{
    private SimpleStringProperty name;
    private SimpleStringProperty description;
    private SimpleStringProperty size;
    private SimpleStringProperty deadLine;
    private SimpleStringProperty elapsedTime;
    private SimpleStringProperty category;

    public Task() { }

    public Task(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public Task(String name, String description, String size, String deadLine, String elapsedTime, String category) {
        this.name = new SimpleStringProperty(name);
        this.description = new SimpleStringProperty(description);
        this.size = new SimpleStringProperty(size);
        this.deadLine = new SimpleStringProperty(deadLine);
        this.elapsedTime = new SimpleStringProperty(deadLine);
        this.elapsedTime = new SimpleStringProperty(elapsedTime);
        this.category = new SimpleStringProperty(category);
    }

    public String getName() { return name.get(); }

    public SimpleStringProperty nameProperty() { return name; }

    public String getDescription() { return description.get(); }

    public SimpleStringProperty descriptionProperty() { return description; }

    public String getSize() { return size.get(); }

    public SimpleStringProperty sizeProperty() { return size; }

    public String getDeadLine() { return deadLine.get(); }

    public SimpleStringProperty deadLineProperty() { return deadLine; }

    public String getElapsedTime() { return elapsedTime.get(); }

    public SimpleStringProperty elapsedTimeProperty() { return elapsedTime; }

    public String getCategory() { return category.get(); }

    public SimpleStringProperty categoryProperty() { return category; }

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
