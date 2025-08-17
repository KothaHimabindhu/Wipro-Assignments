package com.bindhu.assignments;

import java.util.LinkedList;
import java.util.Scanner;

public class ReversedTaskQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<String> tasks = new LinkedList<>();
        
        System.out.println("Enter 4 tasks:");
        for (int i = 0; i < 4; i++) {
            String task = sc.nextLine();
            if (task.endsWith("!")) {
                tasks.addFirst(task);
            } else {
                tasks.add(task);
            }
        }
        
        System.out.println("Tasks in reverse order:");
        for (int i = tasks.size() - 1; i >= 0; i--) {
            System.out.println(tasks.get(i));
        }
        
        sc.close();
    }
}