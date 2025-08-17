package com.bindhu.assignments;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Job {
    String name;
    int urgency; 

    public Job(String name, int urgency) {
        this.name = name;
        this.urgency = urgency;
    }

    @Override
    public String toString() {
        return name + " (Urgency: " + urgency + ")";
    }
}

public class SmartJobPicker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Comparator<Job> jobComparator = Comparator
                .comparingInt((Job j) -> j.urgency)
                .thenComparingInt(j -> j.name.length());

        PriorityQueue<Job> jobs = new PriorityQueue<>(jobComparator);

        System.out.println("Enter 5 jobs with urgency (1-5):");
        for (int i = 0; i < 5; i++) {
            System.out.print("Job name: ");
            String name = sc.nextLine();
            System.out.print("Urgency (1-5): ");
            int urgency = Integer.parseInt(sc.nextLine());

            jobs.add(new Job(name, urgency));
        }

        System.out.println("\nJobs served in priority order:");
        while (!jobs.isEmpty()) {
            System.out.println(jobs.poll());
        }

        sc.close();
    }
}

