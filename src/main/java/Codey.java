import codey.exception.CodeyException;
import codey.task.TaskList;
import codey.ui.Parser;
import codey.ui.Ui;
import codey.storage.Storage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Codey {
    public static final String FILE_PATH = "data/Codey.txt";
    private static final TaskList taskList = new TaskList();
    private static final Ui ui = new Ui();
    private static final Storage storage = new Storage(FILE_PATH);

    public static void main(String[] args) {
        try {
            storage.load(taskList);
        } catch (FileNotFoundException e) {
            System.out.println("No previous data found! Starting fresh!");
        } catch (CodeyException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Save file is corrupted!");
        }

        ui.printWelcome();
        boolean isRunning = true;

        while (isRunning) {
            try {
                String input = ui.getCommand();
                if (input.equalsIgnoreCase("bye")) {
                    try {
                        storage.save(taskList);
                    } catch (IOException e) {
                        System.out.println("Warning: Could not save the following task(s) " + e.getMessage());
                    }
                    ui.printExit();
                    isRunning = false;
                } else {
                    Parser.parseAndExecute(input, taskList, ui);
                }
            } catch (CodeyException e) {
                ui.echo(e.getMessage());
            }
        }
    }
}
