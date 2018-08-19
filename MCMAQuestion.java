
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.PrintWriter;
import java.lang.*;
public class MCMAQuestion extends MCQuestion {
	// Members
	protected ArrayList<Answer> studentAnswer;
	protected double baseCredit;
	// protected ArrayList<MCMAAnswer> rightAnswer;

	// Constructor(s)
	public MCMAQuestion(String text, double maxValue, double baseCredit) {
		super(text, maxValue);
		this.baseCredit = baseCredit;
		this.studentAnswer = new ArrayList<Answer>();
		/*
		if (this.studentAnswer == null) {
			System.out.println("studentAnswer was null");
		}
		*/
		// rightAnswer = new ArrayList<MCMAAnswer>();
	}

	public MCMAQuestion(String text) {
		this(text, 1, 0);
	}

	public MCMAQuestion(Scanner input) {
		super(input);
		System.out.printf("text: %s\n", this.text);
		System.out.printf("maxValue: %s\n", this.maxValue);
		this.baseCredit = input.nextDouble();
		this.studentAnswer = new ArrayList<Answer>();
		int numOfAns = input.nextInt();
		System.out.printf("numOfAns: %d\n", numOfAns);
		input.nextLine();
		// while double is found on each line, get contents of this line. Then advance to nextline. 
		for (int i = 0; i < numOfAns; i++) {
			this.addAnswer((MCAnswer) new MCMAAnswer(input));
		}
	}

	public double getValue() {
		double value = baseCredit;
		// int len = aArray.length;
		int i = 0;
		for (Answer answer: answers) {
			try {
				value += ((MCAnswer) answer).getCredit(rightAnswer);
			} 
			catch(NullPointerException e) {
				System.out.println("Answer input into getValue method of class MCQuestion was null");
				e.printStackTrace();
			}

			// System.out.printf("i: %d\n", i);
			i++;
		}
		// System.out.println("In getValue right now...");
		return maxValue * value;
	}

	public Answer getNewAnswer() {
		/**
		  * Asks for String and Double input from user on console
		  * which is then used to create a MCMAAnswer object. 
		  */
		System.out.println("Please enter a string description for your answer.\n");
		Scanner scAns = new Scanner(System.in);
		String ansDescription = scAns.nextLine();
		System.out.println("Please enter the value of the answer.\n");
		Scanner scVal = new Scanner(System.in);
		double ansVal = scVal.nextDouble();
		MCMAAnswer ans = new MCMAAnswer(ansDescription, ansVal);
		answers.add(ans);
		return ans;
	}

	public Answer getNewAnswer(String text, double creditIfSelected) {
		/**
		  * Creates a MCMAAnswer object from the text and creditIfSelected
		  * inputs. 
		  * @param text String input to made the text description of MCMAAnswer object
		  * @param creditIfSelected Double input to be made the value of the MCMAAnswer object
		  */
        // System.out.println("In getNewAnswer right now...\n");
		MCMAAnswer ans = new MCMAAnswer(text, creditIfSelected);
		answers.add(ans);
		return ans;
	}

	public void getAnswerFromStudent() {
		/**
		  * Gets an Answer from the student through stdin
		  */
		System.out.println("Please enter the answer(s) you think are correct: \n");
		int position = 0;
		int answersSize = answers.size();
		String charAns = ScannerFactory.getKeyboardScanner().findInLine("[a-zA-Z]");
		System.out.printf("charAns: %s\n", charAns);
		while (charAns != null) {
			// System.out.println("scInput:" + scInput.next());
			/*
			System.out.printf("ansString: %s\n", ansString);
			byte []bytes = ansString.getBytes();
			for (byte b:bytes) {
				System.out.println(b);
			}
			*/
			position = charAns.toUpperCase().charAt(0) - 0x41;
			System.out.printf("position: %d\n", position);
			if ((position < 0) || (position > answersSize - 1)) {
				System.out.println("Invalid answer letter was entered");
			} else {
				try {
					studentAnswer.add((MCMAAnswer) answers.get(position));
					// System.out.println("After adding in getAnswerFromStudent");
				} catch(NullPointerException e) {
					System.out.println("answer specified by position was null when trying to add to studentAnswer");
					e.printStackTrace();
				}
				answers.get(position).setSelected(true);
			}
			charAns = ScannerFactory.getKeyboardScanner().findInLine("[a-zA-Z]");
		}
		ScannerFactory.getKeyboardScanner().nextLine();
		// Advance Scanner to next line, so question coming after this one will parse input instead 
		// just getting an EOL character. 
	}

	public void save(PrintWriter output) {
		output.printf("MCMAQuestion\n" +
				"%.1f\n" + 
				"%s\n" +
				"%.1f\n" +
				"%d\n", this.maxValue, this.text, this.baseCredit, answers.size());
		for (MCAnswer MCans : answers) {
			MCans.save(output);
		}
		super.save(output);
	}

	public void restoreStudentAnswers(Scanner input) {
		if (!input.nextLine().equals("MCMAAnswer")) {
			System.out.println("Warning! MCMAQuestion in Exam object not matching that of file!");
		}
		int numOfAns = input.nextInt();
		// System.out.printf("Number of student answers: %d\n", numOfAns);
		MCMAAnswer answerToAdd = null;
		boolean notInAnswers;
		int answersSize = answers.size();
		int j = 0;
		if (numOfAns > answersSize) {
			System.out.printf("Too many answers. Please double-check the saved student answers file.\n");
		}
		input.nextLine();
		for (int i = 0; i < numOfAns; i++) {
			notInAnswers = true;
			// System.out.printf("i: %d\n", i);
			j = 0;
			answerToAdd = new MCMAAnswer(input);
			// System.out.printf("text of answerToAdd: %s\n", answerToAdd.text);
			while (notInAnswers && (j < answersSize)) {
				notInAnswers = !(((MCAnswer) answerToAdd)).equals(((MCAnswer) answers.get(j)));
				// System.out.println("notInAnswers: " + notInAnswers);
				j++;
			}
			if (notInAnswers) {
				System.out.printf("%s is not one of the possible answers!\n", answerToAdd.text);
				continue;
			} else {
				studentAnswer.add(answerToAdd);
				answers.get(j - 1).setSelected(true);
			}
		}
	}

	public void saveStudentAnswer(PrintWriter output) {
		output.printf("%s\n", this.getClass().toString().substring(6));
		for (Answer stdtAnswer : studentAnswer) {
			stdtAnswer.save(output);
		}
	}
}
