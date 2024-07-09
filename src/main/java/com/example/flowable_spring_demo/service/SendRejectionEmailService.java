package com.example.flowable_spring_demo.service;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
public class SendRejectionEmailService implements JavaDelegate {
    public void execute(DelegateExecution execution) {
        System.out.println("Sending approval mail to employee.");
    }
}
