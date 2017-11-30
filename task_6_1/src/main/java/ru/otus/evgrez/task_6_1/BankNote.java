package ru.otus.evgrez.task_6_1;

public class BankNote implements Comparable{
    private int value;

    public BankNote(NameBankNote name) {
        switch (name)
        {
            case BANKNOTE_100:
                this.value = 100;
                break;
            case BANKNOTE_500:
                this.value = 500;
                break;
            case BANKNOTE_1000:
                this.value = 1000;
                break;
            case BANKNOTE_2000:
                this.value = 2000;
                break;
            case BANKNOTE_5000:
                this.value = 5000;
                break;
        }
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
