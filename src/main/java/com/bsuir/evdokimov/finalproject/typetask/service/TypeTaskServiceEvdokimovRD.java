package com.bsuir.evdokimov.finalproject.typetask.service;

import com.bsuir.evdokimov.finalproject.position.dto.PositionDtoEvdokimovRD;
import com.bsuir.evdokimov.finalproject.position.entity.PositionEvdokimovRD;
import com.bsuir.evdokimov.finalproject.position.factory.PositionCommandFactoryEvdokimovRD;
import com.bsuir.evdokimov.finalproject.position.request.PositionRequestEvdokimovRD;
import com.bsuir.evdokimov.finalproject.position.specification.PositionSpecificationsEvdokimovRD;
import com.bsuir.evdokimov.finalproject.shared.search.Page;
import com.bsuir.evdokimov.finalproject.shared.search.Paging;
import com.bsuir.evdokimov.finalproject.shared.search.impl.PagingImpl;
import com.bsuir.evdokimov.finalproject.typetask.dto.TypeTaskDtoEvdokimovRD;
import com.bsuir.evdokimov.finalproject.typetask.entity.TypeTaskEvdokimovRD;
import com.bsuir.evdokimov.finalproject.typetask.factory.TypeTaskCommandFactoryEvdokimovRD;
import com.bsuir.evdokimov.finalproject.typetask.request.TypeTaskRequestEvdokimovRD;
import com.bsuir.evdokimov.finalproject.typetask.specification.TypeTaskSpecificationEvdokimovRD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class TypeTaskServiceEvdokimovRD {

    @Autowired
    private TypeTaskCommandFactoryEvdokimovRD commandFactory;

    public TypeTaskDtoEvdokimovRD create(final TypeTaskRequestEvdokimovRD request) {
        final var command = commandFactory.createCommand();
        return command.create(request);
    }

    public TypeTaskDtoEvdokimovRD getById(final long id) {
        final var command = commandFactory.getByIdQuery();
        return command.getById(id);
    }

    public void delete(final long id) {
        final var command = commandFactory.deleteCommand();
        command.delete(id);
    }

    public Page<TypeTaskDtoEvdokimovRD> search(final Specification<TypeTaskEvdokimovRD> specification, Paging paging) {
        final var command = commandFactory.searchQuery();
        return command.search(specification, paging);
    }

    public TypeTaskDtoEvdokimovRD update(final TypeTaskRequestEvdokimovRD updateRequest, final long id) {
        final var command = commandFactory.updateCommand();
        return command.update(updateRequest, id);
    }

    public Page<TypeTaskDtoEvdokimovRD> getAll(Pageable pageable) {
        final var command = commandFactory.searchQuery();
        Page<TypeTaskDtoEvdokimovRD> page = command.search(TypeTaskSpecificationEvdokimovRD.getQueryAll(), new PagingImpl(pageable.getPageNumber(), pageable.getPageSize()));
        return page;
    }
}
