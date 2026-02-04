import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;

public class Codey {
    private static final TaskList taskList = new TaskList();
    private static final Ui ui = new Ui();

    public static void main(String[] args) {
        ui.printWelcome();
        boolean isRunning = true;

        while (isRunning) {
            String input = ui.getCommand();

            if (input.equalsIgnoreCase("bye")) {
                ui.printExit();
                isRunning = false;
            } else if (input.startsWith("add ")) {
                taskList.addTask(input.substring(4));
                ui.printList(taskList);
            } else if (input.startsWith("remove ")) {
                try {
                    int index = Integer.parseInt((input.substring(7).trim())) - 1;
                    taskList.removeTask(index);
                    ui.printList(taskList);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please input a task number to remove!");
                } catch (IndexOutOfBoundsException e) {}
            } else if (input.startsWith("show list")) {
                ui.printList(taskList);
            } else {
                ui.echo(input);
            }
        }
    }
}
