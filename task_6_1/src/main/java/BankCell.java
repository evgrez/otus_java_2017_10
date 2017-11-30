public class BankCell implements Comparable{
   private BankNote bankNote;
   private int count;
   private int maxCount;
   private int sum;

    public BankCell(BankNote bankNote, int count, int maxCount) {
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
        return (this.count<this.maxCount) ;
    }

    public int add(){
        if (!checkFree()){
            throw new ArithmeticException();
        }
        this.count++;
        computeSum();
        return this.count;
    }

    public int delete(){
        this.count--;
        computeSum();
        return this.count;
    }

    private void computeSum(){
        this.sum=this.count*this.bankNote.getValue();
    }

    @Override
    public int compareTo(Object o) {
        return this.bankNote.compareTo(((BankCell)o).bankNote);
    }

    @Override
    public String toString() {
        return "BankCell{\n" +
                "bankNote=" + bankNote +"\n"+
                ", count=" + count +"\n"+
                ", maxCount=" + maxCount +"\n"+
                ", sum=" + sum +"\n"+
                '}';
    }
}
