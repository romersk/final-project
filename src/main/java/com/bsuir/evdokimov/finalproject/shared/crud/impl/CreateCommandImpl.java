package com.bsuir.evdokimov.finalproject.shared.crud.impl;

import com.bsuir.evdokimov.finalproject.shared.crud.CreateCommand;
import com.bsuir.evdokimov.finalproject.shared.exception.ValidationException;
import com.bsuir.evdokimov.finalproject.shared.mapping.CreateDtoMapper;
import com.bsuir.evdokimov.finalproject.shared.mapping.DtoPresenter;
import com.bsuir.evdokimov.finalproject.shared.persitance.EntityCrudRepository;
import com.bsuir.evdokimov.finalproject.shared.validation.Validator;

import java.util.List;

public class CreateCommandImpl<E, R, D, I> implements
        CreateCommand<E, R, D> {

    private final EntityCrudRepository<E, I> repository;
    private final CreateDtoMapper<R, E> createDtoMapper;
    private final Validator<E> validator;
    private final DtoPresenter<D, E> dtoPresenter;

    public CreateCommandImpl(EntityCrudRepository<E, I> repository,
                             CreateDtoMapper<R, E> createDtoMapper, Validator<E> validator,
                             DtoPresenter<D, E> dtoPresenter) {
        this.repository = repository;
        this.createDtoMapper = createDtoMapper;
        this.validator = validator;
        this.dtoPresenter = dtoPresenter;
    }

    @Override
    public D create(R createRequest) throws ValidationException {
        E entity = createDtoMapper.mapToEntity(createRequest);
        List<com.bsuir.evdokimov.finalproject.shared.validation.Error> errorList = validator.validate(entity);
        if (!errorList.isEmpty()) {
            throw new ValidationException(errorList);
        }
        entity = repository.save(entity);
        return dtoPresenter.map(entity);
    }
}
