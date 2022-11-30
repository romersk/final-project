package com.bsuir.evdokimov.finalproject.position.dto.presenter;

import com.bsuir.evdokimov.finalproject.position.dto.PositionDtoEvdokimovRD;
import com.bsuir.evdokimov.finalproject.position.entity.PositionEvdokimovRD;
import com.bsuir.evdokimov.finalproject.shared.mapping.DtoPresenter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class PositionDtoPresenterEvdokimovRD implements DtoPresenter<PositionDtoEvdokimovRD, PositionEvdokimovRD> {

    private final ModelMapper mapper;

    @Autowired
    public PositionDtoPresenterEvdokimovRD(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public PositionDtoEvdokimovRD map(PositionEvdokimovRD entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, PositionDtoEvdokimovRD.class);
    }

    @Override
    public List<PositionDtoEvdokimovRD> mapList(List<PositionEvdokimovRD> entities) {
        List<PositionDtoEvdokimovRD> clinicDtoList = new ArrayList<>();
        for (PositionEvdokimovRD entity : entities) {
            clinicDtoList.add(mapper.map(entity, PositionDtoEvdokimovRD.class));
        }
        return clinicDtoList;
    }
}
