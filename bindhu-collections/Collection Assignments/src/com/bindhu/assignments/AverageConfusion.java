package com.bindhu.assignments;

import java.util.Scanner;

public class AverageConfusion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];
        
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
            if (numbers[i] < 10) {
                numbers[i] = numbers[i] * 2;
            }
        }
        
        int sum = 0;
        for (int num : numbers) sum += num;
        
        double average = (double) sum / numbers.length;
        System.out.println("Average: " + average);
        
        sc.close();
    }
}
