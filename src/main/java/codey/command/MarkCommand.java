package codey.command;

import codey.task.TaskList;
import codey.ui.Ui;
import codey.storage.Storage;
import codey.exception.CodeyException;

public class MarkCommand extends Command {
    private final int index;

    public MarkCommand(int index) {
        this.index = index;
    }

    /**
     * Executes the command by changing the status of the task to completed
     * @param tasks The task to be marked
     * @param ui The user interface to print the success message
     * @param storage The storage component
     * @throws CodeyException If the task cannot be found or is already marked
     */
    @Override
    public void execute (TaskList tasks, Ui ui, Storage storage) throws CodeyException {
        tasks.markTask(index);
        try {
            storage.save(tasks);
        } catch (java.io.IOException e) {
            ui.echo("Could not save data to file!");
        }
        ui.printMark(tasks);
    }
}
