package com.bsuir.evdokimov.finalproject.shared.mapping;

public interface UpdateDtoMapper<R, E> {

    E mapToEntity(E entity, R request);
}
