import java.util.Scanner;
import java.util.Arrays;

public class Codey {

    static Task[] list = new Task[100];
    static int size = 0;

    public static void printBorder() {
        System.out.println("_______________________________________________________");
    }

    public static void echo(String line) {
        printBorder();
        System.out.println(line);
        printBorder();
    }

    public static void addToList(String description) {
        Task task = new Task(description);
        list[size] = task;
        size++;

        printBorder();
        System.out.println("I have added this task: ");
        System.out.println(task);
    }

    public static void main(String[] args) {
        String logo =
                "  ____          _           \n" +
                        " / ___|___   __| | ___ _   _ \n" +
                        "| |   / _ \\ / _` |/ _ \\ | | |\n" +
                        "| |__| (_) | (_| |  __/ |_| |\n" +
                        " \\____\\___/ \\__,_|\\___|\\__, |\n" +
                        "                        |___/ \n";
        printBorder();
        System.out.println("Hello I'm\n" + logo);
        System.out.println("What can I do for you?");
        printBorder();


        Scanner input = new Scanner(System.in);

        while (true) {
            String line = input.nextLine();

            if (line.equalsIgnoreCase("bye")) {
                printBorder();
                System.out.println("Bye! See you again");
                printBorder();
                break;
            } else if (line.startsWith("add ")) {
                addToList(line.substring(4));
            } else if (line.startsWith("show list")) {
                printBorder();
                System.out.println("Here are the tasks in your list: ");
                for (int i = 0; i < size; i++) {
                    System.out.println(i + 1 + ". " + list[i]);
                }
                printBorder();
            } else if (line.startsWith("mark ")) {
                int taskNumber = Integer.parseInt(line.substring(5)) - 1;
                list[taskNumber].markDone();
                printBorder();
                System.out.println("Nice! I have marked this task as done: ");
                System.out.println(" " + list[taskNumber]);
            } else if (line.startsWith("unmark ")) {
                int taskNumber = Integer.parseInt(line.substring(7)) - 1;
                list[taskNumber].unmark();
                printBorder();
                System.out.println("I have unmarked this task : ");
                System.out.println(" " + list[taskNumber]);
            } else {
                echo(line);
            }
        }
    }
}
