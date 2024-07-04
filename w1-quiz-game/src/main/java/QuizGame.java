import java.util.Random;
import java.util.Scanner;

public class QuizGame {
  static Scanner scan = new Scanner(System.in);
  private static final Random rand = new Random();

  static String answerByUser;
  static Boolean resultOfAnswer;
  static int score;
  static int questionsIndex;
  // Arrays to store questions and answers
  private static String[] questions = {
    "What is the capital of France?",
    "Which planet is known as the Red Planet?",
    "What is the largest mammal in the world?"
  };
  final static int originalArrSize = questions.length;

  private static final String[] answers = {"Paris", "Mars", "Blue Whale"};

  public static String[] removeTheElement(String[] arr, int index) {

    // If the array is empty
    // or the index is not in array range
    // return the original array
//    if (arr == null || index < 0 || index >= arr.length) {
//
//      return arr;
//    }

    // Create another array of size one less
    String[] anotherArray = new String[arr.length - 1];

    // Copy the elements except the index
    // from original array to the other array
    for (int i = 0, k = 0; i < arr.length; i++) {

      // if the index is
      // the removal element index
      if (i == index) {
        continue;
      }

      // if the index is not
      // the removal element index
      anotherArray[k++] = arr[i];
    }

    // return the resultant array
    return anotherArray;
  }


  private static void askQuestions() {

    for (int i = 0; i < originalArrSize; i++) {
      if (questions.length > 1) {
        questionsIndex = rand.nextInt(questions.length);
        System.out.println(questions[questionsIndex]); // ask random questions
        // Can't ask the same question again
        // but if the original array only has one length then keep the original array
        questions = removeTheElement(questions, questionsIndex);
      } else {
        System.out.println(questions[0]);
      }

      try {
        answerByUser = scan.nextLine();
      } catch (Exception e){
        System.out.println("Something went wrong.");
      }

      // checkAnswer says anything other than the answer is wrong so that's input handling in of itself
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
    askQuestions();
    System.out.println("You've finished the quiz with a score of: " + score);
  }

  public static void main(String[] args) {
    System.out.println("Welcome to the Quiz Game!");
    runQuiz();
    System.out.println("Thanks for playing!");
  }
}
