package com.bsuir.evdokimov.finalproject.shared.crud;

public interface CreateCommand <E,R,D>{

    D create(R createRequest);
}
