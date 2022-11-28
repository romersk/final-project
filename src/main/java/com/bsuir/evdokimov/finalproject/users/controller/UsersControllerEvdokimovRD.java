package com.bsuir.evdokimov.finalproject.users.controller;

import com.bsuir.evdokimov.finalproject.config.AuthorithyEvdokimovRD;
import com.bsuir.evdokimov.finalproject.users.dto.UsersDtoEvdokimovRD;
import com.bsuir.evdokimov.finalproject.users.entity.UserEvdokimovRD;
import com.bsuir.evdokimov.finalproject.users.request.UserRequestEvdokimovRD;
import com.bsuir.evdokimov.finalproject.users.service.UserServiceEvdokimovRD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class UsersControllerEvdokimovRD {

    @Autowired
    private UserServiceEvdokimovRD service;

    @GetMapping("/admin/users")
    public ResponseEntity<Page<UsersDtoEvdokimovRD>> findAll(Principal user, @PageableDefault(page = 0, size = 20) Pageable pageable) {
        UserEvdokimovRD userObj = (UserEvdokimovRD) service.loadUserByUsername(user.getName());
        if (AuthorithyEvdokimovRD.getAuthority(userObj).equals("ADMIN")) {
            Page<UsersDtoEvdokimovRD> page = service.getAll(pageable);
            return new ResponseEntity<>(page, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }
    }

    @PutMapping("/admin/users/{id}")
    public ResponseEntity<UsersDtoEvdokimovRD> updateUsers(Principal user, @RequestBody String request, @PathVariable Long id) {
        UserEvdokimovRD userObj = (UserEvdokimovRD) service.loadUserByUsername(user.getName());
        if (AuthorithyEvdokimovRD.getAuthority(userObj).equals("ADMIN")) {
            UsersDtoEvdokimovRD updatedUser = service.update(new UserRequestEvdokimovRD(request), id);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }
    }

    @DeleteMapping("/admin/users/{id}")
    public ResponseEntity<?> deleteUser(Principal user, @PathVariable Long id) {
        UserEvdokimovRD userObj = (UserEvdokimovRD) service.loadUserByUsername(user.getName());
        if (AuthorithyEvdokimovRD.getAuthority(userObj).equals("ADMIN")) {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }
    }
}
