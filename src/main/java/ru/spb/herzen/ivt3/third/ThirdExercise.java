package ru.spb.herzen.ivt3.third;

public class ThirdExercise {
    public static void main(String[] args) {
        Bank bank = new Bank();

        int bankClientStart = 10000;
        int bankClient1Start = 1500;

        BankClient bankClient = new BankClient("John", bankClientStart, bank);
        BankClient bankClient1 = new BankClient("Laura", bankClient1Start, bank);

        bankClient.setFriend(bankClient1);
        bankClient1.setFriend(bankClient);

        bankClient.start();
        bankClient1.start();


        try {
            bankClient.join();
            bankClient1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        bankClient.status();

        System.out.println(bankClient.getGivenName() + " spent " + bankClient.getSpent());
        System.out.println(bankClient1.getGivenName() + " spent " + bankClient1.getSpent());

        System.out.println(Math.abs(bankClient.getSpent() - bankClient1.getSpent()));

        System.out.print(bankClientStart + " - " + bankClient.getSpent() + " + " + bankClient1.getSpent() + " = ");
        System.out.println(bankClientStart - bankClient.getSpent() + bankClient1.getSpent());
        System.out.print(bankClient1Start + " - " + bankClient1.getSpent() + " + " + bankClient.getSpent()  + " = ");
        System.out.println(bankClient1Start - bankClient1.getSpent() + bankClient.getSpent());
    }
}

