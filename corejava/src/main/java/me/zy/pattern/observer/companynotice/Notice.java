package me.zy.pattern.observer.companynotice;

import java.util.Observable;

public class Notice extends Observable {
    private String title;
    private String content;

    public Notice(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
