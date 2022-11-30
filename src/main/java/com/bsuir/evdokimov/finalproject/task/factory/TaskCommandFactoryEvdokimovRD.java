package com.bsuir.evdokimov.finalproject.task.factory;

import com.bsuir.evdokimov.finalproject.shared.crud.AbstractCommandFactory;
import com.bsuir.evdokimov.finalproject.shared.mapping.CreateDtoMapper;
import com.bsuir.evdokimov.finalproject.shared.mapping.DtoPresenter;
import com.bsuir.evdokimov.finalproject.shared.mapping.UpdateDtoMapper;
import com.bsuir.evdokimov.finalproject.shared.persitance.EntityCrudRepository;
import com.bsuir.evdokimov.finalproject.shared.validation.Validator;
import com.bsuir.evdokimov.finalproject.task.dto.TaskDtoEdokimovRD;
import com.bsuir.evdokimov.finalproject.task.dto.mapper.TaskDtoMapperEvdokimovRD;
import com.bsuir.evdokimov.finalproject.task.dto.presenter.TaskDtoPresenterEvdokimovRD;
import com.bsuir.evdokimov.finalproject.task.entity.TaskEvdokimovRD;
import com.bsuir.evdokimov.finalproject.task.repository.TaskRepositoryEvdokimovRD;
import com.bsuir.evdokimov.finalproject.task.request.TaskRequestEvdokimovRD;
import com.bsuir.evdokimov.finalproject.task.validator.TaskValidatorEvdokimovRD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class TaskCommandFactoryEvdokimovRD extends AbstractCommandFactory<TaskEvdokimovRD, Long, TaskRequestEvdokimovRD, TaskDtoEdokimovRD> {

    @Autowired
    public TaskCommandFactoryEvdokimovRD(ApplicationContext context) {
        super(context);
    }

    @Override
    protected Class<? extends CreateDtoMapper<TaskRequestEvdokimovRD, TaskEvdokimovRD>> getCreateDtoMapperClass() {
        return TaskDtoMapperEvdokimovRD.class;
    }

    @Override
    protected Class<? extends DtoPresenter<TaskDtoEdokimovRD, TaskEvdokimovRD>> getEntityPresenterClass() {
        return TaskDtoPresenterEvdokimovRD.class;
    }

    @Override
    protected Class<? extends UpdateDtoMapper<TaskRequestEvdokimovRD, TaskEvdokimovRD>> getUpdateDtoMapperClass() {
        return TaskDtoMapperEvdokimovRD.class;
    }

    @Override
    protected Class<? extends Validator<TaskEvdokimovRD>> getValidatorClass() {
        return TaskValidatorEvdokimovRD.class;
    }

    @Override
    protected Class<? extends EntityCrudRepository<TaskEvdokimovRD, Long>> getRepository() {
        return TaskRepositoryEvdokimovRD.class;
    }
}
