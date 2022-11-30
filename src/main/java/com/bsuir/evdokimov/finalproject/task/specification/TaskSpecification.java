package com.bsuir.evdokimov.finalproject.task.specification;

import com.bsuir.evdokimov.finalproject.task.entity.TaskEvdokimovRD;
import com.bsuir.evdokimov.finalproject.typetask.entity.TypeTaskEvdokimovRD;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class TaskSpecification {

    private TaskSpecification() {}

    public static Specification<TaskEvdokimovRD> getQueryAll() {
        return new Specification<TaskEvdokimovRD>() {
            public Predicate toPredicate(Root<TaskEvdokimovRD> root, CriteriaQuery<?> query,
                                         CriteriaBuilder builder) {
                return builder.greaterThan(root.get("id"),0);
            }
        };
    }

    public static Specification<TaskEvdokimovRD> getQueryAllByPerson(Long id) {
        return new Specification<TaskEvdokimovRD>() {
            public Predicate toPredicate(Root<TaskEvdokimovRD> root, CriteriaQuery<?> query,
                                         CriteriaBuilder builder) {
                return builder.equal(root.get("person").get("id"), id);
            }
        };
    }
}
