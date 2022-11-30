package com.bsuir.evdokimov.finalproject.typetask.controller;

import com.bsuir.evdokimov.finalproject.shared.search.Page;
import com.bsuir.evdokimov.finalproject.typetask.dto.TypeTaskDtoEvdokimovRD;
import com.bsuir.evdokimov.finalproject.typetask.request.TypeTaskRequestEvdokimovRD;
import com.bsuir.evdokimov.finalproject.typetask.service.TypeTaskServiceEvdokimovRD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class TypeTaskControllerEvdokimovRD {

    @Autowired
    private TypeTaskServiceEvdokimovRD service;

    @GetMapping("/typetask")
    public ResponseEntity<Page<TypeTaskDtoEvdokimovRD>> findAll(@PageableDefault(page = 0, size = 20) Pageable pageable) {
        Page<TypeTaskDtoEvdokimovRD> page = service.getAll(pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @PutMapping("/typetask/{id}")
    public ResponseEntity<TypeTaskDtoEvdokimovRD> update(@RequestBody String request, @PathVariable Long id) {
        TypeTaskDtoEvdokimovRD updatedUser = service.update(new TypeTaskRequestEvdokimovRD(request), id);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/typetask/{id}")
    public ResponseEntity<?> delete( @PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/typetask")
    private ResponseEntity<?> create(@RequestBody String request) {
        TypeTaskDtoEvdokimovRD created = service.create(new TypeTaskRequestEvdokimovRD(request));
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
}
