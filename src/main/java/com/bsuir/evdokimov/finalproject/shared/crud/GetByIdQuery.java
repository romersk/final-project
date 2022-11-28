package com.bsuir.evdokimov.finalproject.shared.crud;

public interface GetByIdQuery<E, D, I>{

    D getById(I id);
}
