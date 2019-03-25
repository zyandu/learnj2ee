package me.zy.pattern.observer.event.mouse;

import me.zy.pattern.observer.event.Event;

public class MouseCallback {
    public void onClick(Event event){
        System.out.println("单击");
    }

    public void onWhell(Event event){
        System.out.println("滑轮");
    }
}
