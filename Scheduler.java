
public interface Scheduler {
    
    /**
 * Adds a task to the scheduler.
 *
 * @param t the task to add
 */
void addTask(Task t);

/**
 * Removes and returns the next task according to scheduling priority.
 *
 * @return the next task, or null if the scheduler is empty
 */
Task nextTask();

/**
 * Cancels a scheduled task by its name.
 *
 * @param n the name of the task to cancel
 */
void cancelTask(String n);
}
