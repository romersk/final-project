package com.bsuir.evdokimov.finalproject.shared.crud;

import com.bsuir.evdokimov.finalproject.shared.search.Page;
import com.bsuir.evdokimov.finalproject.shared.search.Paging;
import org.springframework.data.jpa.domain.Specification;

public interface SearchQuery<E, D> {

    Page<D> search(Specification<E> specification, Paging paging);
}

