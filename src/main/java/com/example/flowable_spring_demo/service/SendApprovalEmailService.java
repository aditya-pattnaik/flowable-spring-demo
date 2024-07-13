package com.example.flowable_spring_demo.service;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

public class SendApprovalEmailService implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) {
        System.out.println("==================================");
        System.out.println("Sending approval mail to employee.");
        System.out.println("==================================");
    }
}
