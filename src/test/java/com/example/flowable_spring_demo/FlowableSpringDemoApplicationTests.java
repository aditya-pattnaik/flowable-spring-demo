package com.example.flowable_spring_demo;

import com.example.flowable_spring_demo.domain.Request;
import com.example.flowable_spring_demo.service.VacationWorkflowService;
import org.flowable.engine.TaskService;
import org.flowable.engine.test.Deployment;
import org.flowable.spring.impl.test.FlowableSpringExtension;
import org.flowable.task.api.Task;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(FlowableSpringExtension.class)
@SpringBootTest
class FlowableSpringDemoApplicationTests {

    @Autowired
    private VacationWorkflowService vacationWorkflowService;

    @Autowired
    private TaskService taskService;

    @Test
    @Deployment(resources = {"processes/vacation-request.bpmn20.xml"})
    public void vacationApprovalTest() {
        Request request = new Request("Employee", "Manager", 5);
        vacationWorkflowService.startProcess(request);
        Task task = taskService.createTaskQuery()
                .singleResult();
        assertEquals("Approve or Reject the request", task.getName());
        Map<String, Object> variables = new HashMap<>();
        variables.put("vacationApproved", true);
        taskService.complete(task.getId(), variables);
    }

    @Test
    @Deployment(resources = {"processes/vacation-request.bpmn20.xml"})
    public void vacationRejectionTest() {
        Request request = new Request("Employee", "Manager", 5);
        vacationWorkflowService.startProcess(request);
        Task task = taskService.createTaskQuery()
                .singleResult();
        assertEquals("Approve or Reject the request", task.getName());
        Map<String, Object> variables = new HashMap<>();
        variables.put("vacationApproved", false);
        taskService.complete(task.getId(), variables);
    }
}
