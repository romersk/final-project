package com.bsuir.evdokimov.finalproject.task.service;

import com.bsuir.evdokimov.finalproject.shared.search.Page;
import com.bsuir.evdokimov.finalproject.shared.search.Paging;
import com.bsuir.evdokimov.finalproject.shared.search.impl.PageImpl;
import com.bsuir.evdokimov.finalproject.shared.search.impl.PagingImpl;
import com.bsuir.evdokimov.finalproject.task.dto.TaskDtoEdokimovRD;
import com.bsuir.evdokimov.finalproject.task.entity.TaskEvdokimovRD;
import com.bsuir.evdokimov.finalproject.task.factory.TaskCommandFactoryEvdokimovRD;
import com.bsuir.evdokimov.finalproject.task.request.TaskRequestEvdokimovRD;
import com.bsuir.evdokimov.finalproject.task.specification.TaskSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceEvdokimovRD {

    @Autowired
    private TaskCommandFactoryEvdokimovRD commandFactory;

    public TaskDtoEdokimovRD create(final TaskRequestEvdokimovRD request) {
        final var command = commandFactory.createCommand();
        return command.create(request);
    }

    public TaskDtoEdokimovRD getById(final long id) {
        final var command = commandFactory.getByIdQuery();
        return command.getById(id);
    }

    public void delete(final long id) {
        final var command = commandFactory.deleteCommand();
        command.delete(id);
    }

    public Page<TaskDtoEdokimovRD> search(final Specification<TaskEvdokimovRD> specification, Paging paging) {
        final var command = commandFactory.searchQuery();
        return command.search(specification, paging);
    }

    public TaskDtoEdokimovRD update(final TaskRequestEvdokimovRD updateRequest, final long id) {
        final var command = commandFactory.updateCommand();
        return command.update(updateRequest, id);
    }

    public Page<TaskDtoEdokimovRD> getAll(Pageable pageable) {
        final var command = commandFactory.searchQuery();
        Page<TaskDtoEdokimovRD> page = command.search(TaskSpecification.getQueryAll(), new PagingImpl(pageable.getPageNumber(), pageable.getPageSize()));
        return page;
    }

    public Page<TaskDtoEdokimovRD> getAllByIdAndStatus(Pageable pageable, Long id) {
        final var command = commandFactory.searchQuery();
        Page<TaskDtoEdokimovRD> page = command.search(TaskSpecification.getQueryAllByPerson(id), new PagingImpl(pageable.getPageNumber(), pageable.getPageSize()));
        List<TaskDtoEdokimovRD> result = new ArrayList<>();
        for (TaskDtoEdokimovRD dtoEdokimovRD: page.getResult()) {
            if (dtoEdokimovRD.getStatus().equals("не в исполнении")) {
                result.add(dtoEdokimovRD);
            }
        }
        return new PageImpl<>(result,0, result.size(), result.size() / 20 + 1);
    }
}
