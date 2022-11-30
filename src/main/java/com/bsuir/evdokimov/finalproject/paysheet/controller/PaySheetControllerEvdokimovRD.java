package com.bsuir.evdokimov.finalproject.paysheet.controller;

import com.bsuir.evdokimov.finalproject.paysheet.dto.PaySheetDtoEvdokimovRD;
import com.bsuir.evdokimov.finalproject.paysheet.request.PaySheetRequestEvdokimovRD;
import com.bsuir.evdokimov.finalproject.paysheet.service.PaySheetServiceEvdokimovRD;
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
public class PaySheetControllerEvdokimovRD {

    @Autowired
    private PaySheetServiceEvdokimovRD service;

    @Autowired
    private UserServiceEvdokimovRD serviceUser;

    @GetMapping("/paysheets")
    public ResponseEntity<Page<PaySheetDtoEvdokimovRD>> findAll(@PageableDefault(page = 0, size = 20) Pageable pageable) {
        Page<PaySheetDtoEvdokimovRD> page = service.getAll(pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @GetMapping("/paysheets/{month}/{year}")
    public ResponseEntity<Page<PaySheetDtoEvdokimovRD>> findAllById(Principal user, @PageableDefault(page = 0, size = 20) Pageable pageable,
                                                                    @PathVariable Long month, @PathVariable Long year) {
        UserEvdokimovRD userObj = (UserEvdokimovRD) serviceUser.loadUserByUsername(user.getName());
        Page<PaySheetDtoEvdokimovRD> page = service.getAllByPersonId(pageable, userObj.getId(), month, year);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @PutMapping("/paysheets/{id}")
    public ResponseEntity<PaySheetDtoEvdokimovRD> update(@RequestBody String request, @PathVariable Long id) {
        PaySheetDtoEvdokimovRD updatedUser = service.update(new PaySheetRequestEvdokimovRD(request), id);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/paysheets/{id}")
    public ResponseEntity<?> delete( @PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/paysheets")
    private ResponseEntity<?> create(@RequestBody String request) {
        PaySheetDtoEvdokimovRD created = service.create(new PaySheetRequestEvdokimovRD(request));
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
}
