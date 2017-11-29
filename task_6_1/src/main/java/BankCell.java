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
        this.count++;
        this.sum=this.count*this.bankNote.getValue()+this.sum;
        return this.count;
    }

    @Override
    public int compareTo(Object o) {
        return this.bankNote.compareTo(o);
    }

}
