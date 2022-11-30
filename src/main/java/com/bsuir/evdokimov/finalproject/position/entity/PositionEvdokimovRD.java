package com.bsuir.evdokimov.finalproject.position.entity;

import com.bsuir.evdokimov.finalproject.paysheet.entity.PaySheetEvdokimovRD;
import com.bsuir.evdokimov.finalproject.users.entity.PersonEvdokimovRD;
import com.bsuir.evdokimov.finalproject.users.entity.UserEvdokimovRD;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "position")
@Entity
public class PositionEvdokimovRD implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "division")
    private String division;

    @Column(name = "position")
    private String position;

    @Column(name = "salary")
    private Double salary;

    @OneToMany(mappedBy="position")
    @JsonManagedReference(value = "position")
    private List<UserEvdokimovRD> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public List<UserEvdokimovRD> getUsers() {
        return users;
    }

    public void setUsers(List<UserEvdokimovRD> users) {
        this.users = users;
    }
}
