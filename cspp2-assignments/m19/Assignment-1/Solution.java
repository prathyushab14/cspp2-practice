import java.util.Scanner;
class Quiz {
	Question[] quesns;
	int quco;
	String[] seleccho;
	Quiz() {
		quesns = new Question[4];
		quco = 0;
	}

}
/**
 * Solution class for code-eval.
 */
public final class Solution {
     /**
     * Constructs the object.
     */
    private Solution() {
        // leave this blank
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
         // instantiate this Quiz
        Quiz q = new Quiz();
         // code to read the test cases input file
        Scanner s = new Scanner(System.in);
        // check if there is one more line to process
        while (s.hasNext()) {
            // read the line
            String line = s.nextLine();
             // split the line using space
            String[] tokens = line.split(" ");
              // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "LOAD_QUESTIONS":
                System.out.println("|----------------|");
                System.out.println("| Load Questions |");
                System.out.println("|----------------|");
                loadQuestions(s, q, Integer.parseInt(tokens[1]));
                break;
                case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                startQuiz(s, q, Integer.parseInt(tokens[1]));
                break;
                case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                // displayScore(q);
                break;
                default:
                break;
            }
        }
    }
    /**
     * Loads questions.
     *
     * @param      s              The scanner object for user input
     * @param      quiz           The quiz object
     * @param      questionCount  The question count
     */
    public static void loadQuestions(final Scanner s, final Quiz quiz, final int questionCount) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        if (questionCount == 0) {
    		System.out.println("Quiz does not have questions");
    		return;
        }
        while (questionCount > 0) {
            String que = s.nextLine();
            String[] tokens = que.split(":");
            Question ques = new Question(tokens[0], tokens[1], tokens[3], tokens[2], tokens[4]);
            quesns[quco++] = ques;
            questionCount--;
        }
        System.out.println(questionCount+ "are added to the quiz");
    }
    /**
     * Starts a quiz.
     *
     * @param      s            The scanner object for user input
     * @param      quiz         The quiz object
     * @param      answerCount  The answer count
     */
    public static void startQuiz(final Scanner s, final Quiz quiz, final int answerCount) {
        // write your code here to display the quiz questions
        // read the user responses from the console
        // store the user respones in the quiz object
        for (int i = 0; i < questionCount; i++) {
        	System.out.println(quiz[i].quest+"("+quiz[i].maxMarks);
        	System.out.println(quiz[i].choices);
        	System.out.println("\n");
        }
        for (int j = 0; j < answerCount; j++) {
            String inp = s.nextLine();
            String[] tok = inp.split(" ");
            seleccho = seleccho.append(tok[1]);
            answerCount++;
        }
    }

    /**
     * Displays the score report
     *
     * @param      quiz     The quiz object
     */
//     public static void displayScore(final Quiz quiz) {
//         // write your code here to display the score report
//         for (int i = 0; i < questionCount; i++) {
//         	if (quiz[i].corrans.equals(seleccho[i])) {


//         }

//     }
// }
}

