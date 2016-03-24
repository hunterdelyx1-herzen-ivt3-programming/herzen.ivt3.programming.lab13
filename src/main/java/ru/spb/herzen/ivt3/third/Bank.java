package ru.spb.herzen.ivt3.third;

import java.util.ArrayList;

public class Bank {
    ArrayList<Deposit> deposits = new ArrayList<Deposit>();

    public void createDeposit(){
        this.createDeposit(0);
    }

    public int createDeposit(int money){
        Deposit deposit = new Deposit(money);
        deposits.add(deposit);
        return deposits.indexOf(deposit);
    }

    public void moveMoney(int sender, int recipient, int money) {
        Deposit senderDeposit = deposits.get(sender);
        Deposit recipientDeposit = deposits.get(recipient);

        senderDeposit.deltaMoney(-money);
        recipientDeposit.deltaMoney(money);
    }

    public int getMoney(int depositNumber) {
        Deposit deposit = deposits.get(depositNumber);
        return deposit.getMoney();
    }
}
