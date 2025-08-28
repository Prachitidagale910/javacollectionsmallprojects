public class Task {

    private int id;
    private String title;
    private String description;
    private static int counter = 100;
    private String status;

    public Task(String title, String description) {
        this.id = counter++;
        this.status = "Pending";
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getStatus() {
        return status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task ID: " + id +
               ", Title: " + title +
               ", Description: " + description +
               ", Status: " + status;
    }
}
