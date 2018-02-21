import java.util.Scanner;
public class SAQuestion extends Question {
	public SAQuestion(String text, double maxValue) {
		/** SAQuestion constructor
		  * @param text String to be made the text of SAQuestion object
		  * @param maxValue double to made the maximum value of SAQuestion
		  */
		super(text, maxValue);
	}

	public Answer getNewAnswer() {
		/** Gets a new answer using standard input
		  */
		System.out.println("Please enter a short answer.");
		Scanner scAns = new Scanner(System.in);
		String ansDescription = scAns.nextLine();
		SAAnswer ans = new SAAnswer(ansDescription);
		return ans;
	}

	public Answer getNewAnswer(String text) {
		/** Gets a new answer using a text string as a parameter
		  * @param text String to be made the text of the answer
		  */
		SAAnswer ans = new SAAnswer(text);
		return ans;
	}

	public void getAnswerFromStudent() {
		/** Takes a string from the student using
		  * standard input which will be the answer
		  * of the student. 
		  */
		System.out.println("Please enter your short answer as text input:");
		Scanner scInput = new Scanner(System.in);
		String studentInput = scInput.nextLine();
		this.studentAnswer = new SAAnswer(studentInput);
	}

	public double getValue() {
		/** Calculates the value of the SAQuestion object
		  * after student has entered in an answer
		  */
		return maxValue * studentAnswer.getCredit(rightAnswer);
	}
}
