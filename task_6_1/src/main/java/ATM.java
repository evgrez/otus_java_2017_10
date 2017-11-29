import java.util.ArrayList;
import java.util.Collections;

public class ATM implements AbstractATM {
    private ArrayList<BankCell> bankCells;
    private int minBankNote;
    private int sum;

    public ATM(ArrayList<BankCell> bankCells) {
        this.bankCells = bankCells;
        Collections.sort(bankCells);
    }


    @Override
    public boolean takeBankNote(BankNote b) {
        for (int i = 0; i < this.bankCells.size(); i++) {
            BankCell tmpCell=bankCells.get(i);
          if(tmpCell.getBankNote().equals(b) & tmpCell.checkFree()){
                tmpCell.add();
              System.out.println("банкнота добавлена");
              return true;
          }
        }
        System.out.println("банкнота не добавлена: ячейки заполнены");
        return false;
    }

    @Override
    public boolean getBankNote(int summa) {
        if (getBalance()==0){
            System.out.println("Денег неt");
            return false;
        }
        if (summa<getMinBankNote().getValue()){
            System.out.println("Минальная купюра в банкомате"+getMinBankNote().toString());
            return false;
        }
        if (summa>getBalance()){
            System.out.println("Денег недостачно");
            return false;
        }

        //while
        for (int i = 0; i < this.bankCells.size(); i++) {
            BankCell tmpCell=bankCells.get(i);
            //if tmpCell.
        }
        return false;
    }

    @Override
    public int getBalance() {
        int sum=0;
        for (int i = 0; i < this.bankCells.size(); i++) {
            sum=sum+bankCells.get(i).getSum();
        }
        return 0;
    }

    public BankNote getMinBankNote() {
        for (int i = 0; i < this.bankCells.size(); i++) {
            if (bankCells.get(i).getCount()>0){
                return bankCells.get(i).getBankNote();
            }
        }
        throw new IllegalArgumentException();
    }
}
