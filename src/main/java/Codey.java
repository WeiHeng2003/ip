import codey.exception.CodeyException;
import codey.task.TaskList;
import codey.ui.Parser;
import codey.ui.Ui;

public class Codey {
    private static final TaskList taskList = new TaskList();
    private static final Ui ui = new Ui();

    public static void main(String[] args) {
        ui.printWelcome();
        boolean isRunning = true;

        while (isRunning) {
            try {
                String input = ui.getCommand();
                if (input.equalsIgnoreCase("bye")) {
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
