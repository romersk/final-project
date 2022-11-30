package com.bsuir.evdokimov.finalproject.typetask.repository;

import com.bsuir.evdokimov.finalproject.shared.persitance.EntityCrudRepository;
import com.bsuir.evdokimov.finalproject.typetask.entity.TypeTaskEvdokimovRD;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeTaskRepositoryEvdokimovRD extends EntityCrudRepository<TypeTaskEvdokimovRD, Long> {
}
