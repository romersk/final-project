package com.bsuir.evdokimov.finalproject.paysheet.service;

import com.bsuir.evdokimov.finalproject.paysheet.dto.PaySheetDtoEvdokimovRD;
import com.bsuir.evdokimov.finalproject.paysheet.entity.PaySheetEvdokimovRD;
import com.bsuir.evdokimov.finalproject.paysheet.factory.PaySheetCommandFactoryEvdokimovRD;
import com.bsuir.evdokimov.finalproject.paysheet.request.PaySheetRequestEvdokimovRD;
import com.bsuir.evdokimov.finalproject.paysheet.specification.PaySheetSpecificationEvdokimovRD;
import com.bsuir.evdokimov.finalproject.shared.search.Page;
import com.bsuir.evdokimov.finalproject.shared.search.Paging;
import com.bsuir.evdokimov.finalproject.shared.search.impl.PageImpl;
import com.bsuir.evdokimov.finalproject.shared.search.impl.PagingImpl;
import com.bsuir.evdokimov.finalproject.task.dto.TaskDtoEdokimovRD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaySheetServiceEvdokimovRD {

    @Autowired
    private PaySheetCommandFactoryEvdokimovRD commandFactory;

    public PaySheetDtoEvdokimovRD create(final PaySheetRequestEvdokimovRD request) {
        final var command = commandFactory.createCommand();
        return command.create(request);
    }

    public PaySheetDtoEvdokimovRD getById(final long id) {
        final var command = commandFactory.getByIdQuery();
        return command.getById(id);
    }

    public void delete(final long id) {
        final var command = commandFactory.deleteCommand();
        command.delete(id);
    }

    public Page<PaySheetDtoEvdokimovRD> search(final Specification<PaySheetEvdokimovRD> specification, Paging paging) {
        final var command = commandFactory.searchQuery();
        return command.search(specification, paging);
    }

    public PaySheetDtoEvdokimovRD update(final PaySheetRequestEvdokimovRD updateRequest, final long id) {
        final var command = commandFactory.updateCommand();
        return command.update(updateRequest, id);
    }

    public Page<PaySheetDtoEvdokimovRD> getAll(Pageable pageable) {
        final var command = commandFactory.searchQuery();
        Page<PaySheetDtoEvdokimovRD> page = command.search(PaySheetSpecificationEvdokimovRD.getQueryAll(), new PagingImpl(pageable.getPageNumber(), pageable.getPageSize()));
        return page;
    }

    public Page<PaySheetDtoEvdokimovRD> getAllByPersonId(Pageable pageable, Long id, Long month, Long year) {
        final var command = commandFactory.searchQuery();
        Page<PaySheetDtoEvdokimovRD> page = command.search(PaySheetSpecificationEvdokimovRD.getQueryAllPerson(id), new PagingImpl(pageable.getPageNumber(), pageable.getPageSize()));
        List<PaySheetDtoEvdokimovRD> result = new ArrayList<>();
        for (PaySheetDtoEvdokimovRD dtoEdokimovRD: page.getResult()) {
            if (dtoEdokimovRD.getMonth().equals(month) && dtoEdokimovRD.getYear().equals(year)) {
                result.add(dtoEdokimovRD);
            }
        }
        return new PageImpl<>(result,0, result.size(), result.size() / 20 + 1);
    }
}
