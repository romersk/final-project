package com.bsuir.evdokimov.finalproject.workday.dto.mapper;

import com.bsuir.evdokimov.finalproject.shared.exception.BadRequestException;
import com.bsuir.evdokimov.finalproject.shared.mapping.CreateDtoMapper;
import com.bsuir.evdokimov.finalproject.shared.mapping.UpdateDtoMapper;
import com.bsuir.evdokimov.finalproject.task.entity.TaskEvdokimovRD;
import com.bsuir.evdokimov.finalproject.workday.entity.WorkDayEvdokimovRD;
import com.bsuir.evdokimov.finalproject.workday.request.WorkDayRequestEvdokimovRD;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.Duration;

@Component
public class WorkDayDtoMapperEvdokimovRD implements UpdateDtoMapper<WorkDayRequestEvdokimovRD, WorkDayEvdokimovRD>, CreateDtoMapper<WorkDayRequestEvdokimovRD, WorkDayEvdokimovRD> {

    @Autowired
    private ObjectMapper mapper;

    @Override
    public WorkDayEvdokimovRD mapToEntity(WorkDayRequestEvdokimovRD request) {
        WorkDayEvdokimovRD employee;
        try {
            employee = mapper.readValue(request.getJsonRequest(), WorkDayEvdokimovRD.class);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
            throw new BadRequestException("bad_request_exception");
        }
        return employee;
    }

    @Override
    public WorkDayEvdokimovRD mapToEntity(WorkDayEvdokimovRD entity, WorkDayRequestEvdokimovRD request) {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        WorkDayEvdokimovRD employee;
        try {
            WorkDayEvdokimovRD p = mapper.readValue(request.getJsonRequest(), WorkDayEvdokimovRD.class);
            employee = mapper.updateValue(entity, request);
            if (p.getStatus() != null) {
                employee.setStatus(p.getStatus());
            }
        } catch (IOException exception) {
            throw new BadRequestException("bad_request_exception");
        }
        return employee;
    }
}
