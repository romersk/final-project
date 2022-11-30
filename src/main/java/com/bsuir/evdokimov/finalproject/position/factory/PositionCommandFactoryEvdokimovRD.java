package com.bsuir.evdokimov.finalproject.position.factory;

import com.bsuir.evdokimov.finalproject.position.dto.PositionDtoEvdokimovRD;
import com.bsuir.evdokimov.finalproject.position.dto.mapper.PositionDtoMapperEvdokimovRD;
import com.bsuir.evdokimov.finalproject.position.dto.presenter.PositionDtoPresenterEvdokimovRD;
import com.bsuir.evdokimov.finalproject.position.entity.PositionEvdokimovRD;
import com.bsuir.evdokimov.finalproject.position.repository.PositionRepositoryEvdokimovRD;
import com.bsuir.evdokimov.finalproject.position.request.PositionRequestEvdokimovRD;
import com.bsuir.evdokimov.finalproject.position.validator.PositionValidatorEvdokimovRD;
import com.bsuir.evdokimov.finalproject.shared.crud.AbstractCommandFactory;
import com.bsuir.evdokimov.finalproject.shared.mapping.CreateDtoMapper;
import com.bsuir.evdokimov.finalproject.shared.mapping.DtoPresenter;
import com.bsuir.evdokimov.finalproject.shared.mapping.UpdateDtoMapper;
import com.bsuir.evdokimov.finalproject.shared.persitance.EntityCrudRepository;
import com.bsuir.evdokimov.finalproject.shared.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class PositionCommandFactoryEvdokimovRD extends AbstractCommandFactory<PositionEvdokimovRD, Long, PositionRequestEvdokimovRD, PositionDtoEvdokimovRD> {

    @Autowired
    public PositionCommandFactoryEvdokimovRD(ApplicationContext context) {
        super(context);
    }

    @Override
    protected Class<? extends CreateDtoMapper<PositionRequestEvdokimovRD, PositionEvdokimovRD>> getCreateDtoMapperClass() {
        return PositionDtoMapperEvdokimovRD.class;
    }

    @Override
    protected Class<? extends DtoPresenter<PositionDtoEvdokimovRD, PositionEvdokimovRD>> getEntityPresenterClass() {
        return PositionDtoPresenterEvdokimovRD.class;
    }

    @Override
    protected Class<? extends UpdateDtoMapper<PositionRequestEvdokimovRD, PositionEvdokimovRD>> getUpdateDtoMapperClass() {
        return PositionDtoMapperEvdokimovRD.class;
    }

    @Override
    protected Class<? extends Validator<PositionEvdokimovRD>> getValidatorClass() {
        return PositionValidatorEvdokimovRD.class;
    }

    @Override
    protected Class<? extends EntityCrudRepository<PositionEvdokimovRD, Long>> getRepository() {
        return PositionRepositoryEvdokimovRD.class;
    }
}
