package ru.otus.evgrez.task71;

public class BankNote implements Comparable{
    private int value;

    public BankNote(NameBankNote name) {
        this.value=name.getValue();
        System.out.println(this.value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(Object obj) {
        return Integer.compare(this.value,((BankNote)obj).value);
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
