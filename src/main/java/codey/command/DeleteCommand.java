package codey.command;

import codey.task.TaskList;
import codey.ui.Ui;
import codey.storage.Storage;
import codey.exception.CodeyException;

/**
 * Represents a command to delete the Task from the TaskList
 */
public class DeleteCommand extends Command {
    private final int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    /**
     * Executes the command by deleting the Task from the TaskList
     * @param tasks The TaskList to remove the task from
     * @param ui The user interface to show the success message
     * @param storage The storage component
     * @throws CodeyException If adding the task fails
     */
    @Override
    public void execute (TaskList tasks, Ui ui, Storage storage) throws CodeyException {
        tasks.removeTask(index);
        try {
            storage.save(tasks);
        } catch (java.io.IOException e) {
            ui.echo("Could not save data to file!");
        }
        ui.printRemoved(tasks, index);
    }
}
