package ru.otus.evgrez;

public class MyClass implements Measurable {
    private int i = 0;
    private long l = 1;

    @Override
    public Object copyObject() throws ExCopyObject {
        try {
            return MyClass.class.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new ExCopyObject(e);
        }

    }
}
