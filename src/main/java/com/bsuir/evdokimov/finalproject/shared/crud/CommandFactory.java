package com.bsuir.evdokimov.finalproject.shared.crud;

public interface CommandFactory {

    CreateCommand createCommand();

    DeleteCommand deleteCommand();

    GetByIdQuery getByIdQuery();

    SearchQuery searchQuery();

    UpdateCommand updateCommand();
}
