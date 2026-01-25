import java.util.Scanner;
import java.util.Arrays;

public class Codey {

    static String[] list = new String[100];
    static int size = 0;

    public static void printBorder() {
        System.out.println("_______________________________________________________");
    }

    public static void echo(String line) {
        printBorder();
        System.out.println(line);
        printBorder();
    }

    public static void addToList(String line) {
        list[size] = line;
        size++;
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

        
        Scanner input = new Scanner (System.in);

        while (true) {
            String line = input.nextLine();

            if (line.equalsIgnoreCase("bye")) {
                printBorder();
                System.out.println("Bye! See you again");
                printBorder();
                break;
            }
            else if (line.equalsIgnoreCase("list")) {
                printBorder();
                for (int i = 0; i < size; i ++) {
                    System.out.println(i+1 + ": " + list[i]);
                }
                printBorder();
            }
            else {
                addToList(line);
                echo(line);
            }
        }
    }
}
