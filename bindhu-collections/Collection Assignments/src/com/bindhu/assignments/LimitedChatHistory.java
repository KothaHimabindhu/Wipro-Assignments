package com.bindhu.assignments;

import java.util.ArrayDeque;
import java.util.Scanner;

public class LimitedChatHistory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<String> chat = new ArrayDeque<>();

        System.out.println("Enter chat messages (type 'exit' to stop):");

        while (true) {
            String msg = sc.nextLine();
            if (msg.equalsIgnoreCase("exit")) {
                break;
            }

            // Add new message
            chat.addLast(msg);

            // Keep only last 4 messages
            if (chat.size() > 4) {
                chat.removeFirst();
            }

            System.out.println("Current Chat: " + chat);
        }

        sc.close();
    }
}
