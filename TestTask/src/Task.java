import java.util.List;

class Task {
    String condition;
    List<String> answers;
    int points;
    String correctAnswer;

    public Task(String condition, List<String> answers, int points, String correctAnswer) {
        this.condition = condition;
        this.answers = answers;
        this.points = points;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String toString() {
        return "Condition: " + condition + ", Points: " + points + ", Correct Answer: " + correctAnswer;
    }
}