package com.bsuir.evdokimov.finalproject.workday.service;

import com.bsuir.evdokimov.finalproject.shared.search.Page;
import com.bsuir.evdokimov.finalproject.shared.search.Paging;
import com.bsuir.evdokimov.finalproject.shared.search.impl.PageImpl;
import com.bsuir.evdokimov.finalproject.shared.search.impl.PagingImpl;
import com.bsuir.evdokimov.finalproject.task.dto.TaskDtoEdokimovRD;
import com.bsuir.evdokimov.finalproject.task.entity.TaskEvdokimovRD;
import com.bsuir.evdokimov.finalproject.task.request.TaskRequestEvdokimovRD;
import com.bsuir.evdokimov.finalproject.task.specification.TaskSpecification;
import com.bsuir.evdokimov.finalproject.workday.dto.WorkDayDtoEvdokimovRD;
import com.bsuir.evdokimov.finalproject.workday.entity.WorkDayEvdokimovRD;
import com.bsuir.evdokimov.finalproject.workday.factory.WorkDayCommandFactoryEvdokimovRD;
import com.bsuir.evdokimov.finalproject.workday.request.WorkDayRequestEvdokimovRD;
import com.bsuir.evdokimov.finalproject.workday.specification.WorkDaySpecificationEvdokimovRD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkDayServiceEvdokimovRD {

    @Autowired
    private WorkDayCommandFactoryEvdokimovRD commandFactory;

    public WorkDayDtoEvdokimovRD create(final WorkDayRequestEvdokimovRD request) {
        final var command = commandFactory.createCommand();
        return command.create(request);
    }

    public WorkDayDtoEvdokimovRD getById(final long id) {
        final var command = commandFactory.getByIdQuery();
        return command.getById(id);
    }

    public void delete(final long id) {
        final var command = commandFactory.deleteCommand();
        command.delete(id);
    }

    public Page<WorkDayDtoEvdokimovRD> search(final Specification<WorkDayEvdokimovRD> specification, Paging paging) {
        final var command = commandFactory.searchQuery();
        return command.search(specification, paging);
    }

    public WorkDayDtoEvdokimovRD update(final WorkDayRequestEvdokimovRD updateRequest, final long id) {
        final var command = commandFactory.updateCommand();
        return command.update(updateRequest, id);
    }

    public Page<WorkDayDtoEvdokimovRD> getAll(Pageable pageable) {
        final var command = commandFactory.searchQuery();
        Page<WorkDayDtoEvdokimovRD> page = command.search(WorkDaySpecificationEvdokimovRD.getQueryAll(), new PagingImpl(pageable.getPageNumber(), pageable.getPageSize()));
        return page;
    }

    public Page<WorkDayDtoEvdokimovRD> getAll(Pageable pageable, Long id) {
        final var command = commandFactory.searchQuery();
        Page<WorkDayDtoEvdokimovRD> page = command.search(WorkDaySpecificationEvdokimovRD.getQueryAllByPerson(id), new PagingImpl(pageable.getPageNumber(), pageable.getPageSize()));
        List<WorkDayDtoEvdokimovRD> result = new ArrayList<>();
        for (WorkDayDtoEvdokimovRD dtoEdokimovRD: page.getResult()) {
            if (dtoEdokimovRD.getStatus().equals("завершен")) {
                result.add(dtoEdokimovRD);
            }
        }
        return new PageImpl<>(result,0, result.size(), result.size() / 20 + 1);
    }
}
