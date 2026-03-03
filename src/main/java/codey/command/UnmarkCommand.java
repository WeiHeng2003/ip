package codey.command;

import codey.task.TaskList;
import codey.ui.Ui;
import codey.storage.Storage;
import codey.exception.CodeyException;

public class UnmarkCommand extends Command {
    private final int index;

    public UnmarkCommand(int index) {
        this.index = index;
    }

    /**
     * Executes the command by changing the status of the task to incomplete
     * @param tasks The task to be unmarked
     * @param ui The user interface to print the success message
     * @param storage The storage component
     * @throws CodeyException If the task cannot be found or is already unmarked
     */
    @Override
    public void execute (TaskList tasks, Ui ui, Storage storage) throws CodeyException {
        tasks.unmarkTask(index);
        ui.printUnmark(tasks);
    }
}
