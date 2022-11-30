package com.bsuir.evdokimov.finalproject.task.repository;

import com.bsuir.evdokimov.finalproject.shared.persitance.EntityCrudRepository;
import com.bsuir.evdokimov.finalproject.task.entity.TaskEvdokimovRD;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepositoryEvdokimovRD extends EntityCrudRepository<TaskEvdokimovRD, Long> {
}
