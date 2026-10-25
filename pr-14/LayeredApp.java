import java.util.*;

class Task {
    String title;
    Task(String title) { this.title = title; }
    public String toString() { return title; }
}
class TaskService {
    private List<Task> tasks = new ArrayList<>();
    void add(String title) {
        if (title == null || title.isBlank()) throw new IllegalArgumentException("Task title cannot be blank");
        tasks.add(new Task(title));
    }
    int count() { return tasks.size(); }
    List<Task> all() { return tasks; }
}
public class LayeredApp {
    public static void main(String[] args) {
        TaskService service = new TaskService();
        service.add("Complete OOP practical");
        service.add("Revise Java exceptions");
        System.out.println("Tasks added: " + service.count());
        for (Task task : service.all()) System.out.println("- " + task);
        try { service.add(" "); }
        catch (IllegalArgumentException e) { System.out.println("Invalid action caught: " + e.getMessage()); }
        System.out.println("Manual test: PASS");
    }
}