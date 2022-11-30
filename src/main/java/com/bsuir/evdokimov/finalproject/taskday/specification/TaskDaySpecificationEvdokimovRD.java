package com.bsuir.evdokimov.finalproject.taskday.specification;

import com.bsuir.evdokimov.finalproject.taskday.entity.TaskDayEvdokimovRD;
import com.bsuir.evdokimov.finalproject.typetask.entity.TypeTaskEvdokimovRD;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class TaskDaySpecificationEvdokimovRD {

    private TaskDaySpecificationEvdokimovRD() {}

    public static Specification<TaskDayEvdokimovRD> getQueryAll() {
        return new Specification<TaskDayEvdokimovRD>() {
            public Predicate toPredicate(Root<TaskDayEvdokimovRD> root, CriteriaQuery<?> query,
                                         CriteriaBuilder builder) {
                return builder.greaterThan(root.get("id"),0);
            }
        };
    }

    public static Specification<TaskDayEvdokimovRD> getQueryAllByTask(Long id) {
        return new Specification<TaskDayEvdokimovRD>() {
            public Predicate toPredicate(Root<TaskDayEvdokimovRD> root, CriteriaQuery<?> query,
                                         CriteriaBuilder builder) {
                return builder.equal(root.get("task").get("id"),id);
            }
        };
    }
}
