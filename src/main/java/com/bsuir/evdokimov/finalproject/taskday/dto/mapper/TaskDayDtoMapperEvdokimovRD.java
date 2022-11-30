package com.bsuir.evdokimov.finalproject.taskday.dto.mapper;

import com.bsuir.evdokimov.finalproject.shared.exception.BadRequestException;
import com.bsuir.evdokimov.finalproject.shared.mapping.CreateDtoMapper;
import com.bsuir.evdokimov.finalproject.shared.mapping.UpdateDtoMapper;
import com.bsuir.evdokimov.finalproject.taskday.entity.TaskDayEvdokimovRD;
import com.bsuir.evdokimov.finalproject.taskday.request.TaskDayRequestEvdokimovRD;
import com.bsuir.evdokimov.finalproject.typetask.entity.TypeTaskEvdokimovRD;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.Date;
import java.time.Duration;

@Component
public class TaskDayDtoMapperEvdokimovRD implements UpdateDtoMapper<TaskDayRequestEvdokimovRD, TaskDayEvdokimovRD>, CreateDtoMapper<TaskDayRequestEvdokimovRD, TaskDayEvdokimovRD> {

    @Autowired
    private ObjectMapper mapper;

    @Override
    public TaskDayEvdokimovRD mapToEntity(TaskDayRequestEvdokimovRD request) {
        TaskDayEvdokimovRD employee;
        try {
            employee = mapper.readValue(request.getJsonRequest(), TaskDayEvdokimovRD.class);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
            throw new BadRequestException("bad_request_exception");
        }
        return employee;
    }

    @Override
    public TaskDayEvdokimovRD mapToEntity(TaskDayEvdokimovRD entity, TaskDayRequestEvdokimovRD request) {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        TaskDayEvdokimovRD employee;
        try {
            TaskDayEvdokimovRD p = mapper.readValue(request.getJsonRequest(), TaskDayEvdokimovRD.class);
            employee = mapper.updateValue(entity, request);
            if (p.getTimeSpent() != null) {
                employee.setTimeSpent(p.getTimeSpent());
                employee.getWorkday().setDateEnd(Date.from(employee.getWorkday().getDateStart().toInstant().plus(Duration.ofSeconds((long) (p.getTimeSpent()*3600)))));
                employee.getWorkday().setStatus("завершен");
                employee.getTask().setStatus("выполнен");
                System.out.println(employee.toString());
            }
        } catch (IOException exception) {
            throw new BadRequestException("bad_request_exception");
        }
        return employee;
    }
}
