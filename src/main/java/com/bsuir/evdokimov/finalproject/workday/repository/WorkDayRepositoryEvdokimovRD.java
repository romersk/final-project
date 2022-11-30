package com.bsuir.evdokimov.finalproject.workday.repository;

import com.bsuir.evdokimov.finalproject.shared.persitance.EntityCrudRepository;
import com.bsuir.evdokimov.finalproject.workday.entity.WorkDayEvdokimovRD;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkDayRepositoryEvdokimovRD extends EntityCrudRepository<WorkDayEvdokimovRD, Long> {
}
