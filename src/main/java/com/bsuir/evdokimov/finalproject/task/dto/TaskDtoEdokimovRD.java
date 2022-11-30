package com.bsuir.evdokimov.finalproject.task.dto;

import com.bsuir.evdokimov.finalproject.typetask.entity.TypeTaskEvdokimovRD;
import com.bsuir.evdokimov.finalproject.users.entity.PersonEvdokimovRD;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@Data
public class TaskDtoEdokimovRD {

    private Long id;
    private String name;
    private String description;
    private Double optTime;
    private String status;
    private TypeTaskEvdokimovRD typetask;
    private PersonEvdokimovRD person;
}
