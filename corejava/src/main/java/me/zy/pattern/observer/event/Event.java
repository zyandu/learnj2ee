package me.zy.pattern.observer.event;

import java.lang.reflect.Method;

public class Event {
    private Object source;//事件源：是由谁发起的
    private Object target;//事件触发通知谁
    private Method callback;//事件触发回调，做什么动作
    private String trigger;//事件的名称，触发的是什么事件
    private long time;//事件触发的时间

    public Event(Object target, Method callback) {
        this.target = target;
        this.callback = callback;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Method getCallback() {
        return callback;
    }

    public void setCallback(Method callback) {
        this.callback = callback;
    }

    public String getTrigger() {
        return trigger;
    }

    public Event setTrigger(String trigger) {
        this.trigger = trigger;
        return this;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
