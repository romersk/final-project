package com.bsuir.evdokimov.finalproject.workday.entity;

import com.bsuir.evdokimov.finalproject.taskday.entity.TaskDayEvdokimovRD;
import com.bsuir.evdokimov.finalproject.users.entity.PersonEvdokimovRD;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Table(name = "work_day")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class WorkDayEvdokimovRD implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(name = "date_start")
    private Date dateStart;

    @Column(name = "date_end")
    private Date dateEnd;

    @Column(name = "status")
    private String status = "в процесса выполнения";

    @ManyToOne
    @JoinColumn(name="person_id")
    @JsonBackReference(value = "workday-person")
    private PersonEvdokimovRD person;

    @OneToMany(mappedBy="workday")
    @JsonManagedReference(value = "taskdays-workday")
    private List<TaskDayEvdokimovRD> taskDays;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
}
