package com.bsuir.evdokimov.finalproject.position.controller;

import com.bsuir.evdokimov.finalproject.position.dto.PositionDtoEvdokimovRD;
import com.bsuir.evdokimov.finalproject.position.request.PositionRequestEvdokimovRD;
import com.bsuir.evdokimov.finalproject.position.service.PositionServiceEvdokimovRD;
import com.bsuir.evdokimov.finalproject.shared.search.Page;
import com.bsuir.evdokimov.finalproject.users.entity.UserEvdokimovRD;
import com.bsuir.evdokimov.finalproject.users.service.UserServiceEvdokimovRD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class PositionControllerEvdokimovRD {

    @Autowired
    private PositionServiceEvdokimovRD service;

    @Autowired
    private UserServiceEvdokimovRD serviceUser;

    @GetMapping("/positions")
    public ResponseEntity<Page<PositionDtoEvdokimovRD>> findAll(Principal user, @PageableDefault(page = 0, size = 20) Pageable pageable) {
        UserEvdokimovRD userObj = (UserEvdokimovRD) serviceUser.loadUserByUsername(user.getName());

        Page<PositionDtoEvdokimovRD> page = service.getAll(pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @PutMapping("/positions/{id}")
    public ResponseEntity<PositionDtoEvdokimovRD> update(@RequestBody String request, @PathVariable Long id) {
        PositionDtoEvdokimovRD updatedUser = service.update(new PositionRequestEvdokimovRD(request), id);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/positions/{id}")
    public ResponseEntity<?> delete( @PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/positions")
    private ResponseEntity<?> create(@RequestBody String request) {
        PositionDtoEvdokimovRD created = service.create(new PositionRequestEvdokimovRD(request));
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
}
