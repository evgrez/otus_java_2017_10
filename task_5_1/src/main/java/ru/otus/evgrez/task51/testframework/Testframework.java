package ru.otus.evgrez.task51.testframework;

import ru.otus.evgrez.task51.annotations.*;
//import javax.print.DocFlavor;
import java.lang.reflect.Method;
import java.util.Set;

public class Testframework {
    private Testframework() {}
    public static void startClass(String className) throws ClassNotFoundException {
        startClass(Class.forName(className));
    }

    public static void startClass(Class className){
        Set<Method> methodsBefore = ReflectionHelper.getMethodsAnnotated(className, Before.class);
        Set<Method> methodsAfter = ReflectionHelper.getMethodsAnnotated(className, After.class);
        Set<Method> methodsTest= ReflectionHelper.getMethodsAnnotated(className, Test.class);

        for (Method methodTest: methodsTest) {
            for (Method methodBefore: methodsBefore) {
                ReflectionHelper.callMethod(ReflectionHelper.instantiate(className),methodBefore.getName());
            }

            ReflectionHelper.callMethod(ReflectionHelper.instantiate(className),methodTest.getName());

            for (Method methodAfter: methodsAfter) {
                ReflectionHelper.callMethod(ReflectionHelper.instantiate(className),methodAfter.getName());
            }
        }
    }
    private static String colorFont="\u001B[31m"; // "\u001B[31m" - red

    public static void assertEquals(long expected, long actual) {
        if (expected != actual) {
            failNotEquals(new Long(expected).toString(), new Long(actual).toString());
        }
    }

    public static void assertEquals(String expected, String actual) {
        if (expected==null & expected==null) {
            return;
        }
        if (expected==null || actual==null || expected.equals(actual)==false ) {
            failNotEquals(expected, actual);
        }
    }

    public static void assertTrue(boolean condition) {
        if (!condition) {
            failNotEquals(new Boolean(true).toString(), new Boolean(condition).toString());
        }
    }

    public static void assertFalse(boolean condition) {
        if (!condition) {
            failNotEquals(new Boolean(false).toString(), new Boolean(condition).toString());
        }
    }

    public static void assertNull(Object object) {
        if (object != null) {
            failNotEquals(object.toString(), "null");
        }
    }

    public static void assertNotNull(Object object) {
        if (object == null) {
            failNotEquals(object.toString(), "not null");
        }
    }

    private static void failNotEquals(String arg1, String arg2){
        String s1=arg1;
        String s2=arg2;
        if (s1==null) s1="null";
        if (s2==null) s2="null";
        fail(s1+" не равен " + s2);
    }

    private static void fail(String message) {
        System.out.println(colorFont + message);
    }

    public static void main(String[] args) {
        fail("test");
        fail("");
        failNotEquals("asd", null);
    }
}
