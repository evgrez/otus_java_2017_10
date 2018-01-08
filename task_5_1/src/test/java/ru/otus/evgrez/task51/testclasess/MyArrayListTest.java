package ru.otus.evgrez.task51.testclasess;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyArrayListTest {

    @Test
    public void size() { //long
        MyArrayList<Integer> list = new MyArrayList<Integer>(15);
        for (int i = 0; i < 30; i++) {
            list.add(i);
        }

    }

    @Test
    public void isEmpty() { //boolean
    }

    @Test
    public void add() { //boolean
    }

    @Test
    public void get() { // T
    }

    @Test
    public void set() {
    }
}