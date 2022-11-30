package com.bsuir.evdokimov.finalproject.taskday.repository;

import com.bsuir.evdokimov.finalproject.shared.persitance.EntityCrudRepository;
import com.bsuir.evdokimov.finalproject.taskday.entity.TaskDayEvdokimovRD;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDayRepositoryEvdokimovRD extends EntityCrudRepository<TaskDayEvdokimovRD, Long> {
}
