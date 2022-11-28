package com.bsuir.evdokimov.finalproject.shared.validation;

import java.util.List;

public interface Validator<E> {

    List<Error> validate(E entity);
}
