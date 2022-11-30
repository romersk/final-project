package com.bsuir.evdokimov.finalproject.taskday.request;

import com.bsuir.evdokimov.finalproject.shared.dto.CreateRequest;
import com.bsuir.evdokimov.finalproject.shared.dto.UpdateRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TaskDayRequestEvdokimovRD implements CreateRequest, UpdateRequest {
    private String jsonRequest;
}
