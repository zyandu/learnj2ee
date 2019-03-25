package me.zy.pattern.observer.companynotice;

public class ObserverTest {
    public static void main(String[] args) {
        Company c = Company.getInstance();
        Receptionist receptionist = new Receptionist("Lily");

        c.addObserver(receptionist);

        Employee employee = new Employee("子墨");
        c.addObserver(employee);

        Notice notice = new Notice("通知","15：00到三会开会。");
        c.publishNotice(notice);
    }
}
