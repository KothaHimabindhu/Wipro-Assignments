package com.bindhu.assignments;

import java.util.concurrent.ArrayBlockingQueue;

public class PrintManager {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> printQueue = new ArrayBlockingQueue<>(3);
        String[] jobs = {"Job1", "Job2", "Job3", "Job4", "Job5"};

        for (String job : jobs) {
            if (!printQueue.offer(job)) {
                System.out.println("Queue full! Skipping: " + job);
            } else {
                System.out.println("Added: " + job);
            }
        }
        while (!printQueue.isEmpty()) {
            String job = printQueue.poll();
            System.out.println("Printing: " + job);
            Thread.sleep(1000); 
        }
    }
}
