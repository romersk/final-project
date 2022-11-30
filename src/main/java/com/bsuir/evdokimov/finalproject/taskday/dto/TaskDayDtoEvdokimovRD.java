package com.bsuir.evdokimov.finalproject.taskday.dto;

import com.bsuir.evdokimov.finalproject.task.entity.TaskEvdokimovRD;
import com.bsuir.evdokimov.finalproject.workday.entity.WorkDayEvdokimovRD;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@Data
public class TaskDayDtoEvdokimovRD {

    private Long id;
    private Double timeSpent;
    private TaskEvdokimovRD task;
    private WorkDayEvdokimovRD workday;
}
