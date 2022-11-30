package com.bsuir.evdokimov.finalproject.paysheet.dto.presenter;

import com.bsuir.evdokimov.finalproject.paysheet.dto.PaySheetDtoEvdokimovRD;
import com.bsuir.evdokimov.finalproject.paysheet.entity.PaySheetEvdokimovRD;
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
public class PaySheetDtoPresenterEvdokimovRD implements DtoPresenter<PaySheetDtoEvdokimovRD, PaySheetEvdokimovRD> {

    private final ModelMapper mapper;

    @Autowired
    public PaySheetDtoPresenterEvdokimovRD(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public PaySheetDtoEvdokimovRD map(PaySheetEvdokimovRD entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, PaySheetDtoEvdokimovRD.class);
    }

    @Override
    public List<PaySheetDtoEvdokimovRD> mapList(List<PaySheetEvdokimovRD> entities) {
        List<PaySheetDtoEvdokimovRD> clinicDtoList = new ArrayList<>();
        for (PaySheetEvdokimovRD entity : entities) {
            clinicDtoList.add(mapper.map(entity, PaySheetDtoEvdokimovRD.class));
        }
        return clinicDtoList;
    }
}
