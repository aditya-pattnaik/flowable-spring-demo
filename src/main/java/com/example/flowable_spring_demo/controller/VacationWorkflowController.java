package com.example.flowable_spring_demo.controller;

import com.example.flowable_spring_demo.domain.Request;
import com.example.flowable_spring_demo.service.VacationWorkflowService;

@RestController
public class VacationWorkflowController {
    @Autowired
    private VacationWorkflowService service;
    @PostMapping("/submit")
    public void submit(@RequestBody Request request) {
        service.startProcess(request);
    }
}
