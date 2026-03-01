package codey.command;

import codey.task.TaskList;
import codey.ui.Ui;
import codey.storage.Storage;
import codey.exception.CodeyException;

public class ListCommand extends Command {

    @Override
    public void execute (TaskList tasks, Ui ui, Storage storage) throws CodeyException {
        ui.printList(tasks);
    }
}
