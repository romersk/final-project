package com.bsuir.evdokimov.finalproject.taskday.entity;

import com.bsuir.evdokimov.finalproject.task.entity.TaskEvdokimovRD;
import com.bsuir.evdokimov.finalproject.workday.entity.WorkDayEvdokimovRD;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "task_day")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class TaskDayEvdokimovRD implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "time_spent")
    private Double timeSpent;

    @ManyToOne
    @JoinColumn(name="task_id")
    @JsonBackReference(value = "tasks-taskday")
    private TaskEvdokimovRD task;

    @ManyToOne
    @JoinColumn(name="workday_id")
    @JsonBackReference(value = "taskdays-workday")
    private WorkDayEvdokimovRD workday;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(Double timeSpent) {
        this.timeSpent = timeSpent;
    }

    public TaskEvdokimovRD getTask() {
        return task;
    }

    public void setTask(TaskEvdokimovRD task) {
        this.task = task;
    }

    public WorkDayEvdokimovRD getWorkday() {
        return workday;
    }

    public void setWorkday(WorkDayEvdokimovRD workday) {
        this.workday = workday;
    }

    @Override
    public String toString() {
        return "TaskDayEvdokimovRD{" +
                "id=" + id +
                ", timeSpent=" + timeSpent +
                ", task=" + task.getId() + " " + task.getStatus() +
                ", workday=" + workday.getId() + " " + workday.getStatus() + " " + workday.getDateEnd() +
                '}';
    }
}
