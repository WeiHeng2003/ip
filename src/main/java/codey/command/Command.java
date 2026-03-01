package codey.command;

import codey.task.TaskList;
import codey.ui.Ui;
import codey.storage.Storage;
import codey.exception.CodeyException;

public abstract class Command {
    public abstract void execute(TaskList tasks, Ui ui, Storage storage)
            throws CodeyException;

    public boolean isExit() {
        return false;
    }
}
