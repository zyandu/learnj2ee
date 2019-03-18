package me.zy.pattern.delegate.simple;

public class EmployeeA implements IEmployee{
    @Override
    public void doing(String command) {
        System.out.println("员工A做了加密工作");
    }
}
