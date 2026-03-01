package codey.command;

import codey.task.TaskList;
import codey.task.Todo;
import codey.ui.Ui;
import codey.storage.Storage;
import codey.exception.CodeyException;

public class AddTodoCommand extends Command {
    private final String description;

    public AddTodoCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws CodeyException {
        Todo todo = new Todo(description);
        tasks.addTask(todo);
        ui.printAdded(tasks);
    }
}
