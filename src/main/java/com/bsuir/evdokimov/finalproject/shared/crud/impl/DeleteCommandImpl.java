package com.bsuir.evdokimov.finalproject.shared.crud.impl;

import com.bsuir.evdokimov.finalproject.shared.crud.DeleteCommand;
import com.bsuir.evdokimov.finalproject.shared.exception.EntityNotFoundException;
import com.bsuir.evdokimov.finalproject.shared.persitance.EntityCrudRepository;

public class DeleteCommandImpl<E, I> implements DeleteCommand<E, I> {

    private final EntityCrudRepository<E, I> repository;

    public DeleteCommandImpl(EntityCrudRepository<E, I> repository) {
        this.repository = repository;
    }

    @Override
    public void delete(I id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException();
        }
        repository.deleteById(id);
    }
}
