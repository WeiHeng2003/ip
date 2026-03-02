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

    public ArrayList<Task> findTask(String keyword) throws CodeyException {
        ArrayList<Task> matchingTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getDescription().contains(keyword)) {
                matchingTasks.add(task);
            }
        }
        return matchingTasks;
    }

    private void validateTask(int index) throws CodeyException {
        if (index < 0 || index >= tasks.size()) {
            throw new CodeyException("Invalid Index!");
        }
    }
    public void markTask(int index) throws CodeyException {
        validateTask(index);
        Task task = tasks.get(index);
        if (task.isDone()) {
            throw new CodeyException("Task " + (index + 1) + " is already marked!");
        }
        task.markDone();
    }

    public void unmarkTask(int index) throws CodeyException {
        validateTask(index);
        Task task = tasks.get(index);
        if (!task.isDone()) {
            throw new CodeyException("Task " + (index + 1) + " is already unmarked!");
        }
        task.unmarkDone();
    }

    public Task getTask(int index) {
        return tasks.get(index);
    }

    public int getSize() {
        return tasks.size();
    }
}
