package ru.spb.herzen.ivt3.third;

public class Deposit {
    private int money;

    public Deposit(int money) {
        this.money = money;
    }

    public void deltaMoney(int money) {
        this.money += money;
    }

    public int getMoney() {
        return this.money;
    }
}
