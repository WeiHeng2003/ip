package codey.command;

import codey.task.TaskList;
import codey.task.Todo;
import codey.ui.Ui;
import codey.storage.Storage;
import codey.exception.CodeyException;

/**
 * Represents a command to add a new Todo to the TaskList
 */
public class AddTodoCommand extends Command {
    private final String description;

    public AddTodoCommand(String description) {
        this.description = description;
    }

    /**
     * Executes the command by creating a new Todo and adding it to the TaskList
     * @param tasks The TaskList to add the todo task into
     * @param ui The user interface to show the messages
     * @param storage The storage component
     * @throws CodeyException If adding the Todo fails
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws CodeyException {
        Todo todo = new Todo(description);
        tasks.addTask(todo);
        ui.printAdded(tasks);
    }
}
