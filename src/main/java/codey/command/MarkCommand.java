package codey.command;

import codey.task.TaskList;
import codey.ui.Ui;
import codey.storage.Storage;
import codey.exception.CodeyException;

public class MarkCommand extends Command {
    private final int index;

    public MarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute (TaskList tasks, Ui ui, Storage storage) throws CodeyException {
        tasks.markTask(index);
        ui.printMark(tasks);
    }
}
