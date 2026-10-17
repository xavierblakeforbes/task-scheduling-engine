import java.time.LocalDateTime;

/**
 * Represents a task with a priority, name, and deadline.
 * Task information is not modified after construction.
 */
public class Task {

    private final int priority;
    private final String name;
    private final LocalDateTime deadline;

    /**
     * Constructs a task with the given priority, name, and deadline.
     *
     * @param priority the task's priority; higher values indicate higher priority
     * @param name the name identifying the task
     * @param deadline the date and time by which the task is due
     */
    public Task(int priority, String name, LocalDateTime deadline) {
        this.priority = priority;
        this.name = name;
        this.deadline = deadline;
    }

    /**
     * Returns this task's priority.
     *
     * @return the task's priority
     */
    public int getPriority() {
        return this.priority;
    }

    /**
     * Returns this task's deadline.
     *
     * @return the task's deadline
     */
    public LocalDateTime getDeadline() {
        return this.deadline;
    }

    /**
     * Returns this task's name.
     *
     * @return the task's name
     */
    public String getName() {
        return this.name;
    }
}

