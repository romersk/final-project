package com.bsuir.evdokimov.finalproject.paysheet.entity;

import com.bsuir.evdokimov.finalproject.users.entity.PersonEvdokimovRD;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Table(name = "pay_sheet")
@Entity
public class PaySheetEvdokimovRD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bet")
    private Double bet;

    @Column(name = "hours")
    private Double hours;

    @Column(name = "month")
    private Long month;

    @Column(name = "year")
    private Long year;

    @ManyToOne
    @JoinColumn(name="person_id")
   // @JsonManagedReference(value = "position-paysheet")
    @JsonBackReference(value = "position-paysheet")
    private PersonEvdokimovRD person;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getBet() {
        return bet;
    }

    public void setBet(Double bet) {
        this.bet = bet;
    }

    public Double getHours() {
        return hours;
    }

    public void setHours(Double hours) {
        this.hours = hours;
    }

    public Long getMonth() {
        return month;
    }

    public void setMonth(Long month) {
        this.month = month;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public PersonEvdokimovRD getPerson() {
        return person;
    }

    public void setPerson(PersonEvdokimovRD person) {
        this.person = person;
    }
}
