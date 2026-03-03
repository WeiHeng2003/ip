package codey.command;

import codey.task.TaskList;
import codey.ui.Ui;
import codey.storage.Storage;
import codey.exception.CodeyException;

public class ListCommand extends Command {
    /**
     * Executes the command by displaying all tasks in the Tasklist
     * @param tasks The TaskList to be printed
     * @param ui The User Interface to handle the printing of the TaskList
     * @param storage The storage component
     * @throws CodeyException If the TaskList cannot be printed
     */
    @Override
    public void execute (TaskList tasks, Ui ui, Storage storage) throws CodeyException {
        ui.printList(tasks);
    }
}
