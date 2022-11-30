package com.bsuir.evdokimov.finalproject.taskday.validator;

import com.bsuir.evdokimov.finalproject.shared.validation.Error;
import com.bsuir.evdokimov.finalproject.shared.validation.Validator;
import com.bsuir.evdokimov.finalproject.taskday.entity.TaskDayEvdokimovRD;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskDayValidatorEvdokimovRD implements Validator<TaskDayEvdokimovRD> {
    @Override
    public List<Error> validate(TaskDayEvdokimovRD entity) {
        return new ArrayList<>();
    }
}
