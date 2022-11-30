package com.bsuir.evdokimov.finalproject.workday.validator;

import com.bsuir.evdokimov.finalproject.shared.validation.Error;
import com.bsuir.evdokimov.finalproject.shared.validation.Validator;
import com.bsuir.evdokimov.finalproject.workday.entity.WorkDayEvdokimovRD;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WorkDayValidatorEvdokimovRD implements Validator<WorkDayEvdokimovRD> {
    @Override
    public List<Error> validate(WorkDayEvdokimovRD entity) {
        return new ArrayList<>();
    }
}
