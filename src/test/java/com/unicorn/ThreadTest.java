package com.unicorn;

import javafx.beans.binding.ObjectExpression;

public class ThreadTest {

    private static Object object = new Object();

    public static void testSynchronized1() {
        synchronized (object) {
            try {
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(1000);
                    System.out.println(String.format("T1%d", i));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void testSynchronized2() {
        synchronized (new Object()) {
            try {
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(1000);
                    System.out.println(String.format("T2%d", i));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void testSynchronized() {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    testSynchronized1();
                    testSynchronized2();
                }}).start();
        }
    }

    public static void main (String[] args) {
        testSynchronized();

    }
}
