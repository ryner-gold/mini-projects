import java.util.Scanner;

public class QuizGame {
  static Scanner scan = new Scanner(System.in);

  static String answerByUser;
  static Boolean resultOfAnswer;
  static int score;
  static int questionsIndex;
  // Arrays to store questions and answers
  private static final String[] questions = {
    "What is the capital of France?",
    "Which planet is known as the Red Planet?",
    "What is the largest mammal in the world?"
  };

  private static final String[] answers = {"Paris", "Mars", "Blue Whale"};

  private static void askQuestion() {
    // User needs to be asked a question
    // User needs to response with a choice => int
    // If the user responds with not an int, handle appropriately
    // User needs to be asked all questions
    // Once all questions are asked, end askQuestion()

    for (int i = 0; i < questions.length; i++) {
      System.out.println(questions[i]);// -> ask question 1
      questionsIndex = i;
      answerByUser = scan.nextLine();
      resultOfAnswer = checkAnswer(answerByUser, questionsIndex);
      if(resultOfAnswer) {
        score++;
        System.out.println("Correct answer! Score: " + score);
      } else {
        System.out.println("Wrong answer!");
      }
    }
  }

  private static Boolean checkAnswer(String answerByUser, int questionsIndex) {
    // check the element of the index
    // since array questions and answers have the corresponding index for q & a

    if (answers[questionsIndex].trim().equalsIgnoreCase(answerByUser)) {
      return true;
    } else {
      return false;
    }
  }
  // Method to run the quiz
  public static void runQuiz() {
    // TODO: Implement quiz logic here
    // User needs to be asked questions
    askQuestion();
    System.out.println("You've finished the quiz with a score of: " + score);
  }

  public static void main(String[] args) {
    System.out.println("Welcome to the Quiz Game!");
    runQuiz();
    System.out.println("Thanks for playing!");
  }
}
