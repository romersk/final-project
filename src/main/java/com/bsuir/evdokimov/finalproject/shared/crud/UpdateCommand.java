package com.bsuir.evdokimov.finalproject.shared.crud;

public interface UpdateCommand<E, R, D, I> {

    D update(R updateRequest, I id);
}
