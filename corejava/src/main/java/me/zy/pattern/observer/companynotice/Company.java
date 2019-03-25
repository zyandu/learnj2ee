package me.zy.pattern.observer.companynotice;

import java.util.Observable;

/*
 * JDK提供的一种观察者实现方式
 * 被观察者
 */
public class Company extends Observable {
    private static Company receptionist = null;
    private String name = "某某公司";
    private Company(){}

    public static Company getInstance(){
        if(null == receptionist){
            receptionist = new Company();
        }

        return receptionist;
    }

    public String getName() {
        return name;
    }

    public void publishNotice(Notice notice){
        setChanged();
        notifyObservers(notice);
    }

}
