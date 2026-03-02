package codey.command;

import codey.task.TaskList;
import codey.ui.Ui;
import codey.storage.Storage;
import java.io.IOException;

public class ExitCommand extends Command {
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
