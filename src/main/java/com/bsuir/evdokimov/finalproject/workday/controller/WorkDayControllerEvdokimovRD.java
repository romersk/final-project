package com.bsuir.evdokimov.finalproject.workday.controller;

import com.bsuir.evdokimov.finalproject.shared.search.Page;
import com.bsuir.evdokimov.finalproject.users.entity.UserEvdokimovRD;
import com.bsuir.evdokimov.finalproject.users.service.UserServiceEvdokimovRD;
import com.bsuir.evdokimov.finalproject.workday.dto.WorkDayDtoEvdokimovRD;
import com.bsuir.evdokimov.finalproject.workday.request.WorkDayRequestEvdokimovRD;
import com.bsuir.evdokimov.finalproject.workday.service.WorkDayServiceEvdokimovRD;
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
public class WorkDayControllerEvdokimovRD {

    @Autowired
    private WorkDayServiceEvdokimovRD service;

    @Autowired
    private UserServiceEvdokimovRD serviceUser;

    @GetMapping("/workdays")
    public ResponseEntity<Page<WorkDayDtoEvdokimovRD>> findAll(@PageableDefault(page = 0, size = 20) Pageable pageable) {
        Page<WorkDayDtoEvdokimovRD> page = service.getAll(pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @GetMapping("/workdays/{id}")
    public ResponseEntity<Page<WorkDayDtoEvdokimovRD>> findAllDone(Principal user, @PageableDefault(page = 0, size = 20) Pageable pageable, Long id) {
        UserEvdokimovRD userObj = (UserEvdokimovRD) serviceUser.loadUserByUsername(user.getName());
        Page<WorkDayDtoEvdokimovRD> page = service.getAll(pageable, userObj.getId());
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @PutMapping("/workdays/{id}")
    public ResponseEntity<WorkDayDtoEvdokimovRD> update(@RequestBody String request, @PathVariable Long id) {
        WorkDayDtoEvdokimovRD updatedUser = service.update(new WorkDayRequestEvdokimovRD(request), id);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/workdays/{id}")
    public ResponseEntity<?> delete( @PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/workdays")
    private ResponseEntity<?> create(@RequestBody String request) {
        WorkDayDtoEvdokimovRD created = service.create(new WorkDayRequestEvdokimovRD(request));
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
}
