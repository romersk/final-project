package com.bsuir.evdokimov.finalproject.paysheet.validator;

import com.bsuir.evdokimov.finalproject.paysheet.entity.PaySheetEvdokimovRD;
import com.bsuir.evdokimov.finalproject.shared.validation.Error;
import com.bsuir.evdokimov.finalproject.shared.validation.Validator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class PaySheetValidatorEvdokimovRD implements Validator<PaySheetEvdokimovRD> {
    @Override
    public List<Error> validate(PaySheetEvdokimovRD entity) {
        List<Error> errorList = new ArrayList<>();
        errorList.addAll(validateDouble(entity));
        return errorList;
    }

    private List<Error> validateDouble(PaySheetEvdokimovRD entity) {
        List<Error> errorList = new ArrayList<>();

        if (entity.getBet().compareTo(1.0) > 0 || entity.getBet().compareTo(0.0) < 0) {
            errorList.add(Error.fieldValidationError("bet", "more than required"));
        }
        return errorList;
    }
}
