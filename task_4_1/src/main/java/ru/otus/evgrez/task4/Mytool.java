package ru.otus.evgrez.task4;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

public class Mytool {
    public static long gcCount = 0;
    public static long gcTimeMillis = 0;

    public static void start() {
        List<GarbageCollectorMXBean> gcBeans =
                ManagementFactory.getGarbageCollectorMXBeans();
        long count = 0;
        long timeMillis = 0;
        for (GarbageCollectorMXBean gcBean : gcBeans) {
            System.out.println("getName="+gcBean.getName());
            System.out.println("gcBean.getCollectionCount()="+gcBean.getCollectionCount());
            System.out.println("gcBean.getCollectionTime()="+gcBean.getCollectionTime());
            System.out.println(gcBean.getMemoryPoolNames().toString());
//            count += gcBean.getCollectionCount();
//            timeMillis += gcBean.getCollectionTime();
        }

//        System.out.println("gcCount=" + (int)(count - gcCount));
//        System.out.println("gcTimeMillis=" + (int)(timeMillis - gcTimeMillis));
//        gcCount = count;
//        gcTimeMillis = timeMillis;

    }
    private static String getTypeGeneration(String memManager){
        String res="none";
        switch (memManager){
            case "Copy":
            case "PS Scavenge":
            case "ParNew":
            case "G1 Young Generation":
                res="young";

            case "MarkSweepCompact":
            case "PS MarkSweep":
            case "ConcurrentMarkSweep":
            case "G1 Old Generation":
                res="old";
            default: res="none";
        }
        return res;
    }
}