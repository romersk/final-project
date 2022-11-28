package com.bsuir.evdokimov.finalproject.shared.crud;

public interface DeleteCommand<E, I> {

    void delete(I id);
}
