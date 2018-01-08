package ru.otus.evgrez;

public class Main {
    public static void main(String[] args) throws ExCopyObject {
//        System.out.println("pid: " + ManagementFactory.getRuntimeMXBean().getName());
        double res;
        CalculatorSize cs;
        Object[] params;
        System.out.println("Вычисляем размер \"new String()\"");
        cs = new CalculatorSize(new MeasSubject(String.class), 10_000_000);
        res=cs.calcSize();
        System.out.println(res);

        System.out.println("Вычисляем размер \"new String(\"1\")\"");
        params = new Object[]{"1"};
        cs = new CalculatorSize(new MeasSubject(String.class, params), 10_000_000);
        res=cs.calcSize();
        System.out.println(res);

        System.out.println("Вычисляем размер \"new String(new char[0])\"");
        params = new Object[]{new char[0]};
        cs = new CalculatorSize(new MeasSubject(String.class, params), 10_000_000);
        res=cs.calcSize();
        System.out.println(res);

        System.out.println("Вычисляем размер \"new MyClass\"");
        cs = new CalculatorSize(new MyClass(), 10_000_000);
        res=cs.calcSize();
        System.out.println(res);

        System.out.println("Вычисляем размер \"new MyClassN\"");
        cs = new CalculatorSize(new MeasSubject(MyClassN.class) , 10_000_000);
        res=cs.calcSize();
        System.out.println(res);

        System.out.println("Вычисляем размер \"new int(\"\")\"");
        params = new Object[]{"1"};
        cs = new CalculatorSize(new MeasSubject(Integer.class, new Object[]{"1"}), 10_000_000);
        res=cs.calcSize();
        System.out.println(res);
    }
}
