package ru.otus.evgrez.task51.testframework;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

class ReflectionHelper<T> {
    private ReflectionHelper() {
    }

    static <T> T instantiate(Class<T> type, Object... args) {
        try {
            if (args.length == 0) {
                return type.newInstance();
            } else {
                Class<?>[] classes= toClasses(args);
                return type.getDeclaredConstructor(classes).newInstance(args);
            }
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    static Object getFieldValue(Object object, String name) {
        Field field = null;
        boolean isAccessible = true;
        try {
            field = object.getClass().getDeclaredField(name); //getField() for public fields
            isAccessible = field.isAccessible();
            field.setAccessible(true);
            return field.get(object);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            if (field != null && !isAccessible) {
                field.setAccessible(false);
            }
        }
        return null;
    }

    static void setFieldValue(Object object, String name, Object value) {
        Field field = null;
        boolean isAccessible = true;
        try {
            field = object.getClass().getDeclaredField(name); //getField() for public fields
            isAccessible = field.isAccessible();
            field.setAccessible(true);
            field.set(object, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            if (field != null && !isAccessible) {
                field.setAccessible(false);
            }
        }
    }

    static Object callMethod(Object object, String name, Object... args) {
        Method method = null;
        boolean isAccessible = true;
        try {
            method = object.getClass().getDeclaredMethod(name, toClasses(args));
            isAccessible = method.isAccessible();
            method.setAccessible(true);
            return method.invoke(object, args);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            if (method != null && !isAccessible) {
                method.setAccessible(false);
            }
        }
        return null;
    }

    static private Class<?>[] toClasses(Object[] args) {
        List<Class<?>> classes = Arrays.stream(args)
                .map(Object::getClass)
                .collect(Collectors.toList());
        return classes.toArray(new Class<?>[classes.size()]);
    }

    public static <T> Set<Method> getMethodsAnnotated(Class className, Class annotationName){
        Set<Method> methods = new HashSet<>();


        for (Method method:className.getDeclaredMethods()) {
            Annotation val=method.getAnnotation(annotationName);
                if (val!=null){
                    methods.add(method);
                };
        }
        return (methods.isEmpty()? Collections.EMPTY_SET: methods);
    }
}
