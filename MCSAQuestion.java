import java.util.ArrayList;
import java.util.Scanner;
public class MCSAQuestion extends MCQuestion {

	/**
	 * MCSAQuestion object constructor
	 * @param text String to be made the text of MCSAQuestion object
	 * @param maxValue double to be made the maximum value of the MCSAQuestion object
	 */
	public MCSAQuestion(String text, double maxValue) {
		super(text, maxValue);
	}

	public MCSAQuestion(String text) {
		this(text, 1);
	}

	/**
	 * Generates a new MCSA Answer object through standard input.
	 * @return Answer object created through standard input
	 */
	public Answer getNewAnswer() {
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

	/** Creates a new Answer object a String input
	  * @param text string to be description of answer
	  * @return Answer object created from String text
	  */
	public Answer getNewAnswer(String text) {
		MCSAAnswer ans = new MCSAAnswer(text);
		answers.add(ans);
		return ans;
	}

	/**
	  * Reads String and Double from user and creates
	  * an MCSAAnswer object, which it then adds to ArrayList
	  * answer
	  * @param text String to be made the text of the MCSAAnswer object
	  * @param creditIfSelected Double to be made the credit of MCSAAnswer object if selected
	  * @return MCSAAnswer object
	  */
	public Answer getNewAnswer(String text, double creditIfSelected) {
		MCSAAnswer ans = new MCSAAnswer(text, creditIfSelected);
		answers.add(ans);
		return ans;
	}


	/**
	  * Gets an Answer from the student through stdin
	  */
	public void getAnswerFromStudent() {
		for (MCAnswer ans : answers) { //Sets any previously selected answers to unset
			ans.setSelected(false);
		}
		System.out.println("Please enter your answer in the form of a letter: ");
		Scanner scInput = new Scanner(System.in);
		char charStdntAns = scInput.findInLine(".").charAt(0);
		int arrayAnswerIndex = (int) charStdntAns - 0x41;
		int arrayMaxIndex = answers.size() - 1;
		while ((arrayAnswerIndex < 0) || (arrayAnswerIndex > arrayMaxIndex)) {
			System.out.println("You entered an invalid answer. Please try again.");
			scInput = new Scanner(System.in);
			charStdntAns = scInput.findInLine(".").charAt(0);
			arrayAnswerIndex = (int) charStdntAns - 0x41;
		}
		studentAnswer = answers.get(arrayAnswerIndex);
		((MCAnswer) studentAnswer).setSelected(true);
	}

	/**
	 * gets value of the MCSAQuestion object
	 * @return value of MCSAQuestion object
	 */
	public double getValue() {
		return super.getValue((MCSAAnswer) studentAnswer );
		/*
		double value = 0;
		try {
			value = maxValue * studentAnswer.getCredit(this.rightAnswer);
		}
		catch (NullPointerException e) {
			System.out.println("Either studentAnswer or rightAnswer was not set.\n");
		}
		return value;
		*/
	}
}
