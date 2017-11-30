import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by user on 29.11.2017.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<BankCell> bankCells = new ArrayList<>();
        BankCell b;
        b = new BankCell(new BankNote(NameBankNote.BANK_NOTE_5000),100,1000);
        bankCells.add(b);
        b = new BankCell(new BankNote(NameBankNote.BANK_NOTE_1000),100,1000);
        bankCells.add(b);
        b = new BankCell(new BankNote(NameBankNote.BANK_NOTE_500),1000,1000);
        bankCells.add(b);
        b = new BankCell(new BankNote(NameBankNote.BANK_NOTE_100),10000,10000);
        bankCells.add(b);

        //System.out.println(bankCells);
        //Collections.sort(bankCells);

        ATM atm = new ATM(bankCells);
        System.out.println(atm);

        atm.takeBankNote(new BankNote(NameBankNote.BANK_NOTE_5000));
        atm.takeBankNote(new BankNote(NameBankNote.BANK_NOTE_5000));
        atm.takeBankNote(new BankNote(NameBankNote.BANK_NOTE_5000));

        System.out.println(atm.getBalance());
        System.out.println(atm);

        atm.getBankNote(100);

    }
}
