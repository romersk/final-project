package com.bsuir.evdokimov.finalproject.position.dto.mapper;

import com.bsuir.evdokimov.finalproject.position.entity.PositionEvdokimovRD;
import com.bsuir.evdokimov.finalproject.position.request.PositionRequestEvdokimovRD;
import com.bsuir.evdokimov.finalproject.shared.exception.BadRequestException;
import com.bsuir.evdokimov.finalproject.shared.mapping.CreateDtoMapper;
import com.bsuir.evdokimov.finalproject.shared.mapping.UpdateDtoMapper;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class PositionDtoMapperEvdokimovRD implements UpdateDtoMapper<PositionRequestEvdokimovRD, PositionEvdokimovRD>, CreateDtoMapper<PositionRequestEvdokimovRD, PositionEvdokimovRD> {

    @Autowired
    private ObjectMapper mapper;

    @Override
    public PositionEvdokimovRD mapToEntity(PositionRequestEvdokimovRD request) {
        PositionEvdokimovRD employee;
        try {
            employee = mapper.readValue(request.getJsonRequest(), PositionEvdokimovRD.class);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
            throw new BadRequestException("bad_request_exception");
        }
        return employee;
    }

    @Override
    public PositionEvdokimovRD mapToEntity(PositionEvdokimovRD entity, PositionRequestEvdokimovRD request) {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        PositionEvdokimovRD employee;
        try {
            PositionEvdokimovRD p = mapper.readValue(request.getJsonRequest(), PositionEvdokimovRD.class);
            employee = mapper.updateValue(entity, request);
            if (p.getPosition() != null) {
                employee.setPosition(p.getPosition());
            }
            if (p.getDivision() != null) {
                employee.setDivision(p.getDivision());
            }
            if (p.getSalary() != null) {
                employee.setSalary(p.getSalary());
            }
        } catch (IOException exception) {
            throw new BadRequestException("bad_request_exception");
        }
        return employee;
    }
}
