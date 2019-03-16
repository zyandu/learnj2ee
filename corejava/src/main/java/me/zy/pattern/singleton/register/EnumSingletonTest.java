package me.zy.pattern.singleton.register;

import me.zy.pattern.singleton.serializable.SerializableSingleton;

import java.io.*;

public class EnumSingletonTest {
    public static void main(String[] args) {
        EnumSingleton es = EnumSingleton.getInstance();
        es.setData(new Object());

        EnumSingleton es1 = null;
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream("corejava/src/test/EnumSingleton.obj"));
            oos.writeObject(es);
            oos.flush();
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("corejava/src/test/EnumSingleton.obj"));
            es1 = (EnumSingleton)ois.readObject();
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(es);
        System.out.println(es1);
        System.out.println(es.getData() == es1.getData());
    }
}
