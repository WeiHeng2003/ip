package codey.task;

import java.util.ArrayList;
import codey.exception.CodeyException;

public class TaskList {
    private final ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<Task>();
    }

    public void addTask(Task task) throws CodeyException {
        if (task == null) {
            throw new CodeyException("Task does not exist!");
        }
        tasks.add(task);
    }

    public void removeTask(int index) throws CodeyException {
        if (index < 0 ) {
            throw new CodeyException("Index cannot be zero or negative!");
        }
        if (index >= tasks.size()) {
            throw new CodeyException("Index cannot be greater than list size!");
        }
        tasks.remove(index);
    }

    public void markTask(int index) throws CodeyException {
        if (index < 0 ) {
            throw new CodeyException("Index cannot be zero or negative!");
        }
        if (index >= tasks.size()) {
            throw new CodeyException("Index cannot be greater than list size!");
        }
        tasks.get(index).markDone();
    }

    public void unmarkTask(int index) throws CodeyException {
        if (index < 0 ) {
            throw new CodeyException("Index cannot be zero or negative!");
        }
        if (index >= tasks.size()) {
            throw new CodeyException("Index cannot be greater than list size!");
        }
        tasks.get(index).unmarkDone();
    }

    public Task getTask(int index) {
        return tasks.get(index);
    }

    public int getSize() {
        return tasks.size();
    }
}
