import java.util.Arrays;
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

  private static int askQuestions() {

    int questionsIndex = 0; // questionsIndex
    for (int i = 0, c = 0; i < questions.length; i++) {
      System.out.println(questions[i][c]); // Print the question

      for (int optionsIndex = 1; optionsIndex < questions[c].length; optionsIndex++) {
        System.out.println(
            questions[questionsIndex][
                optionsIndex]); // Print each option, option starts at 1 to skip the question at
                                // each sub-array[0]
      }

      questionsIndex++; // Next element in questions array

      // get & process answer
      choice = getAnswer();
      if (processAnswer(choice, c)) {
        score++;
      } else {
        System.out.println("WRONG");
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

  private static boolean processAnswer(String choice, int questionsIndex) {
    return false;
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
