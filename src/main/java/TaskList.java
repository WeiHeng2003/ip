import java.util.ArrayList;

public class TaskList {
    private final ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<Task>();
    }

    public void addTask(Task task) {
        if (task != null) {
            tasks.add(task);
        } else {
            throw new IllegalArgumentException("Invalid description!");
        }
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        } else {
            throw new IndexOutOfBoundsException("Task Number " + (index + 1) + " does not exist!");
        }
    }

    public void markTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markDone();
        } else {
            throw new IndexOutOfBoundsException("Task " + (index + 1) + " does not exist");
        }
    }

    public void unmarkTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).unmarkDone();
        } else {
            throw new IndexOutOfBoundsException("Task " + (index + 1) + " does not exist");
        }
    }

    public Task getTask(int index) {
        return tasks.get(index);
    }

    public int getSize() {
        return tasks.size();
    }
}
