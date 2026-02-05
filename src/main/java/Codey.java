public class Codey {
    private static final TaskList taskList = new TaskList();
    private static final Ui ui = new Ui();

    public static void main(String[] args) {
        ui.printWelcome();
        boolean isRunning = true;

        while (isRunning) {
            String input = ui.getCommand();
            String[] words = input.split(" ", 2);
            String command = words[0].toLowerCase();

            switch (command) {
            case "todo":
                taskList.addTask(new Todo(words[1]));
                ui.printList(taskList);
                break;

            case "deadline":
                String[] Dparts = words[1].split(" /by ", 2);
                taskList.addTask(new Deadline(Dparts[0],Dparts[1]));
                ui.printList(taskList);
                break;

            case "event":
                String[] eParts = words[1].split(" /from ", 2);
                String[] from_to = eParts[1].split(" /to ", 2);
                taskList.addTask(new Event(eParts[0], from_to[0], from_to[1]));
                ui.printList(taskList);
                break;

            case "bye":
                ui.printExit();
                isRunning = false;
                break;

            case "remove":
                try {
                    int index = Integer.parseInt((input.substring(7).trim())) - 1;
                    taskList.removeTask(index);
                    ui.printList(taskList);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please input a task number to remove!");
                } catch (IndexOutOfBoundsException e) {
                    ui.echo(e.getMessage());
                }
                break;

            case "show list":
                ui.printList(taskList);
                break;

            case "mark":
                try {
                    int markIndex = Integer.parseInt(words[1]) - 1;
                    taskList.markTask(markIndex);
                    ui.printMark(taskList);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please input a task number to mark!");
                } catch (IndexOutOfBoundsException e) {
                    ui.echo(e.getMessage());
                }
                break;

            case "unmark":
                try {
                    int unmarkIndex = Integer.parseInt(words[1]) - 1;
                    taskList.unmarkTask(unmarkIndex);
                    ui.printUnmark(taskList);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please input a task number to unmark!");
                } catch (IndexOutOfBoundsException e) {
                    ui.echo(e.getMessage());
                }
                break;

            default:
                ui.echo(input);
            }
        }
    }
}
