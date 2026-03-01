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

    @Override
    public void execute (TaskList tasks, Ui ui, Storage storage) throws CodeyException {
        tasks.unmarkTask(index);
        ui.printUnmark(tasks);
    }
}
