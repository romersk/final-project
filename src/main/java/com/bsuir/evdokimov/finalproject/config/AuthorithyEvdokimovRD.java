package com.bsuir.evdokimov.finalproject.config;

import com.bsuir.evdokimov.finalproject.users.entity.AuthorityEvdokimovRD;
import com.bsuir.evdokimov.finalproject.users.entity.UserEvdokimovRD;

import java.util.List;

public class AuthorithyEvdokimovRD {

    public static String getAuthority(UserEvdokimovRD userObj) {
        List<AuthorityEvdokimovRD> auth = (List<AuthorityEvdokimovRD>) userObj.getAuthorities();
        return auth.get(0).getRoleCode();
    }
}
