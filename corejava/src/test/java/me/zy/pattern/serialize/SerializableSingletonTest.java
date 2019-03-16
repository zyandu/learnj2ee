package me.zy.pattern.serialize;

import me.zy.pattern.singleton.serializable.SerializableSingleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableSingletonTest {
    public static void main(String[] args) {
        SerializableSingleton instance = SerializableSingleton.getInstance();

        try{
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream("corejava/src/test/SerializableSingleton.obj"));
            oos.writeObject(instance);
            oos.flush();
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("corejava/src/test/SerializableSingleton.obj"));
            SerializableSingleton instance1 = (SerializableSingleton)ois.readObject();
            ois.close();

            System.out.println(instance == instance1);

        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
