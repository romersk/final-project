package com.bsuir.evdokimov.finalproject.paysheet.dto;

import com.bsuir.evdokimov.finalproject.users.entity.PersonEvdokimovRD;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@Data
public class PaySheetDtoEvdokimovRD {

    private Long id;
    private Double bet;
    private Double hours;
    private Long month;
    private Long year;
    @JsonIgnore
    private PersonEvdokimovRD person;
}
