package ru.otus.evgrez.task_6_1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<BankCell> bankCells = new ArrayList<>();
        BankCell b;
        b = new BankCell(new BankNote(NameBankNote.BANKNOTE_5000),100,1000);
        bankCells.add(b);
        b = new BankCell(new BankNote(NameBankNote.BANKNOTE_1000),100,1000);
        bankCells.add(b);
        b = new BankCell(new BankNote(NameBankNote.BANKNOTE_500),1000,1000);
        bankCells.add(b);
        b = new BankCell(new BankNote(NameBankNote.BANKNOTE_100),10000,10000);
        bankCells.add(b);

        //System.out.println(bankCells);
        //Collections.sort(bankCells);

        ATM atm = new ATM(bankCells);
        System.out.println(atm);

        System.out.println(atm.getBalance());
        atm.takeBankNote(new BankNote(NameBankNote.BANKNOTE_5000));
        atm.takeBankNote(new BankNote(NameBankNote.BANKNOTE_5000));
        atm.takeBankNote(new BankNote(NameBankNote.BANKNOTE_5000));

        System.out.println(atm.getBalance());
        System.out.println(atm);

        atm.getBankNote(1000);
        System.out.println(atm.getBalance());
//        //System.out.println(atm);

        atm.getBankNote(190);
        System.out.println(atm.getBalance());

        atm.getBankNote(1900);
        System.out.println(atm.getBalance());

    }
}
