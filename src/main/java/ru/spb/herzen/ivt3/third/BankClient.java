package ru.spb.herzen.ivt3.third;

import ru.spb.herzen.ivt3.first.RandomNumThread;

import java.util.Random;

public class BankClient extends Thread {
    private Bank bank;
    private String name;
    private int depositNumber;
    private BankClient friend;

    private int spent;

    public int getSpent() {
        return spent;
    }

    public BankClient(String name, int money, Bank bank) {
        super();
        this.name = name;
        this.bank = bank;
        this.depositNumber = this.bank.createDeposit(money);


        System.out.println(this.name + " creates deposit, number is " + this.depositNumber);
    }

    public String getGivenName() {
        return this.name;
    }

    public int getDepositNumber() {
        return this.depositNumber;
    }

    public void setFriend(BankClient friend) {
        this.friend = friend;
    }

    public void status(){
        String message = String.format("==\n%s have %d and \n%s have %d\n==",
                this.name,
                this.bank.getMoney(this.getDepositNumber()),
                this.friend.getGivenName(),
                this.bank.getMoney(this.friend.getDepositNumber())
        );

        System.out.println(message);
    }

    public void sendMoney(int money) {
        String message = String.format("%s(%d) sends %d money to %s(%d)",
                this.name,
                this.getDepositNumber(),
                money,
                this.friend.getGivenName(),
                this.friend.getDepositNumber()
        );
        System.out.println(message);
        bank.moveMoney(this.depositNumber, this.friend.getDepositNumber(), money);
    }

    public void run() {
        Random random = new Random();
        int cycles = random.nextInt(100);

        for (int i = 0; i<cycles; i++){
            int money = random.nextInt(1000);
            this.spent += money;
            this.sendMoney(money);
            try {
                Thread.sleep(random.nextInt(200));
            } catch (Exception e) {

            }
        }
    }
}
