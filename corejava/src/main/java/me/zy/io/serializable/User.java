package me.zy.io.serializable;

import java.io.Serializable;

public class User implements Serializable {
    public static transient int age = 18;
    private String name;
    private transient String passwd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
