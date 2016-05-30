package ru.spb.herzen.ivt3.second;

public class IntegerThread extends Thread {
    synchronized public void run(){
        for(Integer i=100; i<=1000; i++){
            System.out.println(i);
        }
    }
}