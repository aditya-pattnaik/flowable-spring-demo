package com.example.flowable_spring_demo.service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.flowable_spring_demo.domain.Request;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VacationWorkflowService {
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

    @Transactional
    public void startProcess(Request request) {
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("employee", request.getEmployee());
        variables.put("days", request.getDays());
        runtimeService.startProcessInstanceByKey("request", variables);
    }
}
