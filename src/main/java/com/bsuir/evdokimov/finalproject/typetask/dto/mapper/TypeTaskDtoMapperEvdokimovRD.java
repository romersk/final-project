package com.bsuir.evdokimov.finalproject.typetask.dto.mapper;

import com.bsuir.evdokimov.finalproject.position.entity.PositionEvdokimovRD;
import com.bsuir.evdokimov.finalproject.shared.exception.BadRequestException;
import com.bsuir.evdokimov.finalproject.shared.mapping.CreateDtoMapper;
import com.bsuir.evdokimov.finalproject.shared.mapping.UpdateDtoMapper;
import com.bsuir.evdokimov.finalproject.typetask.entity.TypeTaskEvdokimovRD;
import com.bsuir.evdokimov.finalproject.typetask.request.TypeTaskRequestEvdokimovRD;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TypeTaskDtoMapperEvdokimovRD implements UpdateDtoMapper<TypeTaskRequestEvdokimovRD, TypeTaskEvdokimovRD>, CreateDtoMapper<TypeTaskRequestEvdokimovRD, TypeTaskEvdokimovRD> {

    @Autowired
    private ObjectMapper mapper;

    @Override
    public TypeTaskEvdokimovRD mapToEntity(TypeTaskRequestEvdokimovRD request) {
        TypeTaskEvdokimovRD employee;
        try {
            employee = mapper.readValue(request.getJsonRequest(), TypeTaskEvdokimovRD.class);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
            throw new BadRequestException("bad_request_exception");
        }
        return employee;
    }

    @Override
    public TypeTaskEvdokimovRD mapToEntity(TypeTaskEvdokimovRD entity, TypeTaskRequestEvdokimovRD request) {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        TypeTaskEvdokimovRD employee;
        try {
            TypeTaskEvdokimovRD p = mapper.readValue(request.getJsonRequest(), TypeTaskEvdokimovRD.class);
            employee = mapper.updateValue(entity, request);
            if (p.getHartType() != null) {
                employee.setHartType(p.getHartType());
            }
            if (p.getMaxTime() != null) {
                employee.setMaxTime(p.getMaxTime());
            }
            if (p.getMinTime() != null) {
                employee.setMinTime(p.getMinTime());
            }
        } catch (IOException exception) {
            throw new BadRequestException("bad_request_exception");
        }
        return employee;
    }
}
