package com.bsuir.evdokimov.finalproject.position.specification;

import com.bsuir.evdokimov.finalproject.position.entity.PositionEvdokimovRD;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class PositionSpecificationsEvdokimovRD {

    private PositionSpecificationsEvdokimovRD() {}

    public static Specification<PositionEvdokimovRD> getQueryAll() {
        return new Specification<PositionEvdokimovRD>() {
            public Predicate toPredicate(Root<PositionEvdokimovRD> root, CriteriaQuery<?> query,
                                         CriteriaBuilder builder) {
                return builder.greaterThan(root.get("id"),0);
            }
        };
    }
}
