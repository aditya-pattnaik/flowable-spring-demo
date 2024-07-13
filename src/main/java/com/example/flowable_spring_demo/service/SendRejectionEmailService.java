package com.example.flowable_spring_demo.service;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

public class SendRejectionEmailService implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) {
        System.out.println("====================================");
        System.out.println("Sending rejection email to employee.");
        System.out.println("====================================");
    }
}
