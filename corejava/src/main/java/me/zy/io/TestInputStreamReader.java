package me.zy.io;

import java.io.IOException;
import java.io.InputStreamReader;

public class TestInputStreamReader {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        System.out.println(isr.read());
    }
}
