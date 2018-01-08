package ru.otus.evgrez.task51.testclasess;

public class TestClass {
    private int a = 0;
    private String s = "";

    public TestClass() {
    }

    public TestClass(Integer a) {
        this.a = a;
    }

    TestClass(Integer a, String s) {
        this.a = a;
        this.s = s;
    }

    int getA() {
        return a;
    }

    String getS() {
        return s;
    }

    private void setDefault(){
        a = 0;
        s = "";
    }
}
