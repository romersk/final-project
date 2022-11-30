package com.bsuir.evdokimov.finalproject.typetask.validator;

import com.bsuir.evdokimov.finalproject.shared.validation.Error;
import com.bsuir.evdokimov.finalproject.shared.validation.Validator;
import com.bsuir.evdokimov.finalproject.typetask.entity.TypeTaskEvdokimovRD;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TypeTaskValidatorEvdokimovRD implements Validator<TypeTaskEvdokimovRD> {
    @Override
    public List<Error> validate(TypeTaskEvdokimovRD entity) {
        List<Error> errorList = new ArrayList<>();
        if (entity.getMinTime() > entity.getMaxTime()) {
            errorList.add(Error.fieldValidationError("min_time", "is greater than max time"));
        }
        if (!entity.getHartType().equals("простой") && !entity.getHartType().equals("средний") &&
            !entity.getHartType().equals("сложный")) {
            errorList.add(Error.fieldValidationError("hard_type", "incorrect type"));
        }
        return errorList;
    }
}
