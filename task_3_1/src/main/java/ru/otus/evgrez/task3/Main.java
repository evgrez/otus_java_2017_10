package ru.otus.evgrez.task3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
       System.out.println("Создаём список и заполняем элементами");
        MyArrayList<Integer> list = new MyArrayList<Integer>(15);
        for (int i = 0; i < 30; i++) {
            list.add(i);
        }
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println("----------");

        System.out.println("Проверяем работу foreach");
        for (Integer i : list) {
            System.out.print(i+" ");
       }
        System.out.println("\n----------");

        System.out.println("Проверяем работу addAll");
        Collections.addAll(list, 1, 2, 3, 4);
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println("\n----------");

        System.out.println("Проверяем работу sort");
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        });
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println("----------");

        System.out.println("Проверяем работу copy");
        MyArrayList<Integer> newlist = new MyArrayList<Integer>();
        Integer[] arr = {100, 200, 300};
        Collections.addAll(newlist, arr);
        Collections.copy(list, newlist);
        System.out.println(Arrays.toString(newlist.toArray()));
        System.out.println("----------");
    }
}
