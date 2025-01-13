import java.util.*;

public class Main {
    public static void main(String[] args) {
        Task task1 = new Task("What is 2+2?", Arrays.asList("3", "4", "5"), 10, "4");
        Task task2 = new Task("What is the capital of France?", Arrays.asList("Paris", "London", "Berlin"), 20, "Paris");

        Test test = new Test(new Date(), "Group A", new ArrayList<>(Arrays.asList(task1, task2)));
        test.sortTasks();

        Map<String, String> answers1 = new HashMap<>();
        answers1.put("What is 2+2?", "4");
        Student student1 = new Student(1, "Alice", test, answers1);

        Map<String, String> answers2 = new HashMap<>();
        answers2.put("What is 2+2?", "3");
        Student student2 = new Student(2, "Bob", test, answers2);

        List<Student> students = new ArrayList<>(Arrays.asList(student1, student2));

        students.sort(Comparator.comparingInt(Student::calculateScore).reversed()
                .thenComparing(student -> student.name));

        for (Student student : students) {
            System.out.println(student);
        }
    }
}