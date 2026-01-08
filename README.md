# Muller Chatbot User Guide

Welcome to Muller, your personal task management chatbot. Muller helps you manage your to-dos, deadlines, and events with ease. This guide will walk you through all the key features and commands you can use to interact with Muller.

# How to Interact with Muller

Input: Type a command into the text field and hit Enter or click the submit button.

Output: Muller will respond with the results of your command, including adding tasks, marking them as done, or listing tasks.

# Commands
## 1. todo
Adds a simple task without a deadline or specific time.
Format:
```
todo <task description>
```
example: 
```
todo Read a book'
```
Muller will respond:
```
Got it. I've added this task:
  [T][ ] Read a book
Now you have 1 task in the list.

```
## 2. deadline
Adds a task with a specific deadline.
Format:
```
deadline <task description> /by <yyyy-mm-dd>
```
example: 
```
deadline Return library book /by 2023-09-15
```
Muller will respond:
```
Got it. I've added this task:
  [D][ ] Return library book (by: Sep 15 2023)
Now you have 2 tasks in the list.
```
## 3. event
Adds a task that spans a time range (an event).
Format:
```
event <task description> /from <yyyy-mm-dd> /to <yyyy-mm-dd>
```
example: 
```
event Team project meeting /from 2023-09-10 /to 2023-09-11
```
Muller will respond:
```
Got it. I've added this task:
  [E][ ] Team project meeting (from: Sep 10 2023 to: Sep 11 2023)
Now you have 3 tasks in the list.
```
## 4. list
Displays all the tasks you have added.
Format:
```
list
```
Muller will respond:
```
Here are the tasks in your list:
1. [T][ ] Read a book
2. [D][ ] Return library book (by: Sep 15 2023)
3. [E][ ] Team project meeting (from: Sep 10 2023 to: Sep 11 2023)
```
## 5. mark/unmark
Marks a task as completed/not completed.
Format:
```
mark <task number>
unmark <task number>
```
example: (marking the first task)
```
mark 1
```
Muller will respond:
```
Nice! I've marked this task as done:
  [T][X] Read a book
```
## 6. delete
Removes a task from the list.
Format:
```
delete <task number>
```
example: deleting the second task
```
delete 2
```
Muller will respond:
```
Noted. I've removed this task:
  [D][ ] Return library book (by: Sep 15 2023)
```
## 7. find
Searches for tasks containing the given keyword.
Format:
```
find <keyword>
```
example: 
```
find book
```
Muller will respond:
```
Here are the matching tasks in your list:
1. [T][ ] Read a book
2. [D][ ] Return library book (by: Sep 15 2023)
```
## 8. on
Find the task that has the related date.
Format:
```
on <yyyy-mm-dd>
```
example: 
```
on 2023-09-15
```
Muller will respond:
```
Tasks on Sep 15 2023:
1. [D][ ] Return library book (by: Sep 15 2023)
```

## 10. remind
Remind the user about the tasks some days(specified by user) before deadline.
Format:
```
remind 3
```
Muller will respond:
```
Here are the tasks due in the next 3 days:
1. [D][ ] Return library book (by: Sep 15 2023)
```
## 11. bye
Exit the application.
Format:
```
bye
```
Muller will respond:
```
"Bye. Hope to see you again soon!"
```
and proceeds to exit the application after 2 seconds.

# Saving and Loading

Muller automatically saves your tasks to a file on your hard disk whenever the task list is updated (e.g., when you add, mark, or delete tasks). The tasks are loaded from the file each time you start the application, so you won't lose your progress.
