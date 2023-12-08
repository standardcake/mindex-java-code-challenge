package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompensationController {
    @Autowired
    private CompensationService compensationService;

    @GetMapping("/compensation/{employeeId}")
    public Compensation getCompensation(@PathVariable String employeeId) {
        return compensationService.read(employeeId);
    }

    @PostMapping("/compensation")
    public Compensation createCompensation(@RequestBody Compensation compensation) {
        return compensationService.create(compensation);
    }
}
