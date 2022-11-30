package com.bsuir.evdokimov.finalproject.taskday.service;

import com.bsuir.evdokimov.finalproject.shared.search.Page;
import com.bsuir.evdokimov.finalproject.shared.search.Paging;
import com.bsuir.evdokimov.finalproject.shared.search.impl.PagingImpl;
import com.bsuir.evdokimov.finalproject.taskday.dto.TaskDayDtoEvdokimovRD;
import com.bsuir.evdokimov.finalproject.taskday.entity.TaskDayEvdokimovRD;
import com.bsuir.evdokimov.finalproject.taskday.factory.TaskDayCommandFactoryEvdokimovRD;
import com.bsuir.evdokimov.finalproject.taskday.request.TaskDayRequestEvdokimovRD;
import com.bsuir.evdokimov.finalproject.taskday.specification.TaskDaySpecificationEvdokimovRD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class TaskDayServiceEvdokimovRD {

    @Autowired
    private TaskDayCommandFactoryEvdokimovRD commandFactory;

    public TaskDayDtoEvdokimovRD create(final TaskDayRequestEvdokimovRD request) {
        final var command = commandFactory.createCommand();
        return command.create(request);
    }

    public TaskDayDtoEvdokimovRD getById(final long id) {
        final var command = commandFactory.getByIdQuery();
        return command.getById(id);
    }

    public void delete(final long id) {
        final var command = commandFactory.deleteCommand();
        command.delete(id);
    }

    public Page<TaskDayDtoEvdokimovRD> search(final Specification<TaskDayEvdokimovRD> specification, Paging paging) {
        final var command = commandFactory.searchQuery();
        return command.search(specification, paging);
    }

    public TaskDayDtoEvdokimovRD update(final TaskDayRequestEvdokimovRD updateRequest, final long id) {
        final var command = commandFactory.updateCommand();
        return command.update(updateRequest, id);
    }

    public Page<TaskDayDtoEvdokimovRD> getAll(Pageable pageable) {
        final var command = commandFactory.searchQuery();
        Page<TaskDayDtoEvdokimovRD> page = command.search(TaskDaySpecificationEvdokimovRD.getQueryAll(), new PagingImpl(pageable.getPageNumber(), pageable.getPageSize()));
        return page;
    }

    public Page<TaskDayDtoEvdokimovRD> getAll(Pageable pageable, Long id) {
        final var command = commandFactory.searchQuery();
        Page<TaskDayDtoEvdokimovRD> page = command.search(TaskDaySpecificationEvdokimovRD.getQueryAllByTask(id), new PagingImpl(pageable.getPageNumber(), pageable.getPageSize()));
        return page;
    }
}
