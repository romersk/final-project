package com.bsuir.evdokimov.finalproject.users.dto;

import com.bsuir.evdokimov.finalproject.shared.dto.Dto;
import com.bsuir.evdokimov.finalproject.users.entity.AuthorityEvdokimovRD;
import com.bsuir.evdokimov.finalproject.users.entity.PersonEvdokimovRD;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@NoArgsConstructor
@Data
public class UsersDtoEvdokimovRD implements Dto {

    private Long id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String userName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PersonEvdokimovRD person;
    private List<AuthorityEvdokimovRD> authorities;
}
