package ru.otus.evgrez.task71;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Создаем денежные ячейки для банкомата");
        ArrayList<ATMCell> bankCells = new ArrayList<>();
        ATMCell b;
        b = new ATMCell(new BankNote(NameBankNote.BANKNOTE_5000),100,1000);
        bankCells.add(b);
        b = new ATMCell(new BankNote(NameBankNote.BANKNOTE_1000),100,1000);
        bankCells.add(b);
        b = new ATMCell(new BankNote(NameBankNote.BANKNOTE_500),1000,1000);
        bankCells.add(b);
        b = new ATMCell(new BankNote(NameBankNote.BANKNOTE_100),10000,10000);
        bankCells.add(b);
//        System.out.println(bankCells);

        System.out.println("Создаем банкомат");
        ATM atm = new ATM(bankCells);
        System.out.println("Баланс банкомата = "+atm.getBalance());
        //System.out.println(atm);

        System.out.println("----------");

        System.out.println("Кладем деньги");
        atm.takeBankNote(new BankNote(NameBankNote.BANKNOTE_5000));
        atm.takeBankNote(new BankNote(NameBankNote.BANKNOTE_5000));
        atm.takeBankNote(new BankNote(NameBankNote.BANKNOTE_5000));
        atm.takeBankNote(new BankNote(NameBankNote.BANKNOTE_2000));
        System.out.println("Баланс банкомата = "+atm.getBalance());

        System.out.println("----------");

        System.out.println("Забираем деньги");
        atm.getBankNote(1000);
        System.out.println(atm.getBalance());

        atm.getBankNote(190);
        System.out.println(atm.getBalance());

        atm.getBankNote(1900);
        System.out.println(atm.getBalance());

        System.out.println("----------");
    }
}
