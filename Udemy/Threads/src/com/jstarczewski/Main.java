package com.jstarczewski;

public class Main {

    public static void main(String[] args) {
        // write your code here


        Countdown countdown1 = new Countdown();


        CountdownThread t1 = new CountdownThread(countdown1);
        t1.setName("Thread 1");
        CountdownThread t2 = new CountdownThread(countdown1);
        t2.setName("Thread 2");

        t1.start();
        t2.start();
    }
}


class Countdown {

    private int i;

    public void doCountdown() {

        String color;

        switch (Thread.currentThread().getName()) {
            case "Thread 1": {
                color = ThreadColor.ANSI_BLUE;
                break;
            }
            case "Thread 2": {
                color = ThreadColor.ANSI_RED;
                break;
            }
            default: {
                color = ThreadColor.ANSI_GREEN;
            }
        }
        synchronized (this) {
            for (i = 10; i > 0; i--) {
                System.out.println(color + Thread.currentThread().getName() + ": i = " + i);
            }
        }
    }

}

class CountdownThread extends Thread {

    private Countdown threadCountdown;

    public CountdownThread(Countdown threadCountdown) {
        this.threadCountdown = threadCountdown;
    }

    @Override
    public void run() {
        threadCountdown.doCountdown();
    }

}
