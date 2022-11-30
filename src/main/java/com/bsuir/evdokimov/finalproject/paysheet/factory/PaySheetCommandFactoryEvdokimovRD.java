package com.bsuir.evdokimov.finalproject.paysheet.factory;

import com.bsuir.evdokimov.finalproject.paysheet.dto.PaySheetDtoEvdokimovRD;
import com.bsuir.evdokimov.finalproject.paysheet.dto.mapper.PaySheetDtoMapperEvdokimovRD;
import com.bsuir.evdokimov.finalproject.paysheet.dto.presenter.PaySheetDtoPresenterEvdokimovRD;
import com.bsuir.evdokimov.finalproject.paysheet.entity.PaySheetEvdokimovRD;
import com.bsuir.evdokimov.finalproject.paysheet.repository.PaySheetRepositoryEvdokimovRD;
import com.bsuir.evdokimov.finalproject.paysheet.request.PaySheetRequestEvdokimovRD;
import com.bsuir.evdokimov.finalproject.paysheet.validator.PaySheetValidatorEvdokimovRD;
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
public class PaySheetCommandFactoryEvdokimovRD extends AbstractCommandFactory<PaySheetEvdokimovRD, Long, PaySheetRequestEvdokimovRD, PaySheetDtoEvdokimovRD> {

    @Autowired
    public PaySheetCommandFactoryEvdokimovRD(ApplicationContext context) {
        super(context);
    }

    @Override
    protected Class<? extends CreateDtoMapper<PaySheetRequestEvdokimovRD, PaySheetEvdokimovRD>> getCreateDtoMapperClass() {
        return PaySheetDtoMapperEvdokimovRD.class;
    }

    @Override
    protected Class<? extends DtoPresenter<PaySheetDtoEvdokimovRD, PaySheetEvdokimovRD>> getEntityPresenterClass() {
        return PaySheetDtoPresenterEvdokimovRD.class;
    }

    @Override
    protected Class<? extends UpdateDtoMapper<PaySheetRequestEvdokimovRD, PaySheetEvdokimovRD>> getUpdateDtoMapperClass() {
        return PaySheetDtoMapperEvdokimovRD.class;
    }

    @Override
    protected Class<? extends Validator<PaySheetEvdokimovRD>> getValidatorClass() {
        return PaySheetValidatorEvdokimovRD.class;
    }

    @Override
    protected Class<? extends EntityCrudRepository<PaySheetEvdokimovRD, Long>> getRepository() {
        return PaySheetRepositoryEvdokimovRD.class;
    }
}
