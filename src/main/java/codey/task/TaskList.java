package codey.task;

import java.util.ArrayList;
import codey.exception.CodeyException;

/**
 * Represents a list of tasks and provides methods to each task
 */
public class TaskList {
    private final ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<Task>();
    }

    /**
     * Adds a task to the TaskList
     * @param task The task to be added
     * @throws CodeyException if the task is null
     */
    public void addTask(Task task) throws CodeyException {
        if (task == null) {
            throw new CodeyException("Task does not exist!");
        }
        tasks.add(task);
    }

    /**
     * Removes a task from the TaskList
     * @param index The 0-based index of the task to be removed
     * @throws CodeyException If the index is out of bounds
     */
    public void removeTask(int index) throws CodeyException {
        if (index < 0 ) {
            throw new CodeyException("Index cannot be zero or negative!");
        }
        if (index >= tasks.size()) {
            throw new CodeyException("Index cannot be greater than list size!");
        }
        tasks.remove(index);
    }

    /**
     * Searches for tasks containing the keyword and returns them as
     * formatted strings with their original 1-based index
     * @param keyword The term to look for in the descriptions of each task
     * @return An ArrayList of strings formatted with "index. [description]"
     * @throws CodeyException If searching fails to find matching tasks
     */
    public ArrayList<String> findTask(String keyword) throws CodeyException {
        ArrayList<String> matchingTasks = new ArrayList<>();
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                matchingTasks.add((i+1) + ". " + task.toString());
            }
        }
        return matchingTasks;
    }

    private void validateTask(int index) throws CodeyException {
        if (index < 0 || index >= tasks.size()) {
            throw new CodeyException("Invalid Index!");
        }
    }

    /**
     * Changes the status of the task to completed
     * @param index The 0-based index of the task to be marked
     * @throws CodeyException If the index is invalid or task is already marked
     */
    public void markTask(int index) throws CodeyException {
        validateTask(index);
        Task task = tasks.get(index);
        if (task.isDone()) {
            throw new CodeyException("Task " + (index + 1) + " is already marked!");
        }
        task.markDone();
    }

    /**
     * Changes the status of the task to incomplete
     * @param index The 0-based index of the task to be marked
     * @throws CodeyException If the index is invalid or task is already unmarked
     */
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
