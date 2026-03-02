package codey.command;

import codey.task.Task;
import codey.task.TaskList;
import codey.ui.Ui;
import codey.storage.Storage;
import codey.exception.CodeyException;

import java.util.ArrayList;

public class FindCommand extends Command {
    private final String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute (TaskList tasks, Ui ui, Storage storage) throws CodeyException {
        ArrayList<String> matchingTasks = tasks.findTask(keyword);
        ui.printFoundTasks(matchingTasks);
    }
}
