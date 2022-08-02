package com.Coding;

public class Threading {

        public static void main(String str[]) {
            final Object lock = new Object();
            new Thread(new Runnable() {
                public void run() {
                    synchronized (lock) {
                        try {
                            System.out.println("Wait thread1");
                            lock.wait();
                            System.out.println("Thread1 done");
                        } catch (Exception e) {
                        }
                    }
                }
            }).start();

            new Thread(new Runnable() {
                public void run() {
                    synchronized (lock) {
                        try {
                            System.out.println("Wait thread2");
                            lock.wait();
                            System.out.println("Thread2 done");
                        } catch (Exception e) {
                        }
                    }
                }
            }).start();

            try {
                Thread.sleep(1000);
                synchronized (lock) {
                    lock.notify();
                }
            } catch (Exception e) {

            }
        }
}
