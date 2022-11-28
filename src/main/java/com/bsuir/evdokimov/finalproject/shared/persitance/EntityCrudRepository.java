package com.bsuir.evdokimov.finalproject.shared.persitance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface EntityCrudRepository<E, I> extends JpaRepository<E, I>,
        JpaSpecificationExecutor<E> {
}
