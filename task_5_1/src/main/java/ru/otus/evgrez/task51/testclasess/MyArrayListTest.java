package ru.otus.evgrez.task51.testclasess;

import ru.otus.evgrez.task51.annotations.Before;
import ru.otus.evgrez.task51.annotations.Test;
import ru.otus.evgrez.task51.testframework.Testframework;

public class MyArrayListTest {

    @Test
    public void size() { //long
        MyArrayList<Integer> list = new MyArrayList<Integer>(15);
        for (int i = 0; i < 30; i++) {
            list.add(i);
        }
        Testframework.assertEquals(30,list.size());
    }

    @Test
    public void isEmpty_False() { //boolean
        MyArrayList<Integer> list = new MyArrayList<Integer>(15);
        Testframework.assertFalse(list.isEmpty());
    }

    @Test
    public void isEmpty_True() { //boolean
        MyArrayList<Integer> list = new MyArrayList<Integer>(15);
        Testframework.assertTrue(list.isEmpty());
    }


    @Test
    public void get() { // T
        MyArrayList<Integer> list = new MyArrayList<Integer>(15);
        for (int i = 0; i < 30; i++) {
            list.add(i);
        }
        Testframework.assertEquals(0,list.get(0));
    }

    @Test
    public void set() {
    }
}
