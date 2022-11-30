package com.bsuir.evdokimov.finalproject.users.dto;

import com.bsuir.evdokimov.finalproject.position.entity.PositionEvdokimovRD;
import com.bsuir.evdokimov.finalproject.shared.dto.Dto;
import com.bsuir.evdokimov.finalproject.users.entity.AuthorityEvdokimovRD;
import com.bsuir.evdokimov.finalproject.users.entity.PersonEvdokimovRD;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@NoArgsConstructor
@Data
public class UsersDtoEvdokimovRD implements Dto {

    private Long id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String userName;
    private AuthorityEvdokimovRD authorities;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PersonEvdokimovRD person;
    private PositionEvdokimovRD position;
}
