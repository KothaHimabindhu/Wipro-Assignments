package com.bindhu.assignments;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Last3Searches {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<String> searches = new ArrayDeque<>();

        System.out.println("Enter search terms (type 'exit' to stop):");
        while (true) {
            String term = sc.nextLine();
            if (term.equalsIgnoreCase("exit")) {
                break;
            }

            // Add new term to end
            searches.addLast(term);

            // If more than 3, remove oldest (front)
            if (searches.size() > 3) {
                searches.removeFirst();
            }

            System.out.println("Last searches: " + searches);
        }

        sc.close();
    }
}
