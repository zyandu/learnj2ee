package me.zy;

import java.util.Date;

public class TestDataDiff {
    public static void main(String[] args) {
        Date d = new Date();
        Date d1 = new Date();
        System.out.println(d.getTime() == d1.getTime());
    }
}
