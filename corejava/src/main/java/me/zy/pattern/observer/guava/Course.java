package me.zy.pattern.observer.guava;

import com.google.common.eventbus.Subscribe;

public class Course {
    @Subscribe
    public void noticeCourse(String student){
        System.out.println(student + "准备学习课程");
    }
}
