package com.bsuir.evdokimov.finalproject.paysheet.repository;

import com.bsuir.evdokimov.finalproject.paysheet.entity.PaySheetEvdokimovRD;
import com.bsuir.evdokimov.finalproject.shared.persitance.EntityCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaySheetRepositoryEvdokimovRD  extends EntityCrudRepository<PaySheetEvdokimovRD, Long> {
}
