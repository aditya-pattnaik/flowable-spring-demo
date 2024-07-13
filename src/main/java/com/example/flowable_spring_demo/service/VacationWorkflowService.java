package com.example.flowable_spring_demo.service;

import com.example.flowable_spring_demo.domain.Request;
import org.flowable.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class VacationWorkflowService {
    @Autowired
    private RuntimeService runtimeService;

    @Transactional
    public void startProcess(Request request) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("employee", request.employee());
        variables.put("manager", request.manager());
        variables.put("days", request.days());
        runtimeService.startProcessInstanceByKey("vacationRequest", variables);
    }
}
