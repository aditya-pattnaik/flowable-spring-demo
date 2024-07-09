package com.example.flowable_spring_demo.domain;

public class Request {
    private String employee;
    private Integer days;

    public Request() {
    }

    public Request(String employee, Integer days) {
        this.employee = employee;
        this.days = days;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    @Override
    public String toString() {
        return ("[" + this.employee + " " + this.days + "]");
    }
}
