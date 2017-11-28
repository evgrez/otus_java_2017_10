import java.util.ArrayList;
import java.util.Collections;

public class ATM extends AbstractATM {
    ArrayList<BankCell> bankCells;

    public ATM(ArrayList<BankCell> bankCells) {
        this.bankCells = bankCells;
        Collections.reverse(bankCells);
    }

    @Override
    boolean takeBankNote(BankNote b) {
        for (int i = 0; i < this.bankCells.size(); i++) {
            BankCell tmpCell=bankCells.get(i);
          if(tmpCell.compareTo(b)==0 & tmpCell.checkFree()){
                tmpCell.add();
              System.out.println("банкнота добавлена");
              return true;
          }
        }
        System.out.println("банкнота не добавлена: ячейки заполнены");
        return false;
    }

    @Override
    boolean getBankNote(int m) {
        //if m less min in bankCells then return false
        //if m more amount in bankCells then return false
        //if
        int tmpAmount=m;
        while
        for (int i = 0; i < this.bankCells.size(); i++) {
            BankCell tmpCell=bankCells.get(i);
            //if tmpCell.
        }
        return false;
    }

    @Override
    int getBalance() {
        return 0;
    }
}
