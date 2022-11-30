package com.bsuir.evdokimov.finalproject.position.dto;

import com.bsuir.evdokimov.finalproject.shared.dto.Dto;
import com.bsuir.evdokimov.finalproject.users.entity.PersonEvdokimovRD;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@Data
public class PositionDtoEvdokimovRD implements Dto {

    private Long id;
    private String division;
    private String position;
    private Double salary;
}
