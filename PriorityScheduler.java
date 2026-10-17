import java.util.PriorityQueue;
import java.util.Comparator;

public class PriorityScheduler implements Scheduler {
    private PriorityQueue<Task> schedule;

    public PriorityScheduler(){schedule =new PriorityQueue<>(taskCompare);}
    public void addTask(Task t) {schedule.add(t);}
    public Task nextTask(){if(schedule.size() == 0){return null;}return schedule.remove();}
    public void cancelTask(String n) {
    Task found = null;

    for (Task t : schedule) {
        if (t.getName().equals(n)) {
            found = t;
            break;
        }
    }

    if (found != null) {
        schedule.remove(found);
    }
}
    Comparator<Task> taskCompare = (a, b) -> {
       return Integer.compare(b.getPriority(), a.getPriority()) != 0 ? Integer.compare(b.getPriority(), a.getPriority()) : a.getDeadline().compareTo(b.getDeadline()); 
};
}
