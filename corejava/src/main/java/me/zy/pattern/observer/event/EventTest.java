package me.zy.pattern.observer.event;

import me.zy.pattern.observer.event.mouse.Mouse;
import me.zy.pattern.observer.event.mouse.MouseCallback;
import me.zy.pattern.observer.event.mouse.MouseEventType;

public class EventTest {
    public static void main(String[] args) {
        MouseCallback callback = new MouseCallback();
        Mouse mouse = new Mouse();

        mouse.addLisenter(MouseEventType.ON_CLICK,callback);
        mouse.click();

    }
}
