public class Parser {
    public static void parseAndExecute(String input, TaskList taskList, Ui ui) throws CodeyException{
        String[] words = input.split(" ", 2);
        String command = words[0].toLowerCase();

        switch (command) {
        case "todo":
            if (words.length < 2 || words[1].trim().isEmpty()) {
                throw new CodeyException("Please add a description for the todo!");
            }
            taskList.addTask(new Todo(words[1]));
            ui.printList(taskList);
            break;

        case "deadline":
            if (words.length < 2) {
                throw new CodeyException("Please add a description for the todo!");
            }
            if (!words[1].contains("/by")) {
                throw new CodeyException("Please follow the format! <description> /by <deadline>");
            }
            String[] Dparts = words[1].split(" /by ", 2);
            taskList.addTask(new Deadline(Dparts[0], Dparts[1]));
            ui.printList(taskList);
            break;

        case "event":
            if (words.length < 2) {
                throw new CodeyException("Please add a description for the event!");
            }
            if (!words[1].trim().contains("/from") || !words[1].trim().contains("/to")) {
                throw new CodeyException("Please follow the format! <description> /from <start> /to <end>");
            }
            String[] eParts = words[1].split(" /from ", 2);
            String[] from_to = eParts[1].split(" /to ", 2);
            taskList.addTask(new Event(eParts[0], from_to[0], from_to[1]));
            ui.printList(taskList);
            break;

        case "remove":
            int index = Integer.parseInt((input.substring(7).trim())) - 1;
            taskList.removeTask(index);
            ui.printList(taskList);
            break;

        case "list":
            ui.printList(taskList);
            break;

        case "mark":
            int markIndex = Integer.parseInt(words[1]) - 1;
            taskList.markTask(markIndex);
            ui.printMark(taskList);
            break;

        case "unmark":
            int unmarkIndex = Integer.parseInt(words[1]) - 1;
            taskList.unmarkTask(unmarkIndex);
            ui.printUnmark(taskList);
            break;

        default:
            ui.echo(input);
        }
    }
}
