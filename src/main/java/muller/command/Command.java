package muller.command;

import muller.storage.Storage;
import muller.task.TaskList;
import muller.ui.Ui;

/**
 * Abstract class representing a command. All specific command types inherit from this class.
 */
public abstract class Command {
    /**
     * Executes the command.
     *
     * @param tasks   The TaskList on which the command operates.
     * @param ui      The UI for user interaction.
     * @param storage The Storage for saving/loading tasks.
     * @throws MullerException If an error occurs during command execution.
     */
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws MullerException;

    /**
     * Indicates whether the command is an exit command.
     *
     * @return True if the command is an exit command, false otherwise.
     */
    public boolean isExit() {
        return false;
    }
}

