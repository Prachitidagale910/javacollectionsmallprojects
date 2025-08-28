import java.util.ArrayList;

public class TaskManager {

    private ArrayList<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(String title, String description) {
        tasks.add(new Task(title, description));
        System.out.println("Task added successfully!");
    }

    public Task getByID(int id) {
        for (Task t : tasks) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    public Task getTaskByTitle(String title) {
        for (Task t : tasks) {
            if (t.getTitle().equalsIgnoreCase(title)) {
                return t;
            }
        }
        return null;
    }

    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("Here is your task list:");
        for (Task t : tasks) {
            System.out.println(t);
        }
    }

    public void updateStatus(int id, String status) {
        boolean found = false;
        for (Task t : tasks) {
            if (t.getId() == id) {
                t.setStatus(status);
                System.out.println("Task status updated!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Task not found");
        }
    }

    public void deleteTask(int id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == id) {
                tasks.remove(i);
                System.out.println("Task removed successfully!");
                return;
            }
        }
        System.out.println("Task not found");
    }
}
