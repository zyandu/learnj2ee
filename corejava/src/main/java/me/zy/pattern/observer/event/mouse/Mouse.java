package me.zy.pattern.observer.event.mouse;

import me.zy.pattern.observer.event.EventListener;

public class Mouse extends EventListener {
    public void click(){
        System.out.println("==== mouse  click..");
        this.trigger(MouseEventType.ON_CLICK);
    }
}
