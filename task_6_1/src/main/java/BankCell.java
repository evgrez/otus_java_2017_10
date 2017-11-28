public class BankCell implements Comparable{
   private BankNote bankNote;
   private int count;
   private int maxCount;

    public BankCell(BankNote bankNote, int count, int maxCount) {
        this.bankNote = bankNote;
        this.count = count;
        this.maxCount = maxCount;
    }

    public BankNote getBankNote() {
        return bankNote;
    }

    public void setBankNote(BankNote bankNote) {
        this.bankNote = bankNote;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }
    public boolean checkFree(){
        return (this.count<this.maxCount) ;
    }
    public int add(){
        return this.count++;
    }
    @Override
    public int compareTo(Object o) {
        return this.bankNote.compareTo(((BankCell)o).bankNote);
    }
}
