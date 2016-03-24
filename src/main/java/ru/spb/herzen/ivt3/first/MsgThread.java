package ru.spb.herzen.ivt3.first;

public class MsgThread extends Thread {
    RandomNumThread randomNumThread;

    public MsgThread(RandomNumThread randomNumThread) {
        super();
        this.randomNumThread = randomNumThread;
    }

    public void run() {
        System.out.println("MsgThread started");
        while (!this.randomNumThread.isCompleted()) {
            System.out.println("MsgThread iteration");

            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
        }
    }
}