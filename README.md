# Task Scheduling Engine

A lightweight task scheduling engine built in Java that organizes tasks using a priority queue. Tasks are scheduled according to their priority, with deadlines used to break ties.

## Features

- **Priority-based scheduling:** Tasks with higher priority values are retrieved first.
- **Deadline-based tie-breaking:** When tasks have equal priority, the task with the earlier deadline is retrieved first.
- **Task cancellation:** Remove a scheduled task by its unique name.
- **Empty-queue handling:** Returns `null` when no tasks remain.
- **Object-oriented design:** Separates task data, the scheduler interface, and scheduling logic.

## Tech Stack

- Java
- Java Collections Framework (`PriorityQueue`, `Comparator`)
- Java Time API (`LocalDateTime`)
- Standard Java test runner

## Project Structure

```text
TaskScheduler/
├── Task.java
├── Scheduler.java
├── PriorityScheduler.java
├── SchedulerTest.java
└── README.md
```

## Design

### `Task`

Represents a scheduled task. Each task contains:

- `name`: A unique identifier used for cancellation.
- `priority`: An integer representing the task's importance.
- `deadline`: A `LocalDateTime` specifying when the task is due.

The class uses private fields and getter methods to encapsulate task data.

### `Scheduler`

Defines the operations supported by a scheduler:

- Add a task.
- Retrieve the next task.
- Cancel a task by name.

This interface separates the scheduler's public behavior from its implementation.

### `PriorityScheduler`

Implements the `Scheduler` interface using Java's `PriorityQueue` and a custom comparator.

The scheduling order is:

1. Higher priority values first.
2. Earlier deadlines first when priorities are equal.

Retrieving the next task removes it from the queue. Cancellation searches for a task by name and removes the matching task if it exists.

## Specifications and Assumptions

- Task names must be unique among currently scheduled tasks.
- Every task must have a non-null deadline.
- Higher integer values represent higher priority.
- Tasks with equal priorities are ordered by deadline.
- Retrieving from an empty queue returns `null`.
- Canceling a nonexistent task leaves the queue unchanged.

The current implementation assumes callers follow the task-name and deadline requirements.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed.
- A terminal or IDE such as Visual Studio Code.

Verify your installation:

```bash
java -version
javac -version
```

### Compile

Run the following command from the project directory:

```bash
javac Task.java Scheduler.java PriorityScheduler.java SchedulerTest.java
```

### Run Tests

```bash
java SchedulerTest
```

The test runner prints `PASS` or `FAIL` for each check.

## Complexity Analysis

Let n be the number of tasks currently scheduled.

| Operation | Time complexity |
|---|---|
| Add a task | O(log n) |
| Retrieve and remove the next task | O(log n) |
| Check whether the queue is empty | O(1)|
| Cancel a task by name | O(n)|

Java's `PriorityQueue` efficiently maintains the ordering of tasks, while cancellation requires searching for a matching name.

## Future Improvements

- Add JUnit tests for automated testing.
- Validate task names and deadlines when tasks are created or submitted.
- Add support for alternative scheduling policies.
- Introduce task status tracking and execution history.
- Add a command-line interface for submitting and managing tasks.

## Author
Xavier Blake-Forbes

Developed as a Java project to explore object-oriented design, interfaces, priority queues, custom comparators, and testing.
