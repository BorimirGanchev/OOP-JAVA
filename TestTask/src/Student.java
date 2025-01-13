import java.util.Map;

class Student {
    int number;
    String name;
    Test test;
    Map<String, String> answers;

    public Student(int number, String name, Test test, Map<String, String> answers) {
        this.number = number;
        this.name = name;
        this.test = test;
        this.answers = answers;
    }

    public int calculateScore() {
        int score = 0;
        for (Task task : test.tasks) {
            String givenAnswer = answers.get(task.condition);
            if (task.correctAnswer.equals(givenAnswer)) {
                score += task.points;
            }
        }
        return score;
    }
}