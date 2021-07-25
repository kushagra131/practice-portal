package com.Practice;

import sun.tools.jconsole.Worker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MultiThreading extends Thread {

    @Override
    public void run() {
        System.out.println("Main " + Thread.currentThread().getName() + " is Running!!");
    }

    public static void main(String[] args) {
//        WorkerThread workerThread = new WorkerThread("Hello World");
//        MultiThreading mainThread = new MultiThreading();
//
//        Thread thread1 = new Thread(workerThread);
//        Thread thread2 = new Thread(mainThread);
//
//        thread1.start();
//        thread2.start();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for(int i=1; i<=10; i++) {
            Runnable worker = new WorkerThread("Worker " + i + " ");
            executor.execute(worker);
        }
        executor.shutdown();
        while(!executor.isTerminated()) { }
        System.out.println("Finished All Threads!!");
    }
}

class WorkerThread implements Runnable {
    private final String message;

    public WorkerThread(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        // System.out.println("Worker " + Thread.currentThread().getName() + " is Running!!");
        System.out.println("----  " + Thread.currentThread().getName() + "  STARTED  ----");
        System.out.println("Start: " + message);
        System.out.println("End: " + processMessage());
        System.out.println("----  " + Thread.currentThread().getName() + "  ENDED  ----" + "\n");
    }

    String processMessage() {
        StringBuilder sb = new StringBuilder(this.message);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return sb.append("Processed").toString();
    }
}