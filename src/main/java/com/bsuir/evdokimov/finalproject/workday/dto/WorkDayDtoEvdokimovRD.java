package com.bsuir.evdokimov.finalproject.workday.dto;

import com.bsuir.evdokimov.finalproject.users.entity.PersonEvdokimovRD;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@Data
public class WorkDayDtoEvdokimovRD {

    private Long id;
    private String status;
    private PersonEvdokimovRD person;
}
