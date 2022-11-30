package com.bsuir.evdokimov.finalproject.typetask.dto.presenter;

import com.bsuir.evdokimov.finalproject.position.dto.PositionDtoEvdokimovRD;
import com.bsuir.evdokimov.finalproject.position.entity.PositionEvdokimovRD;
import com.bsuir.evdokimov.finalproject.shared.mapping.DtoPresenter;
import com.bsuir.evdokimov.finalproject.typetask.dto.TypeTaskDtoEvdokimovRD;
import com.bsuir.evdokimov.finalproject.typetask.entity.TypeTaskEvdokimovRD;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class TypeTaskDtoPresenterEvdokimovRD implements DtoPresenter<TypeTaskDtoEvdokimovRD, TypeTaskEvdokimovRD> {

    private final ModelMapper mapper;

    @Autowired
    public TypeTaskDtoPresenterEvdokimovRD(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public TypeTaskDtoEvdokimovRD map(TypeTaskEvdokimovRD entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, TypeTaskDtoEvdokimovRD.class);
    }

    @Override
    public List<TypeTaskDtoEvdokimovRD> mapList(List<TypeTaskEvdokimovRD> entities) {
        List<TypeTaskDtoEvdokimovRD> clinicDtoList = new ArrayList<>();
        for (TypeTaskEvdokimovRD entity : entities) {
            clinicDtoList.add(mapper.map(entity, TypeTaskDtoEvdokimovRD.class));
        }
        return clinicDtoList;
    }
}
