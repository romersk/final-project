package com.bsuir.evdokimov.finalproject.shared.search;

import java.util.List;

public interface Page<D> {

    List<D> getResult();

    int getPageNumber();

    int getTotalElements();

    int getTotalPages();
}
