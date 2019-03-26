package me.zy.pattern.observer.guava;

import com.google.common.eventbus.EventBus;

public class GuavaObseTest {
    public static void main(String[] args) {
        EventBus eb = new EventBus();
        Course c = new Course();
        eb.register(c);
        eb.post("zhangsan");
    }
}
