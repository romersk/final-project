package com.bsuir.evdokimov.finalproject.position.service;

import com.bsuir.evdokimov.finalproject.position.dto.PositionDtoEvdokimovRD;
import com.bsuir.evdokimov.finalproject.position.entity.PositionEvdokimovRD;
import com.bsuir.evdokimov.finalproject.position.factory.PositionCommandFactoryEvdokimovRD;
import com.bsuir.evdokimov.finalproject.position.request.PositionRequestEvdokimovRD;
import com.bsuir.evdokimov.finalproject.position.specification.PositionSpecificationsEvdokimovRD;
import com.bsuir.evdokimov.finalproject.shared.search.Page;
import com.bsuir.evdokimov.finalproject.shared.search.Paging;
import com.bsuir.evdokimov.finalproject.shared.search.impl.PageImpl;
import com.bsuir.evdokimov.finalproject.shared.search.impl.PagingImpl;
import com.bsuir.evdokimov.finalproject.task.dto.TaskDtoEdokimovRD;
import com.bsuir.evdokimov.finalproject.users.entity.UserEvdokimovRD;
import com.bsuir.evdokimov.finalproject.users.factory.UserCommandFactoryEvdokimovRD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PositionServiceEvdokimovRD {

    @Autowired
    private PositionCommandFactoryEvdokimovRD commandFactory;

    public PositionDtoEvdokimovRD create(final PositionRequestEvdokimovRD request) {
        final var command = commandFactory.createCommand();
        return command.create(request);
    }

    public PositionDtoEvdokimovRD getById(final long id) {
        final var command = commandFactory.getByIdQuery();
        return command.getById(id);
    }

    public void delete(final long id) {
        final var command = commandFactory.deleteCommand();
        command.delete(id);
    }

    public Page<PositionDtoEvdokimovRD> search(final Specification<PositionEvdokimovRD> specification, Paging paging) {
        final var command = commandFactory.searchQuery();
        return command.search(specification, paging);
    }

    public PositionDtoEvdokimovRD update(final PositionRequestEvdokimovRD updateRequest, final long id) {
        final var command = commandFactory.updateCommand();
        return command.update(updateRequest, id);
    }

    public Page<PositionDtoEvdokimovRD> getAll(Pageable pageable) {
        final var command = commandFactory.searchQuery();
        Page<PositionDtoEvdokimovRD> page = command.search(PositionSpecificationsEvdokimovRD.getQueryAll(), new PagingImpl(pageable.getPageNumber(), pageable.getPageSize()));
        return page;
    }

    public Page<PositionDtoEvdokimovRD> getAll(Pageable pageable, Long id) {
        final var command = commandFactory.searchQuery();
        Page<PositionDtoEvdokimovRD> page = command.search(PositionSpecificationsEvdokimovRD.getQueryAll(), new PagingImpl(pageable.getPageNumber(), pageable.getPageSize()));
        return page;
    }
}
