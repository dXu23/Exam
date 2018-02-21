import java.util.ArrayList;
import java.util.Scanner;
public class MCSAQuestion extends MCQuestion {

	// Constructors
	// Works. 
	public MCSAQuestion(String text, double maxValue) {
		super(text, maxValue);
	}

	public MCSAQuestion(String text) {
		this(text, 1);
	}

	public Answer getNewAnswer() {
		/**
		  * Reads String and Double from user and creates
		  * an MCSAnswer object, which it then adds to ArrayList
		  * answer
		  */
		System.out.println("Please enter a string description for your answer.\n");
		Scanner scAns = new Scanner(System.in);
		String ansDescription = scAns.nextLine();
		System.out.println("Please enter the value of the answer.\n");
		Scanner scVal = new Scanner(System.in);
		double ansVal = scVal.nextDouble();
		MCSAAnswer ans = new MCSAAnswer(ansDescription, ansVal);
		answers.add(ans);
		return ans;
	}

	public Answer getNewAnswer(String text) {
		/** Creates a new Answer object
		  * @param text string to be description of answer
		  *
		  */
		MCSAAnswer ans = new MCSAAnswer(text);
		answers.add(ans);
		return ans;
	}

	// Works
	public Answer getNewAnswer(String text, double creditIfSelected) {
		MCSAAnswer ans = new MCSAAnswer(text, creditIfSelected);
        // System.out.printf("%s\n", text);
		answers.add(ans);
		return ans;
	}


	public void getAnswerFromStudent() {
		/**
		  * Gets an Answer from the student through stdin
		  */
		System.out.println("Please enter your answer in the form of a letter: \n");
		Scanner scInput = new Scanner(System.in);
		char charStdntAns = scInput.findInLine(".").charAt(0);
		int arrayAnswerIndex = (int) charStdntAns - 0x41;
		int arrayMaxIndex = answers.size() - 1;
		while ((arrayAnswerIndex < 0) || (arrayAnswerIndex > arrayMaxIndex)) {
			scInput = new Scanner(System.in);
			charStdntAns = scInput.findInLine(".").charAt(0);
			arrayAnswerIndex = (int) charStdntAns - 0x41;
		}
		studentAnswer = answers.get(arrayAnswerIndex);
	}

	public double getValue() {
		// System.out.println("In MCSA getValue right now...\n");
		double value = 0;
		try {
			value = maxValue * studentAnswer.getCredit(this.rightAnswer);
		}
		catch (NullPointerException e) {
			System.out.println("Either studentAnswer or rightAnswer was not set.\n");
		}
		// System.out.printf("Answer value: %lf\n", studentAnswer.getCredit(this.rightAnswer));
		return value;
	}
}
