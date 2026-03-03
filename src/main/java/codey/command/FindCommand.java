package codey.command;

import codey.task.TaskList;
import codey.ui.Ui;
import codey.storage.Storage;
import codey.exception.CodeyException;
import java.util.ArrayList;

/**
 * Represents a command to search for tasks that contains
 * a specific keyword
 */

public class FindCommand extends Command {
    private final String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Executes the find command by searching TaskList and printing results
     * @param tasks The list of tasks to search through
     * @param ui The user interface to handle output display
     * @param storage The storage component (not used for this command)
     * @throws CodeyException If error occurs during execution
     */
    @Override
    public void execute (TaskList tasks, Ui ui, Storage storage) throws CodeyException {
        ArrayList<String> matchingTasks = tasks.findTask(keyword);
        ui.printFoundTasks(matchingTasks);
    }
}
