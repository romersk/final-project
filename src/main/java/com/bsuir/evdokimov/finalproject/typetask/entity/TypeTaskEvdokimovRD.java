package com.bsuir.evdokimov.finalproject.typetask.entity;

import com.bsuir.evdokimov.finalproject.task.entity.TaskEvdokimovRD;
import com.bsuir.evdokimov.finalproject.users.entity.UserEvdokimovRD;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Table(name = "type_task")
@Entity
public class TypeTaskEvdokimovRD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hard_type")
    private String hartType;

    @Column(name = "max_time")
    private Double maxTime;

    @Column(name = "min_time")
    private Double minTime;

    @OneToMany(mappedBy="typetask")
    @JsonManagedReference(value = "tasks")
    private List<TaskEvdokimovRD> tasks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHartType() {
        return hartType;
    }

    public void setHartType(String hartType) {
        this.hartType = hartType;
    }

    public Double getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(Double maxTime) {
        this.maxTime = maxTime;
    }

    public Double getMinTime() {
        return minTime;
    }

    public void setMinTime(Double minTime) {
        this.minTime = minTime;
    }

    public List<TaskEvdokimovRD> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskEvdokimovRD> tasks) {
        this.tasks = tasks;
    }
}
