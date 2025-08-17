package com.bindhu.assignments;

import java.util.LinkedList;
import java.util.Scanner;

public class RecentAppMemory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<String> apps = new LinkedList<>();

        System.out.println("Enter 5 app names (most recently opened apps will be at the top):");
        for (int i = 0; i < 5; i++) {
            String app = sc.nextLine();

            // If already opened, remove from current position
            if (apps.contains(app)) {
                apps.remove(app);
            }

            // Add to the top
            apps.addFirst(app);
        }

        System.out.println("Final recent apps list: " + apps);
        sc.close();
    }
}
