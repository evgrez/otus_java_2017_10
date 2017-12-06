package ru.otus.evgrez.task71;

public class ATMCell implements Comparable{
    private BankNote bankNote;
    private int count;
    private int maxCount;
    private int sum;

    public ATMCell(BankNote bankNote, int count, int maxCount) {
        if (count>maxCount) {
            throw new IllegalArgumentException();
        }

        this.bankNote = bankNote;
        this.count = count;

        this.maxCount = maxCount;
        this.sum=this.bankNote.getValue()*this.count;
    }

    public BankNote getBankNote() {
        return bankNote;
    }

    public int getCount() {
        return count;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        if (this.count>maxCount) {
            throw new IllegalArgumentException();
        }
        this.maxCount = maxCount;
    }

    public int getSum() {
        return sum;
    }

    public boolean checkFree(){
        return checkFree(1) ;
    }

    public boolean checkFree(int cnt){
        return ((this.count+cnt)<=this.maxCount) ;
    }

    public int add(){
        return add(1);
    }

    public int add(int cnt){
        if (!checkFree(cnt)){
            throw new IllegalArgumentException();
        }
        this.count=this.count+cnt;
        computeSum();
        return this.count;
    }

    public int delete(int cnt){
        if ((this.count-cnt)<0) throw new IllegalArgumentException();
        this.count=this.count-cnt;
        computeSum();
        return this.count;
    }

    private void computeSum(){
        this.sum=this.count*this.bankNote.getValue();
    }

    @Override
    public int compareTo(Object o) {
        return this.bankNote.compareTo(((ATMCell)o).bankNote);
    }

    @Override
    public String toString() {
        return "ATMCell{ " +
                "bankNote=" + bankNote +
                ", count=" + count +
                ", maxCount=" + maxCount +
                ", sum=" + sum +
                '}';
    }
}
