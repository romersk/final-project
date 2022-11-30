package com.bsuir.evdokimov.finalproject.workday.dto.presenter;

import com.bsuir.evdokimov.finalproject.shared.mapping.DtoPresenter;
import com.bsuir.evdokimov.finalproject.task.dto.TaskDtoEdokimovRD;
import com.bsuir.evdokimov.finalproject.task.entity.TaskEvdokimovRD;
import com.bsuir.evdokimov.finalproject.workday.dto.WorkDayDtoEvdokimovRD;
import com.bsuir.evdokimov.finalproject.workday.entity.WorkDayEvdokimovRD;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class WorkDayDtoPresenterEvdokimovRD implements DtoPresenter<WorkDayDtoEvdokimovRD, WorkDayEvdokimovRD> {

    private final ModelMapper mapper;

    @Autowired
    public WorkDayDtoPresenterEvdokimovRD(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public WorkDayDtoEvdokimovRD map(WorkDayEvdokimovRD entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, WorkDayDtoEvdokimovRD.class);
    }

    @Override
    public List<WorkDayDtoEvdokimovRD> mapList(List<WorkDayEvdokimovRD> entities) {
        List<WorkDayDtoEvdokimovRD> clinicDtoList = new ArrayList<>();
        for (WorkDayEvdokimovRD entity : entities) {
            clinicDtoList.add(mapper.map(entity, WorkDayDtoEvdokimovRD.class));
        }
        return clinicDtoList;
    }
}
