package fanshe;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Demo {
    private String name = "jj";
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Demo m = new Demo();
        Class<? extends Demo> aClass = m.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
        }
        Field field =aClass.getDeclaredField("name");
        field.setAccessible(true);
        Object o1 =field.get(m);
        System.out.println(o1);
    }
}
