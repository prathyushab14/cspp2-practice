import java.util.Scanner;
/**
 * Class for question.
 */
class Question {
    /**
     * { var_description }.
     */
    private String questiontext;
    /**
     * { var_description }.
     */
    private String[] choices;
    /**
     * { var_description }.
     */
    private int correctAnswer;
    /**
     * { var_description }.
     */
    private int maxMarks;
    /**
     * { var_description }.
     */
    private int penalty;
    /**
     * { var_description }.
     */
    private String response;
    /**
     * Constructs the object.
     */
    Question() {

    }
    /**
     * Constructs the object.
     *
     * @param      question1       The question 1
     * @param      choices1        The choices 1
     * @param      correctAnswer1  The correct answer 1
     * @param      maxMarks1       The maximum marks 1
     * @param      penalty1        The penalty 1
     */
    Question(final String question1, final String[] choices1,
        final int correctAnswer1, final int maxMarks1, final int penalty1) {
        this.questiontext = question1;
        this.choices = choices1;
        this.correctAnswer = correctAnswer1;
        this.maxMarks = maxMarks1;
        this.penalty = penalty1;

    }
    /**
     * { function_description }.
     *
     * @param      choice  The choice
     *
     * @return     { description_of_the_return_value }
     */
    public boolean evaluateResponse(final String choice) {
        if (choice.equals(getCorrectAnswer())) {
            return true;
        }
        return false;
    }
    /**
     * Gets the correct answer.
     *
     * @return     The correct answer.
     */
    public String getCorrectAnswer() {
        return choices[correctAnswer - 1];
    }
    /**
     * Gets the question text.
     *
     * @return     The question text.
     */
    public String getQuestionText() {
        return questiontext;
    }
    /**
     * Gets the choice.
     *
     * @return     The choice.
     */
    public String[] getChoice() {
        return choices;
    }
    /**
     * Gets the maximum marks.
     *
     * @return     The maximum marks.
     */
    public int getMaxMarks() {
        return maxMarks;
    }
    /**
     * Gets the penalty.
     *
     * @return     The penalty.
     */
    public int getPenalty() {
        return penalty;
    }
    /**
     * Sets the response.
     *
     * @param      answer  The answer
     */
    public void setResponse(final String answer) {
        response = answer;

    }
    /**
     * Gets the response.
     *
     * @return     The response.
     */
    public String getResponse() {
        return response;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        s += getQuestionText() + "(" + getMaxMarks() + ")";
        s += "\n";
        for (int i = 0; i < choices.length; i++) {
            if (i != choices.length - 1) {
                s += choices[i] + "\t";
            } else {
                s += choices[i];
        }
    }
        s += "\n";
        return s;
}
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
}
/**
 * Class for quiz.
 */
class Quiz {
    /**
     * { var_description }.
     */
    private final int onehundred = 100;
    /**
     * { var_description }.
     */
    private Question[] questions;
    /**
     * { var_description }.
     */
    private int size;
    /**
     * Constructs the object.
     */
    Quiz() {
        final int ten = 10;
        questions = new Question[ten];
        size = 0;
    }
    /**
     * Gets the size.
     *
     * @return     The size.
     */
    public int getSize() {
        return size;
    }
    /**
     * Adds a question.
     *
     * @param      q     The question
     */
    public void addQuestion(final Question q) {
        questions[size++] = q;
    }
    /**
     * Gets the question.
     *
     * @param      index  The index
     *
     * @return     The question.
     */
    public Question getQuestion(final int index) {
        return questions[index];
    }
    /**
     * Shows the report.
     *
     * @return     { description_of_the_return_value }
     */
    public String showReport() {
        int sum = 0;
        String s = "";
        for (int i = 0; i < getSize(); i++) {
            s += questions[i].getQuestionText();
            s += "\n";
            if (questions[i].evaluateResponse(questions[i].getResponse())) {
                s += " Correct Answer! - Marks Awarded: " + 
                questions[i].getMaxMarks() + "\n";
                sum += questions[i].getMaxMarks();
            } else {
                s += " Wrong Answer! - Penalty: "+questions[i].getPenalty() + "\n";
                sum += questions[i].getPenalty();
            }
        }
        s += "Total Score: "+sum;
        return s;
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
    private static boolean flag = true;
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
                displayScore(q);
                break;
                default:
                break;
            }
        }
    }
    /**
     * Loads questions.
     *
     * @param      scan       The scan
     * @param      quiz       The quiz
     * @param      q          The question count
     *
     */
    public static void loadQuestions(final Scanner scan,
        final Quiz quiz, final int q) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        final int one = 1;
        final int two = 2;
        final int three = 3;
        final int four = 4;
        final int five = 5;
        if (q < one) {
            System.out.println("Quiz does not have questions");
            flag = false;
            return;
        }
        for (int i = 0; i < q; i++) {
            String ques = scan.nextLine();
            String[] toke = ques.split(":");
            if (toke[0].equals("") || toke.length < five) {
                System.out.println("Error! Malformed question");
                flag = false;
                return;
            }
            if (Integer.parseInt(toke[four]) > 0) {
                System.out.println("Invalid penalty for "+toke[0]);
                flag = false;
                return;
            }
            if (Integer.parseInt(toke[three]) < 0) {
                System.out.println("Invalid max marks for "+toke[0]);
                flag = false;
                return;
            }
            String[] choi = toke[one].split(",");
            if (choi.length < two) {
                System.out.println(toke[0]+" does not have enough answer choices");
                flag = false;
                return;
            }
            if (Integer.parseInt(toke[two]) > four) {
                System.out.println("Error! Correct answer choice number is out of range for " + 
                    toke[0]);
                flag = false;
                return;
            }
            Question qu = new Question(toke[0], choi, Integer.parseInt(toke[two]), 
                Integer.parseInt(toke[three]), Integer.parseInt(toke[four]));
            quiz.addQuestion(qu);
        }
        System.out.println(q + " are added to the quiz");
    }
    /**
     * Starts a quiz.
     *
     * @param      scan  The scan
     * @param      quiz  The quiz
     * @param      q     The answer count
     */
    public static void startQuiz(final Scanner scan,
        final Quiz quiz, final int q) {
        // write your code here to display the quiz questions on the console.
        // read the user responses from the console using scanner object.
        // store the user respone in the question object
        if (!flag) {
            return;
        }
        for (int i = 0; i < q; i++) {
            Question que = quiz.getQuestion(i);
            System.out.println(que);
            String ans = scan.nextLine();
            que.setResponse(ans);
        }

    }
    /**
     * Displays the score report.
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report using quiz object.
        if (!flag) {
            return;
        }
        System.out.println(quiz.showReport());
    }
}
