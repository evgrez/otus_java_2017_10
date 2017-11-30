import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ATM {
    private ArrayList<BankCell> bankCells;
    private int minBankNote;
    private Map<BankCell,Integer> buffSumma = new HashMap<>();
    //private int sum;

    public ATM(ArrayList<BankCell> bankCells) {
        this.bankCells = bankCells;
        Collections.sort(bankCells);
    }

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

    public boolean getBankNote(int summa) {
        checkGetBankNote(summa);
        //while
//        for (int i = 0; i < this.bankCells.size(); i++) {
//            BankCell tmpCell=bankCells.get(i);
//            //if tmpCell.
//        }
        return true;
    }

    private boolean checkGetBankNote(int summa){
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

        buffSumma.clear();
        int cntBancNote;
        int tmpsumma=summa;
            for (BankCell bankCell: bankCells) {
                if (bankCell.getCount()<=0) continue;
                cntBancNote=tmpsumma/bankCell.getBankNote().getValue();
                buffSumma.put(bankCell,cntBancNote);
            }
            System.out.println(summa);


        return true;
    }

    public int getBalance() {
        int sum=0;
        for (int i = 0; i < this.bankCells.size(); i++) {
            sum=sum+bankCells.get(i).getSum();
        }
        return sum;
    }

    public BankNote getMinBankNote() {
        for (int i = 0; i < this.bankCells.size(); i++) {
            if (bankCells.get(i).getCount()>0){
                return bankCells.get(i).getBankNote();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        return "ATM{" + "\n"+
                "bankCells=" + bankCells +"\n"+
                ", minBankNote=" + minBankNote +"\n"+
                //", sum=" + sum +"\n"+
                '}';
    }
}
