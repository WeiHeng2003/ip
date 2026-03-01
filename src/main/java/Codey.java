import codey.command.Command;
import codey.exception.CodeyException;
import codey.task.TaskList;
import codey.ui.Parser;
import codey.ui.Ui;
import codey.storage.Storage;
import java.io.FileNotFoundException;


public class Codey {
    public static final String FILE_PATH = "C:\\Users\\tanwe\\ip\\src\\data\\codey.txt";
    private final TaskList taskList;
    private final Ui ui;
    private final Storage storage;

    public Codey(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        taskList = new TaskList();
        try {
            storage.load(taskList);
        } catch (FileNotFoundException e) {
            System.out.println("No previous data found! Starting fresh!");
        } catch (CodeyException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Save file is corrupted!");
        }
    }

    public void run() {
        ui.printWelcome();
        boolean isExit = false;

        while (!isExit) {
            try {
                String input = ui.readCommand();
                Command c = Parser.parse(input);
                c.execute(taskList, ui, storage);
                isExit = c.isExit();
            } catch (CodeyException e) {
                ui.echo(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Codey(FILE_PATH).run();
    }
}
