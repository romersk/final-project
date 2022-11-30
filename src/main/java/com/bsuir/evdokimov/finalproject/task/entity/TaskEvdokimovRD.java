package com.bsuir.evdokimov.finalproject.task.entity;

import com.bsuir.evdokimov.finalproject.position.entity.PositionEvdokimovRD;
import com.bsuir.evdokimov.finalproject.taskday.entity.TaskDayEvdokimovRD;
import com.bsuir.evdokimov.finalproject.typetask.entity.TypeTaskEvdokimovRD;
import com.bsuir.evdokimov.finalproject.users.entity.PersonEvdokimovRD;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "task")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class TaskEvdokimovRD implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "opt_time")
    private Double optTime;

    @Column(name = "status")
    private String status = "не в исполнении";

    @ManyToOne
    @JoinColumn(name="type_task_id")
    @JsonBackReference(value = "tasks")
    private TypeTaskEvdokimovRD typetask;

    @ManyToOne
    @JoinColumn(name="person_id")
    @JsonBackReference(value = "tasks-person")
    private PersonEvdokimovRD person;

    @OneToMany(mappedBy="task")
    @JsonManagedReference(value = "tasks-taskday")
    private List<TaskDayEvdokimovRD> taskDays;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getOptTime() {
        return optTime;
    }

    public void setOptTime(Double optTime) {
        this.optTime = optTime;
    }

    public TypeTaskEvdokimovRD getTypetask() {
        return typetask;
    }

    public void setTypetask(TypeTaskEvdokimovRD typetask) {
        this.typetask = typetask;
    }

    public PersonEvdokimovRD getPerson() {
        return person;
    }

    public void setPerson(PersonEvdokimovRD person) {
        this.person = person;
    }

    public List<TaskDayEvdokimovRD> getTaskDays() {
        return taskDays;
    }

    public void setTaskDays(List<TaskDayEvdokimovRD> taskDays) {
        this.taskDays = taskDays;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
