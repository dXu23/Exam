import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.PrintWriter;
import java.lang.*;
import java.math.BigInteger;
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

	public MCSAQuestion(Scanner input) {
		super(input);
		// System.out.printf("text: %s\n", this.text);
		// System.out.printf("maxValue: %s\n", this.maxValue);
		int numOfAns = input.nextInt();
		double rightAnsVal = 0;
		// System.out.printf("numOfAns: %d\n", numOfAns);
		input.nextLine();
		MCSAAnswer answerToAdd;
		// Pattern ansValPattern = Pattern.compile("^-?0\\.\\d+");
		// while double is found on each line, get contents of this line. Then advance to nextline. 
		for (int i = 0; i < numOfAns; i++) {
			// System.out.printf("i: %d\n", i);
			try {
				answerToAdd = new MCSAAnswer(input);
				// System.out.println(answerToAdd.toString());
				// System.out.println("Executing addAnswer...");
				this.addAnswer((MCAnswer) answerToAdd);
			} catch(NullPointerException e) {
				System.out.println("MCAnswer was null for some reason");
				e.printStackTrace();
			}
		}
		// String foo = input.nextLine();
		// String bar = input.nextDouble();
		// System.out.printf("input.nextLine: %s\n input.nextDouble: %lf\n", foo, bar );
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

	/*
	/** Creates a new Answer object a String input
	  * @param text string to be description of answer
	  * @return Answer object created from String text
	public Answer getNewAnswer(String text) {
		MCSAAnswer ans = new MCSAAnswer(text);
		answers.add(ans);
		return ans;
	}
    */

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
		char charStdntAns = ScannerFactory.getKeyboardScanner().findInLine(".").charAt(0);
		int arrayAnswerIndex = (int) charStdntAns - 0x41;
		int arrayMaxIndex = answers.size() - 1;
		while ((arrayAnswerIndex < 0) || (arrayAnswerIndex > arrayMaxIndex)) {
			System.out.printf("%c entered an invalid answer. Please try again.", charStdntAns);
			charStdntAns = ScannerFactory.getKeyboardScanner().findInLine(".").charAt(0);
			arrayAnswerIndex = (int) charStdntAns - 0x41;
		}
		answers.get(arrayAnswerIndex).setSelected(true);
		studentAnswer = answers.get(arrayAnswerIndex);
		if (studentAnswer == null) {
			System.out.println("studentAnswer was null.\n");
		}
		ScannerFactory.getKeyboardScanner().nextLine(); 
		// Advance Scanner to next line, so question coming after this one will parse input instead 
		// just getting an EOL character. 
	}

	/**
	 * gets value of the MCSAQuestion object
	 * @return value of MCSAQuestion object
	 */
	public double getValue() {
		return super.getValue((MCAnswer) studentAnswer );
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

	public void save(PrintWriter output) {
		super.save(output);
	}

	public void restoreStudentAnswers(Scanner input) {
		if (!input.nextLine().equals("MCSAAnswer")) {
			System.out.println("Warning! MCSAQuestion in Exam object not matching that of file!");
		}
		studentAnswer = new MCSAAnswer(input);
		int i = 0;
		int answersSize = answers.size();
		boolean isNotEqual = true;

		while ((i < answersSize) && (isNotEqual)) {
			// System.out.printf("i: %d\n", i);
			// System.out.printf("studentAnswer.text: %s\n", ((MCAnswer) studentAnswer).text);
			/*
			byte []bytesone = ((MCAnswer) studentAnswer).text.getBytes();
			for (byte b:bytesone) {
				System.out.println(b);
			}
			System.out.printf("answers.get(%d).text: %s\n", i, ((MCAnswer) answers.get(i)).text);
			byte []bytestwo = ((MCAnswer) answers.get(i)).text.getBytes();
			for (byte b:bytestwo) {
				System.out.println(b);
			}
			*/
			isNotEqual = !(((MCAnswer) answers.get(i)).equals(((MCAnswer) studentAnswer)));
			// System.out.println("isNotEqual is " + isNotEqual);
			i++;
		}

		if (isNotEqual) {
			System.out.printf("WARNING! %s in saved answers file not one of the possible answers!", ((MCAnswer) studentAnswer).text);
		} else {
			answers.get(i - 1).setSelected(true);
		}
	}
}

