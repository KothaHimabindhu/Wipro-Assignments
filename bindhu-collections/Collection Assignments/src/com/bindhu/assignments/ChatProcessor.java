package com.bindhu.assignments;

import java.util.concurrent.LinkedBlockingQueue;

public class ChatProcessor {
    public static void main(String[] args) {
        LinkedBlockingQueue<String> messageQueue = new LinkedBlockingQueue<>(5);
        Thread producer = new Thread(() -> {
            String[] messages = {"Hi", "How are you?", "I'm fine", "Let's meet", "Bye", "See you!"};
            try {
                for (String msg : messages) {
                    if (messageQueue.remainingCapacity() == 0) {
                        System.out.println("Queue full! Waiting to add: " + msg);
                    }
                    messageQueue.put(msg); 
                    System.out.println("Sent: " + msg);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    String msg = messageQueue.take(); 
                    System.out.println("Received: " + msg);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();
    }
}
