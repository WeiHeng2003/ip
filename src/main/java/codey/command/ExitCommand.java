package codey.command;

import codey.task.TaskList;
import codey.ui.Ui;
import codey.storage.Storage;
import java.io.IOException;

public class ExitCommand extends Command {
    /**
     * Execute the exit command and saves the data
     * @param tasks The TaskList to be saved
     * @param ui The user interface to display the exit message
     * @param storage The storage component to save the TaskList upon exit
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            storage.save(tasks);
        } catch (IOException e) {
            ui.echo("Could not save data");
        }
        ui.printExit();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
