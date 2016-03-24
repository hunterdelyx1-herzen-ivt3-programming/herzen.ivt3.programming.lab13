package ru.spb.herzen.ivt3.first;

public class Semaphore {
    private boolean flag;

    public Semaphore() {
        this.flag = false;
    }

    public void enter() {
        while(this.flag);
        this.flag = true;
    }

    public void leave() {
        this.flag = false;
    }
}
