import java.util.Scanner;
import java.util.ArrayList;

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

    public String getCommand() {
        return scanner.nextLine().trim();
    }

    public void printAdded(boolean isAdded, TaskList tasks) {
        if (isAdded) {
            System.out.println("I have added a new task!");
            printList(tasks);
        } else {
            System.out.println("I cannot insert an empty task!");
        }
    }

    public void printRemoved(boolean isRemoved, TaskList tasks) {
        if (isRemoved) {
            System.out.println("I have removed the task!");
            printList(tasks);
        } else {
            System.out.println("Invalid index!");
        }
    }

    public void printList(TaskList tasks) {
        if (tasks.getSize() == 0) {
            System.out.println("List is empty!");
        } else {
            System.out.println("Here is your Task List!");
            for (int i = 0; i < tasks.getSize(); i++) {
                System.out.println((i+1) + ". " + tasks.getTask(i));
            }
        }
    }
}
