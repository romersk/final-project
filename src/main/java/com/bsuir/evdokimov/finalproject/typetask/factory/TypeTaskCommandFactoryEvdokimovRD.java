package com.bsuir.evdokimov.finalproject.typetask.factory;

import com.bsuir.evdokimov.finalproject.shared.crud.AbstractCommandFactory;
import com.bsuir.evdokimov.finalproject.shared.mapping.CreateDtoMapper;
import com.bsuir.evdokimov.finalproject.shared.mapping.DtoPresenter;
import com.bsuir.evdokimov.finalproject.shared.mapping.UpdateDtoMapper;
import com.bsuir.evdokimov.finalproject.shared.persitance.EntityCrudRepository;
import com.bsuir.evdokimov.finalproject.shared.validation.Validator;
import com.bsuir.evdokimov.finalproject.typetask.dto.TypeTaskDtoEvdokimovRD;
import com.bsuir.evdokimov.finalproject.typetask.dto.mapper.TypeTaskDtoMapperEvdokimovRD;
import com.bsuir.evdokimov.finalproject.typetask.dto.presenter.TypeTaskDtoPresenterEvdokimovRD;
import com.bsuir.evdokimov.finalproject.typetask.entity.TypeTaskEvdokimovRD;
import com.bsuir.evdokimov.finalproject.typetask.repository.TypeTaskRepositoryEvdokimovRD;
import com.bsuir.evdokimov.finalproject.typetask.request.TypeTaskRequestEvdokimovRD;
import com.bsuir.evdokimov.finalproject.typetask.validator.TypeTaskValidatorEvdokimovRD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class TypeTaskCommandFactoryEvdokimovRD extends AbstractCommandFactory<TypeTaskEvdokimovRD, Long, TypeTaskRequestEvdokimovRD, TypeTaskDtoEvdokimovRD> {

    @Autowired
    public TypeTaskCommandFactoryEvdokimovRD(ApplicationContext context) {
        super(context);
    }

    @Override
    protected Class<? extends CreateDtoMapper<TypeTaskRequestEvdokimovRD, TypeTaskEvdokimovRD>> getCreateDtoMapperClass() {
        return TypeTaskDtoMapperEvdokimovRD.class;
    }

    @Override
    protected Class<? extends DtoPresenter<TypeTaskDtoEvdokimovRD, TypeTaskEvdokimovRD>> getEntityPresenterClass() {
        return TypeTaskDtoPresenterEvdokimovRD.class;
    }

    @Override
    protected Class<? extends UpdateDtoMapper<TypeTaskRequestEvdokimovRD, TypeTaskEvdokimovRD>> getUpdateDtoMapperClass() {
        return TypeTaskDtoMapperEvdokimovRD.class;
    }

    @Override
    protected Class<? extends Validator<TypeTaskEvdokimovRD>> getValidatorClass() {
        return TypeTaskValidatorEvdokimovRD.class;
    }

    @Override
    protected Class<? extends EntityCrudRepository<TypeTaskEvdokimovRD, Long>> getRepository() {
        return TypeTaskRepositoryEvdokimovRD.class;
    }
}
