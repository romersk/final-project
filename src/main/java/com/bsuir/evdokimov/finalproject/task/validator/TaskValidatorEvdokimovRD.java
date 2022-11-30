package com.bsuir.evdokimov.finalproject.task.validator;

import com.bsuir.evdokimov.finalproject.shared.validation.Error;
import com.bsuir.evdokimov.finalproject.shared.validation.Validator;
import com.bsuir.evdokimov.finalproject.task.entity.TaskEvdokimovRD;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskValidatorEvdokimovRD implements Validator<TaskEvdokimovRD> {
    @Override
    public List<Error> validate(TaskEvdokimovRD entity) {
        return new ArrayList<>();
    }
}
