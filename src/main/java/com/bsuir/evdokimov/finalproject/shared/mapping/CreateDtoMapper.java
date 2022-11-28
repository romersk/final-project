package com.bsuir.evdokimov.finalproject.shared.mapping;

public interface CreateDtoMapper<R, E> {

    E mapToEntity(R request);
}
