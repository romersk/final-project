package com.bsuir.evdokimov.finalproject.task.controller;

import com.bsuir.evdokimov.finalproject.config.AuthorithyEvdokimovRD;
import com.bsuir.evdokimov.finalproject.shared.search.Page;
import com.bsuir.evdokimov.finalproject.task.dto.TaskDtoEdokimovRD;
import com.bsuir.evdokimov.finalproject.task.request.TaskRequestEvdokimovRD;
import com.bsuir.evdokimov.finalproject.task.service.TaskServiceEvdokimovRD;
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
public class TaskControllerEvdokimovRD {

    @Autowired
    private TaskServiceEvdokimovRD service;

    @Autowired
    private UserServiceEvdokimovRD serviceUser;


    @GetMapping("/task")
    public ResponseEntity<Page<TaskDtoEdokimovRD>> findAll(Principal user, @PageableDefault(page = 0, size = 20) Pageable pageable) {
        UserEvdokimovRD userObj = (UserEvdokimovRD) serviceUser.loadUserByUsername(user.getName());
        if (AuthorithyEvdokimovRD.getAuthority(userObj).equals("Сотрудник")) {
            Page<TaskDtoEdokimovRD> page = service.getAllByIdAndStatus(pageable, userObj.getId());
            return new ResponseEntity<>(page, HttpStatus.OK);
        }
        Page<TaskDtoEdokimovRD> page = service.getAll(pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<?> getById(Principal user, @PathVariable Long id) {
        TaskDtoEdokimovRD auditDtoEvdokimovRD = service.getById(id);
        return new ResponseEntity<>(auditDtoEvdokimovRD, HttpStatus.OK);
    }

    @PutMapping("/task/{id}")
    public ResponseEntity<TaskDtoEdokimovRD> update(@RequestBody String request, @PathVariable Long id) {
        TaskDtoEdokimovRD updatedUser = service.update(new TaskRequestEvdokimovRD(request), id);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity<?> delete( @PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/task")
    private ResponseEntity<?> create(@RequestBody String request) {
        TaskDtoEdokimovRD created = service.create(new TaskRequestEvdokimovRD(request));
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
}
