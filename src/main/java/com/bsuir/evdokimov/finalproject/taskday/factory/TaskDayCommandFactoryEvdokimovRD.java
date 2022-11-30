package com.bsuir.evdokimov.finalproject.taskday.factory;

import com.bsuir.evdokimov.finalproject.shared.crud.AbstractCommandFactory;
import com.bsuir.evdokimov.finalproject.shared.mapping.CreateDtoMapper;
import com.bsuir.evdokimov.finalproject.shared.mapping.DtoPresenter;
import com.bsuir.evdokimov.finalproject.shared.mapping.UpdateDtoMapper;
import com.bsuir.evdokimov.finalproject.shared.persitance.EntityCrudRepository;
import com.bsuir.evdokimov.finalproject.shared.validation.Validator;
import com.bsuir.evdokimov.finalproject.taskday.dto.TaskDayDtoEvdokimovRD;
import com.bsuir.evdokimov.finalproject.taskday.dto.mapper.TaskDayDtoMapperEvdokimovRD;
import com.bsuir.evdokimov.finalproject.taskday.dto.presenter.TaskDayDtoPresenterEvdokimovRD;
import com.bsuir.evdokimov.finalproject.taskday.entity.TaskDayEvdokimovRD;
import com.bsuir.evdokimov.finalproject.taskday.repository.TaskDayRepositoryEvdokimovRD;
import com.bsuir.evdokimov.finalproject.taskday.request.TaskDayRequestEvdokimovRD;
import com.bsuir.evdokimov.finalproject.taskday.validator.TaskDayValidatorEvdokimovRD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class TaskDayCommandFactoryEvdokimovRD extends AbstractCommandFactory<TaskDayEvdokimovRD, Long, TaskDayRequestEvdokimovRD, TaskDayDtoEvdokimovRD> {

    @Autowired
    public TaskDayCommandFactoryEvdokimovRD(ApplicationContext context) {
        super(context);
    }

    @Override
    protected Class<? extends CreateDtoMapper<TaskDayRequestEvdokimovRD, TaskDayEvdokimovRD>> getCreateDtoMapperClass() {
        return TaskDayDtoMapperEvdokimovRD.class;
    }

    @Override
    protected Class<? extends DtoPresenter<TaskDayDtoEvdokimovRD, TaskDayEvdokimovRD>> getEntityPresenterClass() {
        return TaskDayDtoPresenterEvdokimovRD.class;
    }

    @Override
    protected Class<? extends UpdateDtoMapper<TaskDayRequestEvdokimovRD, TaskDayEvdokimovRD>> getUpdateDtoMapperClass() {
        return TaskDayDtoMapperEvdokimovRD.class;
    }

    @Override
    protected Class<? extends Validator<TaskDayEvdokimovRD>> getValidatorClass() {
        return TaskDayValidatorEvdokimovRD.class;
    }

    @Override
    protected Class<? extends EntityCrudRepository<TaskDayEvdokimovRD, Long>> getRepository() {
        return TaskDayRepositoryEvdokimovRD.class;
    }
}
