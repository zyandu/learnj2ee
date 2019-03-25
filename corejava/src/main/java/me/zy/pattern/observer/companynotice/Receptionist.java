package me.zy.pattern.observer.companynotice;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者/发布者
 */
public class Receptionist implements Observer {
    private String name;

    public Receptionist(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        Company company = (Company) o;
        Notice notice = (Notice) arg;
        System.out.println(name + "，你好：\n" +
                "你收到了"+((Company) o).getName()+"的通告，请发给XX部门。通知内容如下："+notice.getContent());

    }
}
