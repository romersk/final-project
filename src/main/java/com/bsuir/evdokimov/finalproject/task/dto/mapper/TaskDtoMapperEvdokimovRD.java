package com.bsuir.evdokimov.finalproject.task.dto.mapper;

import com.bsuir.evdokimov.finalproject.shared.exception.BadRequestException;
import com.bsuir.evdokimov.finalproject.shared.mapping.CreateDtoMapper;
import com.bsuir.evdokimov.finalproject.shared.mapping.UpdateDtoMapper;
import com.bsuir.evdokimov.finalproject.task.entity.TaskEvdokimovRD;
import com.bsuir.evdokimov.finalproject.task.request.TaskRequestEvdokimovRD;
import com.bsuir.evdokimov.finalproject.typetask.entity.TypeTaskEvdokimovRD;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TaskDtoMapperEvdokimovRD implements UpdateDtoMapper<TaskRequestEvdokimovRD, TaskEvdokimovRD>, CreateDtoMapper<TaskRequestEvdokimovRD, TaskEvdokimovRD> {

    @Autowired
    private ObjectMapper mapper;

    @Override
    public TaskEvdokimovRD mapToEntity(TaskRequestEvdokimovRD request) {
        TaskEvdokimovRD employee;
        try {
            employee = mapper.readValue(request.getJsonRequest(), TaskEvdokimovRD.class);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
            throw new BadRequestException("bad_request_exception");
        }
        return employee;
    }

    @Override
    public TaskEvdokimovRD mapToEntity(TaskEvdokimovRD entity, TaskRequestEvdokimovRD request) {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        TaskEvdokimovRD employee;
        try {
            TaskEvdokimovRD p = mapper.readValue(request.getJsonRequest(), TaskEvdokimovRD.class);
            employee = mapper.updateValue(entity, request);
            if (p.getDescription() != null) {
                employee.setDescription(p.getDescription());
            }
            if (p.getPerson() != null) {
                employee.setPerson(p.getPerson());
            }
            if (p.getName() != null) {
                employee.setName(p.getName());
            }
            if (p.getOptTime() != null) {
                employee.setOptTime(p.getOptTime());
            }
            if (p.getStatus() != null) {
                employee.setStatus(p.getStatus());
            }
        } catch (IOException exception) {
            throw new BadRequestException("bad_request_exception");
        }
        return employee;
    }
}
