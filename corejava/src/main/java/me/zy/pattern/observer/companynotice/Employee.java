package me.zy.pattern.observer.companynotice;

import java.util.Observable;
import java.util.Observer;

public class Employee implements Observer {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        Company c = (Company) o;
        Notice notice = (Notice) arg;

        System.out.println(name +"收到"+c.getName()+"的通知。内容如下："+ notice.getContent());

    }
}
