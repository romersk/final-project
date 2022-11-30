package com.bsuir.evdokimov.finalproject.paysheet.specification;

import com.bsuir.evdokimov.finalproject.paysheet.entity.PaySheetEvdokimovRD;
import com.bsuir.evdokimov.finalproject.position.entity.PositionEvdokimovRD;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class PaySheetSpecificationEvdokimovRD {

    private PaySheetSpecificationEvdokimovRD() {}

    public static Specification<PaySheetEvdokimovRD> getQueryAll() {
        return new Specification<PaySheetEvdokimovRD>() {
            public Predicate toPredicate(Root<PaySheetEvdokimovRD> root, CriteriaQuery<?> query,
                                         CriteriaBuilder builder) {
                return builder.greaterThan(root.get("id"),0);
            }
        };
    }

    public static Specification<PaySheetEvdokimovRD> getQueryAllPerson(Long id) {
        return new Specification<PaySheetEvdokimovRD>() {
            public Predicate toPredicate(Root<PaySheetEvdokimovRD> root, CriteriaQuery<?> query,
                                         CriteriaBuilder builder) {
                return builder.equal(root.get("person").get("id"),id);
            }
        };
    }
}
