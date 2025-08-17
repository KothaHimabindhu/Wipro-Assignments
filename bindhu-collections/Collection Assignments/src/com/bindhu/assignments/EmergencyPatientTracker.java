package com.bindhu.assignments;
import java.util.Comparator;
import java.util.PriorityQueue;

class Patient {
    private String name;
    private int severity; 
    private long arrivalTime;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
        this.arrivalTime = System.currentTimeMillis();
    }

    public int getSeverity() {
        return severity;
    }

    public long getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public String toString() {
        return "Patient{" + "name='" + name + '\'' + ", severity=" + severity + '}';
    }
}

public class EmergencyPatientTracker {
    private PriorityQueue<Patient> queue;

    public EmergencyPatientTracker() {
        queue = new PriorityQueue<>(5, Comparator
                .comparingInt(Patient::getSeverity)
                .thenComparingLong(Patient::getArrivalTime));
    }

    public void addPatient(Patient patient) {
        if (queue.size() < 5) {
            queue.offer(patient);
        } else {
            System.out.println("Queue is full, cannot add: " + patient);
        }
    }

    public Patient treatPatient() {
        return queue.poll();
    }

    public static void main(String[] args) throws InterruptedException {
        EmergencyPatientTracker tracker = new EmergencyPatientTracker();

        tracker.addPatient(new Patient("Alice", 3));
        Thread.sleep(10);
        tracker.addPatient(new Patient("Bob", 1));
        Thread.sleep(10);
        tracker.addPatient(new Patient("Charlie", 2));
        tracker.addPatient(new Patient("David", 1));
        tracker.addPatient(new Patient("Eve", 5));
        tracker.addPatient(new Patient("Frank", 4)); 

        System.out.println("Treating: " + tracker.treatPatient());
        System.out.println("Treating: " + tracker.treatPatient());
    }
}
