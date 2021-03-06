package me.zy.io.serializable;

import java.beans.Transient;
import java.io.*;

/**
 * 1）一旦变量被transient修饰，变量将不再是对象持久化的一部分，该变量内容在序列化后无法获得访问。

 2）transient关键字只能修饰变量，而不能修饰方法和类。注意，本地变量是不能被transient关键字修饰的。
    变量如果是用户自定义类变量，则该类需要实现Serializable接口。

 3）被transient关键字修饰的变量不再能被序列化，一个静态变量不管是否被transient修饰，均不能被序列化。
     第三点可能有些人很迷惑，因为发现在User类中的username字段前加上static关键字后，程序运行结果依然不变，
     即static类型的username也读出来为“Alexia”了，这不与第三点说的矛盾吗？实际上是这样的：
     第三点确实没错（一个静态变量不管是否被transient修饰，均不能被序列化），反序列化后类中static型变量
     username的值为当前JVM中对应static变量的值，这个值是JVM中的不是反序列化得出的，不相信？
     好吧，下面我来证明：
 */
public class SerializableTest {
    public static void main(String[] args) {
        User user = new User();
        user.setName("zy");
        user.setPasswd("passwd");

        ObjectOutputStream oos;
        try {
           oos = new ObjectOutputStream(new FileOutputStream("./serialize.txt"));
           oos.writeObject(user);
           oos.flush();
           oos.close();
        }catch (IOException e){
            e.printStackTrace();
        }


        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./serialize.txt"));
            User user1 = (User)ois.readObject();
            ois.close();

            System.out.println(user1.getName());
            System.out.println(user1.getPasswd());

            //在User类中的age字段前加上static关键字后，程序运行结果依然不变，
            // 即static类型的age也读出来为“10”了，这不与第三点说的矛盾吗？
            //实际上是这样的：第三点确实没错（一个静态变量不管是否被transient修饰，均不能被序列化），
            // 反序列化后类中static型变量age的值为当前JVM中对应static变量的值，这个值是JVM中的不是反序列化得出的
            User.age = 10;
            System.out.println(User.age);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

