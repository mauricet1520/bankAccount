package com.tiy.practice;

/**
 * Created by crci1 on 12/14/2016.
 */
public class SampleThread implements Runnable {
    Day7Runner day7Runner = new Day7Runner();

    public void run() {
        System.out.println("Running " + Thread.currentThread().getId());

        try {
            while (true) {
                double newAmount = day7Runner.bank.listAccounts.get(0).getCurrentAmount() * 1.1;
                day7Runner.bank.listAccounts.get(0).setCurrentAmount(newAmount);

                System.out.println("Current amount is " + newAmount);
                Thread.sleep(10000);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        System.out.println("Done running " + Thread.currentThread().getId());
    }
}

