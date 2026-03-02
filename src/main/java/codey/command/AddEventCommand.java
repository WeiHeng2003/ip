package codey.command;

import codey.exception.CodeyException;
import codey.task.Event;
import codey.task.TaskList;
import codey.ui.Ui;
import codey.storage.Storage;

public class AddEventCommand extends Command {
    private final String description;
    private final String from;
    private final String to;

    public AddEventCommand(String description, String from, String to) {
        this.description = description;
        this.from = from;
        this.to = to;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws CodeyException {
        Event event = new Event(description, from, to);
        tasks.addTask(event);
        ui.printAdded(tasks);
    }
}
