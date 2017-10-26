package ru.otus.evgrez;

public class CalculatorSize {

    Measurable obj;
    int countRound;

    public CalculatorSize(Measurable obj, int countRound) {
        this.obj = obj;
        this.countRound = countRound;
    }

    public static long getSizeMemory(){
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }
    public double calcSize() throws ExCopyObject {
        System.gc();

        Object[] array = new Object[this.countRound];
        long memBegin = getSizeMemory();
        for (int i = 0; i < this.countRound; i++) {
            array[i] = this.obj.copyObject();
        }
        long memEnd = getSizeMemory()-memBegin ;
        double res = memEnd/this.countRound;
        return (res);
    }

}
