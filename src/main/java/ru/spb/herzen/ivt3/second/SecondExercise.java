package ru.spb.herzen.ivt3.second;

public class SecondExercise {
    public static void main(String[] args) {
        IntegerThread integerThread = new IntegerThread();
        IntegerThread integerThread1 = new IntegerThread();

        integerThread.start();
        integerThread1.start();
    }
}

