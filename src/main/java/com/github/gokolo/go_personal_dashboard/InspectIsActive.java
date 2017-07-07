package com.github.gokolo.go_personal_dashboard;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.TreeSet;

public class InspectIsActive {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Class<User> c = User.class;
        Field[] f = c.getDeclaredFields();
        Method[] m = c.getDeclaredMethods();
        TreeSet<String> nameSet = new TreeSet<String>();

        for (Field field : f) {
            if (field.isAnnotationPresent(IsActive.class)) {
                IsActive anno = field.getAnnotation(IsActive.class);
                boolean value = anno.active();
                if (value) {
                    nameSet.add(field.getName());
                }
            }
        }
        for (Method method : m) {
            if (method.isAnnotationPresent(IsActive.class)) {
                IsActive anno = method.getAnnotation(IsActive.class);
                boolean value = anno.active();
                if (value) {
                    nameSet.add(method.getName());
                }
            }
        }
        for (String value : nameSet) {
            System.out.println(value);
        }

    }

}
