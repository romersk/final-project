package com.bsuir.evdokimov.finalproject.typetask.specification;

import com.bsuir.evdokimov.finalproject.position.entity.PositionEvdokimovRD;
import com.bsuir.evdokimov.finalproject.typetask.entity.TypeTaskEvdokimovRD;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class TypeTaskSpecificationEvdokimovRD {

    private TypeTaskSpecificationEvdokimovRD() {}

    public static Specification<TypeTaskEvdokimovRD> getQueryAll() {
        return new Specification<TypeTaskEvdokimovRD>() {
            public Predicate toPredicate(Root<TypeTaskEvdokimovRD> root, CriteriaQuery<?> query,
                                         CriteriaBuilder builder) {
                return builder.greaterThan(root.get("id"),0);
            }
        };
    }
}
