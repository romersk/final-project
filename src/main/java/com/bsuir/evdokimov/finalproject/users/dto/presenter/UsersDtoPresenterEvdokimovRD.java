package com.bsuir.evdokimov.finalproject.users.dto.presenter;

import com.bsuir.evdokimov.finalproject.shared.mapping.DtoPresenter;
import com.bsuir.evdokimov.finalproject.users.dto.UsersDtoEvdokimovRD;
import com.bsuir.evdokimov.finalproject.users.entity.UserEvdokimovRD;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class UsersDtoPresenterEvdokimovRD implements DtoPresenter<UsersDtoEvdokimovRD, UserEvdokimovRD> {

    private final ModelMapper mapper;

    @Autowired
    public UsersDtoPresenterEvdokimovRD(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public UsersDtoEvdokimovRD map(UserEvdokimovRD entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, UsersDtoEvdokimovRD.class);
    }

    @Override
    public List<UsersDtoEvdokimovRD> mapList(List<UserEvdokimovRD> entities) {
        List<UsersDtoEvdokimovRD> clinicDtoList = new ArrayList<>();
        for (UserEvdokimovRD entity : entities) {
            clinicDtoList.add(mapper.map(entity, UsersDtoEvdokimovRD.class));
        }
        return clinicDtoList;
    }
}
