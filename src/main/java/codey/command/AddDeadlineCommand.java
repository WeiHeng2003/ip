package codey.command;

import codey.exception.CodeyException;
import codey.task.Deadline;
import codey.task.TaskList;
import codey.ui.Ui;
import codey.storage.Storage;

/**
 * Represents a command to add a new Deadline to the TaskList
 */
public class AddDeadlineCommand extends Command {
    private final String description;
    private final String by;

    public AddDeadlineCommand(String description, String by) {
        this.description = description;
        this.by = by;
    }

    /**
     * Executes the command by creating a new Deadline and adding it to the TaskList
     * @param tasks The TaskList to add the deadline into
     * @param ui The user interface to show the messages
     * @param storage The storage component
     * @throws CodeyException If adding the Deadline fails
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws CodeyException {
        Deadline deadline = new Deadline(description, by);
        tasks.addTask(deadline);
        try {
            storage.save(tasks);
        } catch (java.io.IOException e) {
            ui.echo("Could not save data to file!");
        }
        ui.printAdded(tasks);
    }
}
