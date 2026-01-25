import java.util.Scanner;
import java.util.Arrays;

public class Codey {
    public static void main(String[] args) {
        String logo =
                "  ____          _           \n" +
                        " / ___|___   __| | ___ _   _ \n" +
                        "| |   / _ \\ / _` |/ _ \\ | | |\n" +
                        "| |__| (_) | (_| |  __/ |_| |\n" +
                        " \\____\\___/ \\__,_|\\___|\\__, |\n" +
                        "                        |___/ \n";
        System.out.println("_______________________________________________________");
        System.out.println("Hello I'm\n" + logo);
        System.out.println("What can I do for you?");
        System.out.println("_______________________________________________________");

        
        Scanner input = new Scanner (System.in);

        while (true) {
            String line = input.nextLine();

            if (line.equalsIgnoreCase("bye")) {
                System.out.println("_______________________________________________________");
                System.out.println("Bye! See you again");
                System.out.println("_______________________________________________________");
                break;
            }
            else {
                System.out.println("_______________________________________________________");
                System.out.println(line);
                System.out.println("_______________________________________________________");
            }
        }
    }
}
