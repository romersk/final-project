package com.bsuir.evdokimov.finalproject.position.repository;

import com.bsuir.evdokimov.finalproject.position.entity.PositionEvdokimovRD;
import com.bsuir.evdokimov.finalproject.shared.persitance.EntityCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepositoryEvdokimovRD extends EntityCrudRepository<PositionEvdokimovRD, Long> {
}
