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

    /**
     * Executes the command by creating a new Event and adding it to the TaskList
     * @param tasks The TaskList to add the event into
     * @param ui The user interface to show the messages
     * @param storage The storage component
     * @throws CodeyException If adding the event fails
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws CodeyException {
        Event event = new Event(description, from, to);
        tasks.addTask(event);
        try {
            storage.save(tasks);
        } catch (java.io.IOException e) {
            ui.echo("Could not save data to file!");
        }
        ui.printAdded(tasks);
    }
}
