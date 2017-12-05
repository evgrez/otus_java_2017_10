package ru.otus.evgrez.task_6_1;

public enum NameBankNote {
    BANKNOTE_100(100),
    BANKNOTE_500(500),
    BANKNOTE_1000(1000),
    BANKNOTE_2000(2000),
    BANKNOTE_5000(5000);
    private int value;

    private NameBankNote(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
