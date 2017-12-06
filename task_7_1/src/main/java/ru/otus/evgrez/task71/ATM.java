package ru.otus.evgrez.task71;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ATM {
    private ArrayList<ATMCell> atmCells;
    private Map<ATMCell,Integer> buffSumma = new HashMap<>();

    public ATM(ArrayList<ATMCell> atmCells) {
        this.atmCells = atmCells;
        Collections.sort(atmCells);
    }

    public boolean takeBankNote(BankNote b) {
        for (int i = 0; i < this.atmCells.size(); i++) {
            ATMCell tmpCell=atmCells.get(i);
            if(tmpCell.getBankNote().equals(b) && tmpCell.checkFree() ){
                System.out.println("банкнота "+b.getValue() +" добавлена");
                tmpCell.add();
                return true;
            }
        }
        System.out.println("Невозможно добавить банкноту "+b.getValue());
        return false;
    }

    public boolean getBankNote(int summa) {
        if (!checkGetBankNote(summa)) return false;
        buffSumma=computeBankNote(summa);
        if (buffSumma.isEmpty()) return false;

        buffSumma.forEach((k,v)->{k.delete(v);});
        System.out.println("сумма в "+ summa +" выдана");

        return true;
    }

    private Map<ATMCell,Integer> computeBankNote(int summa){
        Map<ATMCell,Integer> tmpMap = new HashMap<>();
        int cntBancNote;
        int tmpsumma=summa;
        for (int i = atmCells.size()-1; i >= 0; i--) {
            int v=atmCells.get(i).getBankNote().getValue();
            if (atmCells.get(i).getCount()<=0 || tmpsumma<v) {
                continue;
            }
            cntBancNote=tmpsumma/atmCells.get(i).getBankNote().getValue();
            if (cntBancNote>atmCells.get(i).getCount()){
                cntBancNote=atmCells.get(i).getCount();
            }
            tmpMap.put(atmCells.get(i),cntBancNote);
            tmpsumma=tmpsumma-atmCells.get(i).getBankNote().getValue()*cntBancNote;
            if (tmpsumma==0) return tmpMap;

        }
        System.out.println("Невозможно выдать не кратную сумму!");
        return Collections.EMPTY_MAP;
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
        return true;
    }

    public int getBalance() {
        int sum=0;
        for (int i = 0; i < this.atmCells.size(); i++) {
            sum=sum+atmCells.get(i).getSum();
        }
        return sum;
    }

    public BankNote getMinBankNote() {
        for (int i = 0; i < this.atmCells.size(); i++) {
            if (atmCells.get(i).getCount()>0){
                return atmCells.get(i).getBankNote();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        return "ATM{" +
                "atmCells=" + atmCells +
                '}';
    }
}
