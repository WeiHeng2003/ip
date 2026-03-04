# Codey User Guide
Codey is a program that can be used via a Command Line Interface (CLI) for managing tasks. Codey can help you track your to do, deadlines and events efficiently!

Quick Start
1. Ensure that you have Java 17 or above installed on your computer
2. Download the latest codey.jar from [here](https://github.com/WeiHeng2003/ip/releases/tag/A-Release)
3. Open a command terminal, navigate to the folder where the jar file is located and run ```java -jar codey.jar```
4. Codey will greet you with a welcome message
5. Type the command in the command box and press Enter to execute it, a list of commands can be found below.
6. To exit the app and save your data, use the command ```bye```

# Features
1. Words in UPPER_CASE are the parameters to be entered by the user.
   E.g. ```todo DESCRIPTION```
   DESCRIPTION is a parameter which can be used as ```todo read a book```
2. Parameters must be in the specified order.

<h2> Adding Todos:<h2> ```todo```
<h3> Format:<h3> ```todo DESCRIPTION```
- ```DESCRIPTION```: The details of the deadline.
   
<h3> Example:<h3> ```todo Tidy room```
### Expected Output:  
   
```
I have added a new task!
_______________________________________________________
Here is your Task List!
1. [T][ ] Tidy room
_______________________________________________________
```

<h2> Adding deadlines:<h2> ```deadline```
<h3> Format:<h3> ```deadline DESCRIPTION /by WHEN```
- ```DESCRIPTION```: The details of the deadline.
- ```WHEN```: The date or time the task is due.
   
<h3> Example:<h3> ```deadline Return book /by Sunday```
### Expected Output:  
   
```
I have added a new task!
_______________________________________________________
Here is your Task List!
1. [D][ ] Return book (by: Sunday)
_______________________________________________________
```

<h2> Adding events:<h2> ```event```
<h3> Format:<h3> ```event DESCRIPTION /from FROM /to TO```
- ```DESCRIPTION```: The details of the event.
- ```FROM```: The start date or time of the event.  
- ```TO```: The end date or time of the event.
   
<h3> Example:<h3> ```event Birthday Part /from 2pm /to 5pm```
### Expected Output:  
   
```
I have added a new task!
_______________________________________________________
Here is your Task List!
1. [E][ ] Birthday Part (from: 2pm to: 5pm)
_______________________________________________________
```

<h2> Finding tasks:<h2> ```find```
- The search is case-insensitive. E.g. ```book``` will match ```Book```.
- Only the description can be searched (date, index or task type cannot).
<h3> Format:<h3> ```find KEYWORD```
- ```KEYWORD```: The details of the task to be searched.
   
### Example:
### Adding an event:
```
event Birthday Part /from 2pm /to 5pm
```

### Expected Output:  
```
I have added a new task!
_______________________________________________________
Here is your Task List!
1. [E][ ] Birthday Part (from: 2pm to: 5pm)
_______________________________________________________
```

### Adding a deadline:
```
deadline Homework /by today 2359
```

### Expected Output: 
```
I have added a new task!
_______________________________________________________
Here is your Task List!
1. [E][ ] Birthday Part (from: 2pm to: 5pm)
2. [D][ ] Homework (by: today 2359)
_______________________________________________________
```

### Finding birthday:
```
find birthday
```

### Expected Output:
```
_______________________________________________________
Here are the matching tasks in the list:
1. [E][ ] Birthday Part (from: 2pm to: 5pm)
_______________________________________________________
```

<h2> Marking or Unmarking Tasks:<h2> ```mark``` OR ```unmark```
<h3> Format:<h3> ```mark INDEX``` or ```unmark INDEX```
- ```index```: The index number shown in the displayed task list

### Example:
### Adding a deadline:
```
deadline Homework /by today 2359
```
   
### Expected Output:  
```
I have added a new task!
_______________________________________________________
Here is your Task List!
1. [D][ ] Homework (by: today 2359)
_______________________________________________________
```

### Marking the task: 
```
mark 1
```

### Expected Output:  
```
I have marked the task as done!
_______________________________________________________
Here is your Task List!
1. [D][X] Homework (by: today 2359)
_______________________________________________________
```

### Unmarking the task:
```
unmark 1
```

### Expected Output:
```
I have unmarked the task as done!
_______________________________________________________
Here is your Task List!
1. [D][ ] Homework (by: today 2359)
_______________________________________________________
```

<h2> Deleting Tasks:<h2> ```delete```
<h3> Format:<h3> ```delete INDEX``` 
- ```index```: The index number shown in the displayed task list
   
### Example:
### Adding a deadline:
```
deadline Homework /by today 2359
```

### Expected Output:   
```
I have added a new task!
_______________________________________________________
Here is your Task List!
1. [D][ ] Homework (by: today 2359)
_______________________________________________________
```

### Deleting a task:
```
delete 1
```

### Expected Output:
```
I have removed task 1
You have 0 task(s) left
_______________________________________________________
List is empty!
_______________________________________________________
```

<h2> Displaying the list:<h2> ```list```

### Example:
### Adding a deadline:
```
deadline Homework /by today 2359
```

### Expected Output:   
```
I have added a new task!
_______________________________________________________
Here is your Task List!
1. [D][ ] Homework (by: today 2359)
_______________________________________________________
```

### Displaying the list: 
```
list
```

### Expected Output:  
```
_______________________________________________________
Here is your Task List!
1. [D][ ] Homework (by: today 2359)
_______________________________________________________
```

<h2> Closing the program:<h2> ```bye```
- Exits and closes Codey, your tasks in the list are automatically saved to codey.txt 

### Example:
```
bye
```

### Expected Output:   
```
_______________________________________________________
Bye! See you again
_______________________________________________________
```

## FAQ
**Q**: How do I transfer data to another computer?
**A**: Install the app in another computer and overwrite the empty data file it creates with the file that contains the data from your previous computer.

## Command Summary
| Command  | Format Examples |
| -------- | --------------- |
| Todo | ```todo DESCRIPTION``` e.g. ```todo Tidy room``` |
| Deadline  | ```deadline DESCRIPTION /by WHEN``` e.g. ```deadline Return book /by Sunday```|
| Event  | ```event DESCRIPTION /from FROM /to TO``` e.g. ```event Birthday Part /from 2pm /to 5pm``` |
| Find  | ```find KEYWORD``` e.g. ```find birthday```  |
| Mark  | ```mark INDEX``` e.g. ```mark 1``` |
| Unmark  | ```unmark INDEX``` e.g. ```unmark 1``` |
| Delete  | ```delete INDEX``` e.g. ```delete 1``` |
| List  | ```list```|
| Bye  | ```bye```  |
