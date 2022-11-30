package com.bsuir.evdokimov.finalproject.typetask.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@Data
public class TypeTaskDtoEvdokimovRD {

    private Long id;
    private String hartType;
    private Double maxTime;
    private Double minTime;
}
