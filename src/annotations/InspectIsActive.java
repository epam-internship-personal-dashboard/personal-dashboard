package annotations;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.TreeSet;

import main.User;

public class InspectIsActive {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Class<User> c = User.class;
        Field[] f = c.getDeclaredFields();
        Method[] m = c.getMethods();
        TreeSet<String> fSet = new TreeSet<String>();
        TreeSet<String> MSet = new TreeSet<String>();

        try {
            for (Field field : f) {
                if (field.isAnnotationPresent(IsActive.class)) {
                    IsActive anno = field.getAnnotation(IsActive.class);
                    boolean value = anno.active();
                    if (value) {
                        fSet.add(field.getName());
                    }
                }
            }
            for (String value : fSet) {
                System.out.println(value);
            }
        } catch (TypeNotPresentException e) {
            // catching....
        }

        try {
            for (Method method : m) {
                if (method.isAnnotationPresent(IsActive.class)) {
                    IsActive anno = method.getAnnotation(IsActive.class);
                    boolean value = anno.active();
                    if (value) {
                        MSet.add(method.getName());
                    }
                }
            }
            for (String value : MSet) {
                System.out.println(value);
            }
        } catch (TypeNotPresentException e) {
            // catching....
        }

    }

}
