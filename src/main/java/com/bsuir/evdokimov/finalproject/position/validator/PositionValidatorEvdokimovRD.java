package com.bsuir.evdokimov.finalproject.position.validator;

import com.bsuir.evdokimov.finalproject.position.entity.PositionEvdokimovRD;
import com.bsuir.evdokimov.finalproject.shared.validation.Error;
import com.bsuir.evdokimov.finalproject.shared.validation.Validator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PositionValidatorEvdokimovRD implements Validator<PositionEvdokimovRD> {

    @Override
    public List<Error> validate(PositionEvdokimovRD entity) {
        List<Error> errorList = new ArrayList<>();
        errorList.addAll(validateLength(entity));
        return errorList;
    }

    private List<Error> validateLength(PositionEvdokimovRD entity) {
        List<Error> errorList = new ArrayList<>();

        if (entity.getDivision() == null) {
            errorList.add(Error.fieldValidationError("division", "required"));
        } else if (entity.getDivision().length() > 100) {
            errorList.add(Error.fieldValidationError("division", "max_length_55"));
        }

        if (entity.getPosition() == null) {
            errorList.add(Error.fieldValidationError("position", "required"));
        } else if (entity.getPosition().length() > 100) {
            errorList.add(Error.fieldValidationError("position", "max_length_55"));
        }

        return errorList;
    }
}
