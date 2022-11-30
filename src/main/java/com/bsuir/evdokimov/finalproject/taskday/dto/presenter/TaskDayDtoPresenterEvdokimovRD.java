package com.bsuir.evdokimov.finalproject.taskday.dto.presenter;

import com.bsuir.evdokimov.finalproject.shared.mapping.DtoPresenter;
import com.bsuir.evdokimov.finalproject.taskday.dto.TaskDayDtoEvdokimovRD;
import com.bsuir.evdokimov.finalproject.taskday.entity.TaskDayEvdokimovRD;
import com.bsuir.evdokimov.finalproject.typetask.dto.TypeTaskDtoEvdokimovRD;
import com.bsuir.evdokimov.finalproject.typetask.entity.TypeTaskEvdokimovRD;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class TaskDayDtoPresenterEvdokimovRD implements DtoPresenter<TaskDayDtoEvdokimovRD, TaskDayEvdokimovRD> {

    private final ModelMapper mapper;

    @Autowired
    public TaskDayDtoPresenterEvdokimovRD(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public TaskDayDtoEvdokimovRD map(TaskDayEvdokimovRD entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, TaskDayDtoEvdokimovRD.class);
    }

    @Override
    public List<TaskDayDtoEvdokimovRD> mapList(List<TaskDayEvdokimovRD> entities) {
        List<TaskDayDtoEvdokimovRD> clinicDtoList = new ArrayList<>();
        for (TaskDayEvdokimovRD entity : entities) {
            clinicDtoList.add(mapper.map(entity, TaskDayDtoEvdokimovRD.class));
        }
        return clinicDtoList;
    }
}
