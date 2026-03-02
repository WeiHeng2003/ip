package codey.ui;

import java.util.ArrayList;
import java.util.Scanner;

import codey.task.Task;
import codey.task.TaskList;

public class Ui {
    private Scanner scanner;

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    public void printBorder() {
        System.out.println("_______________________________________________________");
    }

    public void echo(String input) {
        printBorder();
        System.out.println(input);
        printBorder();
    }

    public void printWelcome() {
        String logo =
                "  ____          _           \n" +
                        " / ___|___   __| | ___ _   _ \n" +
                        "| |   / _ \\ / _` |/ _ \\ | | |\n" +
                        "| |__| (_) | (_| |  __/ |_| |\n" +
                        " \\____\\___/ \\__,_|\\___|\\__, |\n" +
                        "                        |___/ \n";
        System.out.println("Hello I'm\n" + logo);
        System.out.println("What can I do for you?");
        printBorder();
    }

    public void printExit() {
        printBorder();
        System.out.println("Bye! See you again");
        printBorder();
    }

    public String readCommand() {
        return scanner.nextLine().trim();
    }

    public void printAdded(TaskList tasks) {
        System.out.println("I have added a new task!");
        printList(tasks);
    }

    public void printRemoved(TaskList tasks, int index) {
        System.out.println("I have removed task " + (index + 1));
        System.out.println("You have " + tasks.getSize() + " task(s) left");
        printList(tasks);
    }

    public void printList(TaskList tasks) {
        printBorder();
        if (tasks.getSize() == 0) {
            System.out.println("List is empty!");
        } else {
            System.out.println("Here is your Task List!");
            for (int i = 0; i < tasks.getSize(); i++) {
                System.out.println((i + 1) + ". " + tasks.getTask(i));
            }
        }
        printBorder();
    }

    public void printMark(TaskList taskList) {
        System.out.println("I have marked the task as done!");
        printList(taskList);
    }

    public void printUnmark(TaskList taskList) {
        System.out.println("I have unmarked the task as done!");
        printList(taskList);
    }

    public void printFoundTasks(ArrayList<Task> matchingTasks) {
        printBorder();
        if (matchingTasks.isEmpty()) {
            System.out.println("No tasks found");
        } else {
            System.out.println("Here are the matching tasks in the list:");
            for (int i = 0; i < matchingTasks.size(); i++) {
                System.out.println((i+1) + ". " + matchingTasks.get(i));
            }
        }
        printBorder();
    }
}
