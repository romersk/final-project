package com.bsuir.evdokimov.finalproject.users.entity;

import com.bsuir.evdokimov.finalproject.paysheet.entity.PaySheetEvdokimovRD;
import com.bsuir.evdokimov.finalproject.position.entity.PositionEvdokimovRD;
import com.bsuir.evdokimov.finalproject.task.entity.TaskEvdokimovRD;
import com.bsuir.evdokimov.finalproject.workday.entity.WorkDayEvdokimovRD;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_personal")
public class PersonEvdokimovRD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToOne(mappedBy = "person")
    @JsonBackReference(value = "person")
    private UserEvdokimovRD user;

    @OneToMany(mappedBy="person")
    @JsonManagedReference(value = "position-paysheet")
    @JsonIgnore
    private List<PaySheetEvdokimovRD> paySheet;

    @OneToMany(mappedBy="person")
    @JsonManagedReference(value = "person-task")
    @JsonIgnore
    private List<TaskEvdokimovRD> tasks;

    @OneToMany(mappedBy="person")
    @JsonManagedReference(value = "person-workday")
    @JsonIgnore
    private List<WorkDayEvdokimovRD> workDays;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserEvdokimovRD getUser() {
        return user;
    }

    public void setUser(UserEvdokimovRD user) {
        this.user = user;
    }

    public List<PaySheetEvdokimovRD> getPaySheet() {
        return paySheet;
    }

    public void setPaySheet(List<PaySheetEvdokimovRD> paySheet) {
        this.paySheet = paySheet;
    }

    public List<TaskEvdokimovRD> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskEvdokimovRD> tasks) {
        this.tasks = tasks;
    }

    public List<WorkDayEvdokimovRD> getWorkDays() {
        return workDays;
    }

    public void setWorkDays(List<WorkDayEvdokimovRD> workDays) {
        this.workDays = workDays;
    }
}
