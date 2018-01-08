package ru.otus.evgrez.task71;

public class BankNote implements Comparable<BankNote>{
    private int value;

    public BankNote(NameBankNote name) {
        this.value=name.getValue();
        System.out.println(this.value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(BankNote obj) {
        return Integer.compare(this.value,obj.value);
    }

    @Override
    public boolean equals(Object obj) {
        return (this.value==((BankNote)obj).value);
    }

    @Override
    public String toString() {
        return "BankNote{" +
                "value=" + value +
                '}';
    }
}
