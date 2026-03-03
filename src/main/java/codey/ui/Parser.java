package codey.ui;

import codey.command.Command;
import codey.command.FindCommand;
import codey.command.ExitCommand;
import codey.command.DeleteCommand;
import codey.command.ListCommand;
import codey.command.MarkCommand;
import codey.command.UnmarkCommand;
import codey.command.AddTodoCommand;
import codey.command.AddDeadlineCommand;
import codey.command.AddEventCommand;
import codey.exception.CodeyException;

/**
 * Parses user input into commands for Codey
 */
public class Parser {
    public static Command parse(String input) throws CodeyException {
        String[] words = input.split(" ", 2);
        String command = words[0].toLowerCase();

        switch (command) {
        case "bye":
            return new ExitCommand();
        case "list":
            return new ListCommand();
        case "mark":
            return new MarkCommand(parseIndex(words));
        case "unmark":
            return new UnmarkCommand(parseIndex(words));
        case "delete":
            return new DeleteCommand(parseIndex(words));
        case "todo":
            return parseTodo(words);
        case "deadline":
            return parseDeadline(words);
        case "event":
            return parseEvent(words);
        case "find":
            return parseFind(words);
        default:
            throw new CodeyException("Sorry, I don't know that command!");
        }
    }

    private static Command parseFind(String[] words) throws CodeyException {
        if (words.length < 2 || words[1].isBlank()) {
            throw new CodeyException("The keyword is empty");
        }
        return new FindCommand(words[1]);
    }

    private static int parseIndex(String[] words) throws CodeyException {
        if (words.length < 2) {
            throw new CodeyException("Task number is missing!");
        }
        try {
            return Integer.parseInt(words[1]) - 1;
        } catch (NumberFormatException e) {
            throw new CodeyException("Number is not valid!");
        }
    }

    private static Command parseTodo(String[] words) throws CodeyException {
        if (words.length < 2 || words[1].isBlank()) {
            throw new CodeyException("Todo description cannot be empty");
        }
        return new AddTodoCommand(words[1]);
    }

    private static Command parseDeadline(String[] words) throws CodeyException {
        if (words.length < 2 || !words[1].contains("/by")) {
            throw new CodeyException("Invalid Format! Try deadline [description] /by [when]");
        }
        String[] parts = words[1].split(" /by ", 2);
        return new AddDeadlineCommand(parts[0], parts[1]);
    }

    private static Command parseEvent(String[] words) throws CodeyException {
        if (words.length < 2 || !words[1].contains("/from") || !words[1].contains("/to")) {
            throw new CodeyException("Invalid Format! Try event [description] /from [when] /to [when]");
        }
        String[] parts = words[1].split(" /from | /to ", 3);
        return new AddEventCommand(parts[0], parts[1], parts[2]);
    }

}
