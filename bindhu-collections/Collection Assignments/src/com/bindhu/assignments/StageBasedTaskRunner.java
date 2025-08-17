package com.bindhu.assignments;
import java.util.concurrent.LinkedBlockingQueue;

class Task {
    private int id;
    private String description;

    public Task(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", description='" + description + '\'' + '}';
    }
}

public class StageBasedTaskRunner {
    private LinkedBlockingQueue<Task> stage1 = new LinkedBlockingQueue<>();
    private LinkedBlockingQueue<Task> stage2 = new LinkedBlockingQueue<>();

    public void addTask(Task task) throws InterruptedException {
        stage1.put(task);
    }

    public void processStages() {
        new Thread(() -> {
            try {
                while (true) {
                    Task task = stage1.take();
                    System.out.println("Processing Stage 1: " + task);
                    if (task.getId() % 2 == 0) {
                        stage2.put(task);
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
        new Thread(() -> {
            try {
                while (true) {
                    Task task = stage2.take();
                    System.out.println("Processing Stage 2: " + task);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }

    public static void main(String[] args) throws InterruptedException {
        StageBasedTaskRunner runner = new StageBasedTaskRunner();

        runner.processStages();

        runner.addTask(new Task(1, "Odd Task"));
        runner.addTask(new Task(2, "Even Task"));
        runner.addTask(new Task(3, "Another Odd"));
        runner.addTask(new Task(4, "Another Even"));
    }
}
