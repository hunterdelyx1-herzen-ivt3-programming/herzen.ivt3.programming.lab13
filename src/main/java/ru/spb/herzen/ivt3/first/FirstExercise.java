package ru.spb.herzen.ivt3.first;

public class FirstExercise {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore();

        RandomNumThread randomNumThread = new RandomNumThread(semaphore);
        MsgThread msgThread = new MsgThread(randomNumThread);

        msgThread.start();
        randomNumThread.start();
    }
}

