package com.bsuir.evdokimov.finalproject.workday.factory;

import com.bsuir.evdokimov.finalproject.shared.crud.AbstractCommandFactory;
import com.bsuir.evdokimov.finalproject.shared.mapping.CreateDtoMapper;
import com.bsuir.evdokimov.finalproject.shared.mapping.DtoPresenter;
import com.bsuir.evdokimov.finalproject.shared.mapping.UpdateDtoMapper;
import com.bsuir.evdokimov.finalproject.shared.persitance.EntityCrudRepository;
import com.bsuir.evdokimov.finalproject.shared.validation.Validator;
import com.bsuir.evdokimov.finalproject.workday.dto.WorkDayDtoEvdokimovRD;
import com.bsuir.evdokimov.finalproject.workday.dto.mapper.WorkDayDtoMapperEvdokimovRD;
import com.bsuir.evdokimov.finalproject.workday.dto.presenter.WorkDayDtoPresenterEvdokimovRD;
import com.bsuir.evdokimov.finalproject.workday.entity.WorkDayEvdokimovRD;
import com.bsuir.evdokimov.finalproject.workday.repository.WorkDayRepositoryEvdokimovRD;
import com.bsuir.evdokimov.finalproject.workday.request.WorkDayRequestEvdokimovRD;
import com.bsuir.evdokimov.finalproject.workday.validator.WorkDayValidatorEvdokimovRD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class WorkDayCommandFactoryEvdokimovRD extends AbstractCommandFactory<WorkDayEvdokimovRD, Long, WorkDayRequestEvdokimovRD, WorkDayDtoEvdokimovRD> {

    @Autowired
    public WorkDayCommandFactoryEvdokimovRD(ApplicationContext context) {
        super(context);
    }

    @Override
    protected Class<? extends CreateDtoMapper<WorkDayRequestEvdokimovRD, WorkDayEvdokimovRD>> getCreateDtoMapperClass() {
        return WorkDayDtoMapperEvdokimovRD.class;
    }

    @Override
    protected Class<? extends DtoPresenter<WorkDayDtoEvdokimovRD, WorkDayEvdokimovRD>> getEntityPresenterClass() {
        return WorkDayDtoPresenterEvdokimovRD.class;
    }

    @Override
    protected Class<? extends UpdateDtoMapper<WorkDayRequestEvdokimovRD, WorkDayEvdokimovRD>> getUpdateDtoMapperClass() {
        return WorkDayDtoMapperEvdokimovRD.class;
    }

    @Override
    protected Class<? extends Validator<WorkDayEvdokimovRD>> getValidatorClass() {
        return WorkDayValidatorEvdokimovRD.class;
    }

    @Override
    protected Class<? extends EntityCrudRepository<WorkDayEvdokimovRD, Long>> getRepository() {
        return WorkDayRepositoryEvdokimovRD.class;
    }
}
