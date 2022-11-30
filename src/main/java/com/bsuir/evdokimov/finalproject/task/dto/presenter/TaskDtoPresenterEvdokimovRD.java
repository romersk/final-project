package com.bsuir.evdokimov.finalproject.task.dto.presenter;

import com.bsuir.evdokimov.finalproject.shared.mapping.DtoPresenter;
import com.bsuir.evdokimov.finalproject.task.dto.TaskDtoEdokimovRD;
import com.bsuir.evdokimov.finalproject.task.entity.TaskEvdokimovRD;
import com.bsuir.evdokimov.finalproject.typetask.dto.TypeTaskDtoEvdokimovRD;
import com.bsuir.evdokimov.finalproject.typetask.entity.TypeTaskEvdokimovRD;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class TaskDtoPresenterEvdokimovRD implements DtoPresenter<TaskDtoEdokimovRD, TaskEvdokimovRD> {

    private final ModelMapper mapper;

    @Autowired
    public TaskDtoPresenterEvdokimovRD(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public TaskDtoEdokimovRD map(TaskEvdokimovRD entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, TaskDtoEdokimovRD.class);
    }

    @Override
    public List<TaskDtoEdokimovRD> mapList(List<TaskEvdokimovRD> entities) {
        List<TaskDtoEdokimovRD> clinicDtoList = new ArrayList<>();
        for (TaskEvdokimovRD entity : entities) {
            clinicDtoList.add(mapper.map(entity, TaskDtoEdokimovRD.class));
        }
        return clinicDtoList;
    }
}
