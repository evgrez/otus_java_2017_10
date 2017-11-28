import java.util.ArrayList;

public class ATM extends AbstractATM {
    ArrayList<BankCell> bankCells;

    public ATM(ArrayList<BankCell> bankCells) {
        this.bankCells = bankCells;
    }

    @Override
    boolean takeBankNote(BankNote b) {
        return false;
    }

    @Override
    boolean getBankNote(int m) {
        return false;
    }

    @Override
    int getBalance() {
        return 0;
    }
}
