package com.bsuir.evdokimov.finalproject.position.request;

import com.bsuir.evdokimov.finalproject.shared.dto.CreateRequest;
import com.bsuir.evdokimov.finalproject.shared.dto.UpdateRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PositionRequestEvdokimovRD implements CreateRequest, UpdateRequest {
    private String jsonRequest;
}
