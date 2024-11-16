import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
class Question {
    String questionText;
    String[] options;
    int correctAnswerIndex;

    public Question(String questionText, String[] options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }
}
class Quiz {
    private List<Question> questions;
    private int score;
    private List<Boolean> answerResults;
    public Quiz() {
        questions = new ArrayList<>();
        score = 0;
        answerResults = new ArrayList<>();
    }
    public void addQuestion(Question question) {
        questions.add(question);
    }
    public void start() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            System.out.println("\nQuestion " + (i + 1) + ": " + question.questionText);
            for (int j = 0; j < question.options.length; j++) {
                System.out.println((j + 1) + ". " + question.options[j]);
            }
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    System.out.println("\nTime's up! Moving to the next question...!");
                    answerResults.add(false);
                    timer.cancel();
                }
            };
            timer.schedule(task, 10000);
            System.out.print("Enter your answer (1-" + question.options.length + "): ");
            int answer = scanner.nextInt();
            task.cancel();
            timer.cancel();
            if (answer - 1 == question.correctAnswerIndex) {
                System.out.println("Correct...!");
                score++;
                answerResults.add(true);
            } else {
                System.out.println("Incorrect...!");
                answerResults.add(false);
            }
        }
        displayResult();
        scanner.close();
    }
    public void displayResult() {
        System.out.println("\nQuiz Complete!");
        System.out.println("Your final score is: " + score + "/" + questions.size());
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            System.out.println("\nQuestion " + (i + 1) + ": " + question.questionText);
            System.out.println("Your answer " + (answerResults.get(i) ? "correct" : "incorrect") + ".");
            System.out.println("Correct answer: " + question.options[question.correctAnswerIndex]);
        }
    }
}
public class Quizzer {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.addQuestion(new Question("What is the capital of France?", new String[]{"Paris", "London", "Rome", "Berlin"}, 0));
        quiz.addQuestion(new Question("What is the largest planet?", new String[]{"Earth", "Mars", "Jupiter", "Saturn"}, 2));
        quiz.addQuestion(new Question("What is the square root of 64?", new String[]{"6", "7", "8", "9"}, 2));
        quiz.addQuestion(new Question("Who wrote 'Hamlet'?", new String[]{"Shakespeare", "Dickens", "Hemingway", "Orwell"}, 0));
        quiz.addQuestion(new Question("Which element has the atomic number 1?", new String[]{"Oxygen", "Nitrogen", "Hydrogen", "Helium"}, 2));
        quiz.start();
    }
}
