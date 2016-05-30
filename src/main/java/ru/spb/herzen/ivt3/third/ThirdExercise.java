package ru.spb.herzen.ivt3.third;

import java.util.Random;

public class ThirdExercise {
    public static void main(String[] args) {
        Man client = new Man("John", 1000000);
        Man client1 = new Man("Laura", 1000000);

        client.setFriend(client1);
        client1.setFriend(client);

        client.start();
        client1.start();

        while(client.isAlive());
        while(client1.isAlive());

        System.out.println(client.getName() + " money: " + client.money);
        System.out.println(client1.getName() + " money: " + client1.money);
    }
}

