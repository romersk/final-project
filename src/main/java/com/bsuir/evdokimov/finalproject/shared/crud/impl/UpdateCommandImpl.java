package com.bsuir.evdokimov.finalproject.shared.crud.impl;

import com.bsuir.evdokimov.finalproject.shared.crud.UpdateCommand;
import com.bsuir.evdokimov.finalproject.shared.exception.EntityNotFoundException;
import com.bsuir.evdokimov.finalproject.shared.exception.ValidationException;
import com.bsuir.evdokimov.finalproject.shared.mapping.DtoPresenter;
import com.bsuir.evdokimov.finalproject.shared.mapping.UpdateDtoMapper;
import com.bsuir.evdokimov.finalproject.shared.persitance.EntityCrudRepository;
import com.bsuir.evdokimov.finalproject.shared.validation.Validator;
import com.bsuir.evdokimov.finalproject.shared.validation.Error;

import java.util.List;
import java.util.logging.Logger;

public class UpdateCommandImpl<E, R, D, I> implements UpdateCommand<E, R, D, I> {

    private final EntityCrudRepository<E, I> repository;
    private final UpdateDtoMapper<R, E> updateDtoMapper;
    private final Validator<E> validator;
    private final DtoPresenter<D, E> dtoPresenter;

    public UpdateCommandImpl(EntityCrudRepository<E, I> repository,
                             UpdateDtoMapper<R, E> updateDtoMapper, Validator<E> validator,
                             DtoPresenter<D, E> dtoPresenter) {
        this.repository = repository;
        this.updateDtoMapper = updateDtoMapper;
        this.validator = validator;
        this.dtoPresenter = dtoPresenter;
    }

    @Override
    public D update(R updateRequest, I id) {
        E entity;
        try {
            entity = repository.getById(id);
            updateDtoMapper.mapToEntity(entity, updateRequest);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException();
        }

        List<Error> listOfErrors = validator.validate(entity);
        if (!listOfErrors.isEmpty()) {
            throw new ValidationException(listOfErrors);
        }

        repository.save(entity);
        return dtoPresenter.map(entity);
    }
}
