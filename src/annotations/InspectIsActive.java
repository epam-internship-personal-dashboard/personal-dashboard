package annotations;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import main.User;

public class InspectIsActive {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Class<User> c = User.class;
        Field[] f = c.getDeclaredFields();
        Method[] m = c.getMethods();

        for (Field field : f) {
            if (field.isAnnotationPresent(IsActive.class)) {
                IsActive anno = field.getAnnotation(IsActive.class);
                boolean value = anno.active();
                if (value) {
                    System.out.println("The field \"" + field.getName() + "\" in Class " + c.getName() + " is True");
                }
            }
        }

        for (Method method : m) {
            if (method.isAnnotationPresent(IsActive.class)) {
                IsActive anno = method.getAnnotation(IsActive.class);
                boolean value = anno.active();
                if (value) {
                    System.out.println("The method \"" + method.getName() + "\" in Class " + c.getName() + " is True");
                }
            }
        }
    }

}
