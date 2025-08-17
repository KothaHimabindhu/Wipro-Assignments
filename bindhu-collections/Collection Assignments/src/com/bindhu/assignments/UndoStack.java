package com.bindhu.assignments;

import java.util.Scanner;
import java.util.Stack;

public class UndoStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<>();
        System.out.println("Enter 3 commands:");
        for (int i = 0; i < 3; i++) {
            stack.push(sc.nextLine());
        }
        System.out.println("Current Stack: " + stack);
        String undone = stack.pop();
        System.out.println("Undo: " + undone);
        System.out.println("Stack after undo: " + stack);
        Stack<String> redoStack = new Stack<>();
        redoStack.push(undone);
        while (!redoStack.isEmpty()) {
            stack.push(redoStack.pop());
        }
        System.out.println("Stack after redo: " + stack);

        sc.close();
    }
}
