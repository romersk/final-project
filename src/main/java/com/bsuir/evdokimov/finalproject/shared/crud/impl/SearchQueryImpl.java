package com.bsuir.evdokimov.finalproject.shared.crud.impl;

import com.bsuir.evdokimov.finalproject.shared.crud.SearchQuery;
import com.bsuir.evdokimov.finalproject.shared.exception.EntityNotFoundException;
import com.bsuir.evdokimov.finalproject.shared.mapping.DtoPresenter;
import com.bsuir.evdokimov.finalproject.shared.persitance.EntityCrudRepository;
import com.bsuir.evdokimov.finalproject.shared.search.Page;
import com.bsuir.evdokimov.finalproject.shared.search.Paging;
import com.bsuir.evdokimov.finalproject.shared.search.impl.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class SearchQueryImpl<E, D> implements SearchQuery<E, D> {

    private final EntityCrudRepository<E, ?> repository;
    private final DtoPresenter<D, E> presenter;

    public SearchQueryImpl(EntityCrudRepository<E, ?> repository, DtoPresenter<D, E> presenter) {
        this.repository = repository;
        this.presenter = presenter;
    }

    @Override
    public Page<D> search(Specification<E> specification, Paging paging) {
        PageRequest pageRequest = PageRequest.of(paging.getPageNumber(), paging.getPerPageCount());
        org.springframework.data.domain.Page<E> pageOfEntities = repository.findAll(specification,
                pageRequest);
        List<E> listOfEntities = pageOfEntities.getContent();

        if (listOfEntities.isEmpty()) {
            throw new EntityNotFoundException("no_entities_for_page");
        }

        List<D> listOfDto = presenter.mapList(listOfEntities);
        return new PageImpl<D>(
                listOfDto,
                paging.getPageNumber(),
                (int) pageOfEntities.getTotalElements(),
                pageOfEntities.getTotalPages());
    }
}
