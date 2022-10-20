package me.zy.reflect;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class PropertiesListInit {

    public static void main(String[] args) {
        try {
            List sonList = new ArrayList();
            Class sonClazz = Class.forName("me.zy.reflect.Rmrk");
            Object sonObj = sonClazz.newInstance();
            try {
                Field sonField = sonClazz.getDeclaredField("rmrk");//属性名
                sonField.setAccessible(true);
                sonField.set(sonObj,"备注");
                sonList.add(sonObj);
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            }


            Class clazz = Class.forName("me.zy.reflect.PropertiesList");
            Object obj = clazz.newInstance();

            Field declaredFields = clazz.getDeclaredField("rmrkList");
            declaredFields.setAccessible(true);
            declaredFields.set(obj,sonList);

            //普通Bean
            Class hardClazz = Class.forName("me.zy.reflect.Hard");
            Object hardObj = hardClazz.newInstance();
            try {
                Field hardField = hardClazz.getDeclaredField("why");//属性名
                hardField.setAccessible(true);
                hardField.set(hardObj,"为什么");
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
            Field hardField = clazz.getDeclaredField("hard");//属性名
            hardField.setAccessible(true);
            hardField.set(obj,hardObj);

            obj.toString();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

}
