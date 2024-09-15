package muller.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a task in the task list. A task can be a Todo, Deadline, or Event.
 */
public class Task {
    public static final DateTimeFormatter INPUT_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter OUTPUT_DATE_FORMATTER = DateTimeFormatter.ofPattern("MMM dd yyyy");

    private String name;
    private boolean isDone;
    private String type = "[ ]"; // [T], [D], [E]
    private LocalDate date; // For Deadline or Event start date
    private LocalDate endDate; // For Event end date

    /**
     * Constructs a Task object with the specified name.
     *
     * @param name The name of the task.
     */
    public Task(String name) {
        // Programmer-level assumption: description should never be null or empty
        assert name != null : "Task description should not be null";
        assert !name.trim().isEmpty() : "Task description should not be empty";

        this.name = name;
        this.isDone = false;
    }

    /**
     * Sets the type of the task (Todo, Deadline, or Event).
     *
     * @param type The type of the task, represented as a single character (T, D, E).
     */
    public void setType(String type) {
        this.type = "[" + type + "]";
    }

    /**
     * Sets the date for Deadline tasks.
     *
     * @param date The date to set.
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Sets the start and end dates for Event tasks.
     *
     * @param startDate The start date of the event.
     * @param endDate   The end date of the event.
     */
    public void setDateRange(LocalDate startDate, LocalDate endDate) {
        this.date = startDate;
        this.endDate = endDate;
    }

    /**
     * Marks the task as done.
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Marks the task as done or not done.
     *
     * @param isDone Whether the task is done.
     */
    public void markAsDone(boolean isDone) {
        this.isDone = isDone;
    }

    /**
     * Marks the task as not done.
     */
    public void markAsNotDone() {
        this.isDone = false;
    }

    /**
     * Checks if the task is on a specified date.
     *
     * @param date The date to check.
     * @return True if the task occurs on the specified date, false otherwise.
     */
    public boolean isOnDate(LocalDate date) {
        if (type.equals("[T]")) {
            return false; // Todo tasks don't have dates
        } else if (type.equals("[D]")) {
            return this.date != null && this.date.equals(date);
        } else if (type.equals("[E]")) {
            return this.date != null
                    && this.endDate != null && (
                        date.equals(this.date)
                            || date.equals(this.endDate) || (
                                date.isAfter(this.date) && date.isBefore(this.endDate)));
        }
        return false;
    }

    /**
     * Returns the icon representing whether the task is done.
     *
     * @return The icon representing the task's completion status.
     */
    public String getDoneIcon() {
        return (isDone ? "[X]" : "[ ]");
    }

    @Override
    public String toString() {
        String dateStr = "";
        if (type.equals("[D]") && date != null) {
            dateStr = " (by: " + date.format(OUTPUT_DATE_FORMATTER) + ")";
        } else if (type.equals("[E]") && date != null && endDate != null) {
            dateStr = " (from: " + date.format(OUTPUT_DATE_FORMATTER)
                    + " to: " + endDate.format(OUTPUT_DATE_FORMATTER) + ")";
        }
        return this.type + getDoneIcon() + " " + name + dateStr;
    }

    /**
     * Converts the task to a string format suitable for saving to a file.
     *
     * @return The string representation of the task for saving.
     */
    public String convertToFileString() {
        StringBuilder sb = new StringBuilder();
        sb.append(type.charAt(1)).append(" | ").append(isDone ? "1" : "0").append(" | ").append(name);
        if (type.equals("[D]")) {
            sb.append(" | ").append(date.format(INPUT_DATE_FORMATTER));
        } else if (type.equals("[E]")) {
            sb.append(" | ").append(date.format(INPUT_DATE_FORMATTER))
                    .append(" | ").append(endDate.format(INPUT_DATE_FORMATTER));
        }
        return sb.toString();
    }

    /**
     * Returns the name (description) of the task.
     *
     * @return The name of the task.
     */
    public String getName() {
        return name;
    }
}

