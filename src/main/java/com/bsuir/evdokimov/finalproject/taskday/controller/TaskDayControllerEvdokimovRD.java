package com.bsuir.evdokimov.finalproject.taskday.controller;

import com.bsuir.evdokimov.finalproject.shared.search.Page;
import com.bsuir.evdokimov.finalproject.taskday.dto.TaskDayDtoEvdokimovRD;
import com.bsuir.evdokimov.finalproject.taskday.request.TaskDayRequestEvdokimovRD;
import com.bsuir.evdokimov.finalproject.taskday.service.TaskDayServiceEvdokimovRD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class TaskDayControllerEvdokimovRD {

    @Autowired
    private TaskDayServiceEvdokimovRD service;

    @GetMapping("/taskdays")
    public ResponseEntity<Page<TaskDayDtoEvdokimovRD>> findAll(@PageableDefault(page = 0, size = 20) Pageable pageable) {
        Page<TaskDayDtoEvdokimovRD> page = service.getAll(pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @GetMapping("/taskdays/{id}")
    public ResponseEntity<Page<TaskDayDtoEvdokimovRD>> findAByIdTask(@PageableDefault(page = 0, size = 20) Pageable pageable,
                                                               @PathVariable Long id) {
        Page<TaskDayDtoEvdokimovRD> page = service.getAll(pageable,id);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @PutMapping("/taskdays/{id}")
    public ResponseEntity<TaskDayDtoEvdokimovRD> update(@RequestBody String request, @PathVariable Long id) {
        TaskDayDtoEvdokimovRD updatedUser = service.update(new TaskDayRequestEvdokimovRD(request), id);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/taskdays/{id}")
    public ResponseEntity<?> delete( @PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/taskdays")
    private ResponseEntity<?> create(@RequestBody String request) {
        TaskDayDtoEvdokimovRD created = service.create(new TaskDayRequestEvdokimovRD(request));
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
}
