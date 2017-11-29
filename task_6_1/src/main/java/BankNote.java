public abstract class BankNote implements Comparable{
    private int value;

    public BankNote(NameBankNote name) {
        switch (name)
        {
            case BANK_NOTE_100:
                this.value = 100;
                break;
            case BANK_NOTE_500:
                this.value = 500;
                break;
            case BANK_NOTE_1000:
                this.value = 1000;
                break;
            case BANK_NOTE_2000:
                this.value = 2000;
                break;
            case BANK_NOTE_5000:
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
