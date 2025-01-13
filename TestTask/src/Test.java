import java.util.Comparator;
import java.util.Date;
import java.util.List;

class Test {
    Date date;
    String group;
    List<Task> tasks;

    public Test(Date date, String group, List<Task> tasks) {
        this.date = date;
        this.group = group;
        this.tasks = tasks;
    }

    public void sortTasks() {
        tasks.sort(Comparator.comparingInt(task -> task.answers.size()));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Test Date: " + date + ", Group: " + group + "\n");
        for (Task task : tasks) {
            sb.append(task).append("\n");
        }
        return sb.toString();
    }
}