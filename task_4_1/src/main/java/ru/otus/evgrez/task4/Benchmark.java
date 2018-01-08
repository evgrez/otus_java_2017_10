package ru.otus.evgrez.task4;

import java.util.ArrayList;
import java.util.Arrays;

public class Benchmark {
    ArrayList<Integer> list;

    void start(){
        list=new ArrayList<>();
        int cnt=0;
        while (cnt<20){
            for (int i=0; i<10_000; i++){
                list.add(new Integer(1));
            }
            Mytool.start();
            try {
                Thread.sleep(10000);
            }catch (InterruptedException e){
                Thread.currentThread().getStackTrace();
            }
            list.subList(0, 5000).clear();

//            for (int delCount = 0; delCount < 1000; delCount++) {
//                list.remove(1000);
//            }

            Mytool.start();
            Runtime runtime = Runtime.getRuntime();
            System.out.println("cnt="+ cnt++ +
                        " mem=" + (runtime.totalMemory()-runtime.freeMemory()) +
                        " size="+ list.size());
//            System.out.println(runtime.totalMemory()-runtime.freeMemory());
            System.out.println("--------------------------------------------------------");
        }
    }

}
