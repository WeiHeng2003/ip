package codey.command;

import codey.exception.CodeyException;
import codey.task.Deadline;
import codey.task.TaskList;
import codey.ui.Ui;
import codey.storage.Storage;

public class AddDeadlineCommand extends Command{
    private final String description;
    private final String by;

    public AddDeadlineCommand(String description, String by) {
        this.description = description;
        this.by = by;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws CodeyException {
        Deadline deadline = new Deadline(description, by);
        tasks.addTask(deadline);
        ui.printAdded(tasks);
    }
}
