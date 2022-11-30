package com.bsuir.evdokimov.finalproject.paysheet.dto.mapper;

import com.bsuir.evdokimov.finalproject.paysheet.entity.PaySheetEvdokimovRD;
import com.bsuir.evdokimov.finalproject.paysheet.request.PaySheetRequestEvdokimovRD;
import com.bsuir.evdokimov.finalproject.position.entity.PositionEvdokimovRD;
import com.bsuir.evdokimov.finalproject.shared.exception.BadRequestException;
import com.bsuir.evdokimov.finalproject.shared.mapping.CreateDtoMapper;
import com.bsuir.evdokimov.finalproject.shared.mapping.UpdateDtoMapper;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class PaySheetDtoMapperEvdokimovRD implements UpdateDtoMapper<PaySheetRequestEvdokimovRD, PaySheetEvdokimovRD>, CreateDtoMapper<PaySheetRequestEvdokimovRD,PaySheetEvdokimovRD> {

    @Autowired
    private ObjectMapper mapper;

    @Override
    public PaySheetEvdokimovRD mapToEntity(PaySheetRequestEvdokimovRD request) {
        PaySheetEvdokimovRD employee;
        try {
            employee = mapper.readValue(request.getJsonRequest(), PaySheetEvdokimovRD.class);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
            throw new BadRequestException("bad_request_exception");
        }
        return employee;
    }

    @Override
    public PaySheetEvdokimovRD mapToEntity(PaySheetEvdokimovRD entity, PaySheetRequestEvdokimovRD request) {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        PaySheetEvdokimovRD employee;
        try {
            PaySheetEvdokimovRD p = mapper.readValue(request.getJsonRequest(), PaySheetEvdokimovRD.class);
            employee = mapper.updateValue(entity, request);
            if (p.getHours() != null) {
                employee.setHours(p.getHours());
            }
            if (p.getBet() != null) {
                employee.setBet(p.getBet());
            }
            if (p.getMonth() != null) {
                employee.setMonth(p.getMonth());
            }
            if (p.getYear() != null) {
                employee.setYear(p.getYear());
            }
        } catch (IOException exception) {
            throw new BadRequestException("bad_request_exception");
        }
        return employee;
    }
}
