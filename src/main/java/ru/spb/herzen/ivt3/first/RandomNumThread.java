package ru.spb.herzen.ivt3.first;

import java.util.Random;

public class RandomNumThread extends Thread {
    Semaphore semaphore;

    private boolean completed;

    public boolean isCompleted() {
        this.semaphore.enter();
        boolean completed = this.completed;
        this.semaphore.leave();
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.semaphore.enter();
        this.completed = completed;
        this.semaphore.leave();
    }

    public RandomNumThread(Semaphore semaphore) {
        super();
        this.semaphore = semaphore;
        this.completed = false;
    }

    public void run() {
        System.out.println("RandomNumThread started");
        Random random = new Random();
        Long randomNumber = Math.abs(random.nextLong() + 1000000000L) % 1000000000L;

        boolean prime = true;
        for (Long i = 2L; i < Math.sqrt(randomNumber) && prime; i++) {
            if (randomNumber % i == 0) prime = false;
            System.out.println("RandomNumThread: check number: " + i);

            try {
                Thread.sleep(2000 + random.nextInt(2000));
            } catch (Exception e) {

            }
        }

        System.out.println("\nRandom number is " + randomNumber);

        this.setCompleted(true);

        if (prime) System.out.println("It's a prime number");
        else System.out.println("It's not a prime number");

    }
}