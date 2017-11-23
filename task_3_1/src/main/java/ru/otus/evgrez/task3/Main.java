package ru.otus.evgrez.task3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<Integer>(15);
        for (int i = 0; i < 30; i++) {
            list.add(i);
        }


        for (Integer i : list) {
            System.out.print(i+" ");
       }
        System.out.println();

        Collections.addAll(list, 1, 2, 3, 4);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }

        MyArrayList<Integer> newlist=new MyArrayList<>(list.size());
        Collections.copy(list,newlist);
        System.out.println("\n"+Arrays.toString(list.toArray()));

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        });
        System.out.println("\n"+Arrays.toString(list.toArray()));
    }
}