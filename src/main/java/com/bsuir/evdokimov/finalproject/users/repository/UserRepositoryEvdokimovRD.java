package com.bsuir.evdokimov.finalproject.users.repository;

import com.bsuir.evdokimov.finalproject.shared.persitance.EntityCrudRepository;
import com.bsuir.evdokimov.finalproject.users.entity.UserEvdokimovRD;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryEvdokimovRD extends EntityCrudRepository<UserEvdokimovRD, Long> {

    UserEvdokimovRD findUserByUserName(String name);
}
