import java.util.Random;
import java.util.Scanner;

public class QuizGameTwo {
  static Scanner scan = new Scanner(System.in);
  private static final Random rand = new Random();

  static String choice;
  static int score = 0;

  private static final String[][] questions = {
    {"What is the capital of France?", "A) London", "B) Berlin", "C) Paris", "D) Madrid"},
    {"Which planet is known as the Red Planet?", "A) Venus", "B) Mars", "C) Jupiter", "D) Saturn"},
    {
      "What is the largest mammal in the world?",
      "A) Elephant",
      "B) Blue Whale",
      "C) Giraffe",
      "D) Hippopotamus"
    }
  };

  private static final String[] answers = {"C", "B", "B"};

  private static final boolean[] askedQuestions = new boolean[questions.length];
  private static int remainingQuestions = questions.length;

  private static int askQuestions() {
    while (remainingQuestions > 0) {
      int questionIndex;
      do {
        questionIndex = rand.nextInt(questions.length);
      } while (askedQuestions[questionIndex]);

      askedQuestions[questionIndex] = true;
      remainingQuestions--;

      System.out.println(questions[questionIndex][0]); // Print the question
      for (int i = 1; i < questions[questionIndex].length; i++) {
        System.out.println(questions[questionIndex][i]); // Print each option
      }

      choice = getAnswer();
      if (processAnswer(choice, questionIndex)) {
        System.out.println("Correct!");
        score++;
      } else {
        System.out.println("Wrong. The correct answer is: " + answers[questionIndex]);
      }
    }
    return score;
  }

  private static String getAnswer() {
    System.out.print("Select an option: ");
    try {
      choice = scan.nextLine();
    } catch (Exception e) {
      System.out.println("Something went wrong.");
    }

    return choice;
  }

  private static boolean processAnswer(String choice, int innerArr) {
    System.out.println("You chosen: " + choice);
      return choice.trim().equalsIgnoreCase(answers[innerArr]);
  }

  // Method to run the quiz
  public static void runQuiz() {
    // TODO: Implement quiz logic here
    // User needs to be asked questions
    int finalScore = askQuestions();
    System.out.println("You've finished the quiz with a score of: " + finalScore);
  }

  public static void main(String[] args) {
    System.out.println("Welcome to the Quiz Game!");
    runQuiz();
    System.out.println("Thanks for playing!");
  }
}
