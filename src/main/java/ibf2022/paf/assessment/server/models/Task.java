package ibf2022.paf.assessment.server.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

// TODO: Task 4

public class Task {
    private int taskId;
    private String description;
    private int priority;
    private LocalDate date;
    private String username;

    public int getTaskId() {
        return taskId;
    }
    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    

}
