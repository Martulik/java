package Annotations;

// Написать аннотацию с целочисленным параметром. Создать класс, содержащий только приватные методы (3–4 шт.),
// аннотировать любые из них. Вызвать из другого класса все аннотированные методы столько раз, сколько указано
// в параметре аннотации.

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        ClassWithAnnotationMethods test = new ClassWithAnnotationMethods();
        doTask(test);
    }

    private static void doTask(ClassWithAnnotationMethods object) {
        try {
            checkMethods(object);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static void checkMethods(ClassWithAnnotationMethods object)
            throws InvocationTargetException, IllegalAccessException {
        for (Method method : object.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(NumberOfRepeats.class)) {
                int value = method.getAnnotation(NumberOfRepeats.class).value();
                callFunctions(object, method, value);
            }
        }
    }

    private static void callFunctions(ClassWithAnnotationMethods object, Method method, int value)
            throws InvocationTargetException, IllegalAccessException {
        method.setAccessible(true);
        for (int i = 0; i < value; ++i) {
            method.invoke(object);
        }
        System.out.println();
    }
}
