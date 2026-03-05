package codey.storage;

import codey.exception.CodeyException;
import codey.task.Task;
import codey.task.TaskList;
import codey.task.Event;
import codey.task.Todo;
import codey.task.Deadline;

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Storage {
    private final String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public void save(TaskList tasks) throws IOException {
        File file = new File (filePath);
        File parentDir = file.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs();
        }

        FileWriter fw = new FileWriter(file);
        for (int i = 0; i < tasks.getSize(); i++) {
            Task task = tasks.getTask(i);
            fw.write(task.toSaveString() + System.lineSeparator());
        }
        fw.close();
    }

    public void load(TaskList tasks) throws FileNotFoundException, CodeyException {
        File f = new File(filePath);
        if (!f.exists()) {
            throw new FileNotFoundException();
        }

        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            String line = s.nextLine();
            String[] parts = line.split(" \\| ");

            // takes in inputs and split into different parts
            String type = parts[0];
            boolean isDone = parts[1].equals("1");
            String description = parts[2];
            // parts 3 and 4 are for deadline /by and event /from /to

            Task task;
            switch (type) {
            case "T":
                task = new Todo(description);
                break;
            case "D":
                task = new Deadline(description, parts[3]);
                break;
            case "E":
                task = new Event(description, parts[3], parts[4]);
                break;
            default:
                continue; // skip any corrupted lines / wrongly formatted data
            }

            if (isDone) {
                task.markDone();
            }
            tasks.addTask(task);
        }
        s.close();
    }
}
