package codey.command;

import codey.task.TaskList;
import codey.ui.Ui;
import codey.storage.Storage;
import codey.exception.CodeyException;

public class DeleteCommand extends Command {
    private final int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute (TaskList tasks, Ui ui, Storage storage) throws CodeyException {
        tasks.removeTask(index);
        ui.printRemoved(tasks, index);
    }
}
