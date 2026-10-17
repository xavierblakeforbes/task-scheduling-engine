import java.time.LocalDateTime;

public class PrioritySchedulerTest {

    public static void main(String[] args) {
        PriorityScheduler scheduler = new PriorityScheduler();

        LocalDateTime morning = LocalDateTime.of(2026, 10, 17, 10, 0);
        LocalDateTime afternoon = LocalDateTime.of(2026, 10, 17, 15, 0);

        // Test 1: Higher priority should come first
        scheduler.addTask(new Task(2, "Low", morning));
        scheduler.addTask(new Task(8, "High", afternoon));
        scheduler.addTask(new Task(5, "Medium", morning));

        check("High".equals(scheduler.nextTask().getName()),
                "Higher priority comes first");
        check("Medium".equals(scheduler.nextTask().getName()),
                "Medium priority comes second");
        check("Low".equals(scheduler.nextTask().getName()),
                "Lower priority comes last");

        // Test 2: Earlier deadline wins when priorities are equal
        scheduler.addTask(new Task(5, "Later", afternoon));
        scheduler.addTask(new Task(5, "Earlier", morning));

        check("Earlier".equals(scheduler.nextTask().getName()),
                "Earlier deadline wins the tie");
        check("Later".equals(scheduler.nextTask().getName()),
                "Later deadline comes after");

        // Test 3: Cancel a task by name
        scheduler.addTask(new Task(10, "CancelMe", morning));
        scheduler.addTask(new Task(3, "KeepMe", afternoon));

        scheduler.cancelTask("CancelMe");

        check("KeepMe".equals(scheduler.nextTask().getName()),
                "Canceled task is removed");
        check(scheduler.nextTask() == null,
                "Queue is empty after retrieving remaining task");

        // Test 4: Empty queue
        check(scheduler.nextTask() == null,
                "Empty queue returns null");

        System.out.println("\nAll tests finished.");
    }

    private static void check(boolean condition, String testName) {
        if (condition) {
            System.out.println("PASS: " + testName);
        } else {
            System.out.println("FAIL: " + testName);
        }
    }
}

