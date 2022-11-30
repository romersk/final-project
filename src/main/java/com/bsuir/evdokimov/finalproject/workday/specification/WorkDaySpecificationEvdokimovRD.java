package com.bsuir.evdokimov.finalproject.workday.specification;

import com.bsuir.evdokimov.finalproject.task.entity.TaskEvdokimovRD;
import com.bsuir.evdokimov.finalproject.workday.entity.WorkDayEvdokimovRD;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class WorkDaySpecificationEvdokimovRD {

    private WorkDaySpecificationEvdokimovRD() {}

    public static Specification<WorkDayEvdokimovRD> getQueryAll() {
        return new Specification<WorkDayEvdokimovRD>() {
            public Predicate toPredicate(Root<WorkDayEvdokimovRD> root, CriteriaQuery<?> query,
                                         CriteriaBuilder builder) {
                return builder.greaterThan(root.get("id"),0);
            }
        };
    }

    public static Specification<WorkDayEvdokimovRD> getQueryAllByPerson(Long id) {
        return new Specification<WorkDayEvdokimovRD>() {
            public Predicate toPredicate(Root<WorkDayEvdokimovRD> root, CriteriaQuery<?> query,
                                         CriteriaBuilder builder) {
                return builder.equal(root.get("person").get("id"), id);
            }
        };
    }
}
