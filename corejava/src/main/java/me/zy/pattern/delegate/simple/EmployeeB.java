package me.zy.pattern.delegate.simple;

public class EmployeeB implements IEmployee{
    @Override
    public void doing(String command) {
        System.out.println("员工B做了后台工作");
    }
}
