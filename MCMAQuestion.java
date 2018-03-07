
import java.util.ArrayList;
import java.util.Scanner;
public class MCMAQuestion extends MCQuestion {
	// Members
	protected ArrayList<MCMAAnswer> studentAnswer;
	public double baseCredit;
	// protected ArrayList<MCMAAnswer> rightAnswer;

	// Constructor(s)
	MCMAQuestion(String text, double maxValue, double baseCredit) {
		super(text, maxValue);
		this.baseCredit = baseCredit;
		studentAnswer = new ArrayList<MCMAAnswer>();
		/*
		if (this.studentAnswer == null) {
			System.out.println("studentAnswer was null");
		}
		*/
		// rightAnswer = new ArrayList<MCMAAnswer>();
	}

	MCMAQuestion(String text) {
		super(text);
	}

	public double getValue() {
		double value = baseCredit;
		// int len = aArray.length;
		int i = 0;
		for (MCMAAnswer studentAns: studentAnswer) {
			value += super.getValue((MCMAAnswer) studentAns);
			// System.out.printf("i: %d\n", i);
			i++;
		}
		// System.out.println("In getValue right now...");
		return value;
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
		Scanner scInput = new Scanner(System.in);
		// String[] tokenizedAns = scInput.nextLine().split("\\s*,*\\s*");
		int position = 0;
		int answersSize = answers.size();
		String charAns = scInput.findInLine("[a-zA-Z]");
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
			System.out.println("In getAnswerFromStudent...\n");
			System.out.printf("position: %d\n", position);
			if ((position < 0) || (position > answersSize - 1)) {
				System.out.println("Invalid answer letter was entered");
			} else {
				studentAnswer.add((MCMAAnswer) answers.get(position));
				System.out.println("After adding in getAnswerFromStudent");
				answers.get(position).setSelected(true);
			}
			charAns = scInput.findInLine("[a-zA-Z]");
			//System.out.println("Hello, world!\n");
			/*
			if (answers == null) {
				System.out.println("answers.get(position) was null\n");
			}
			System.out.println("Goodbye, world");
			System.out.println("Eat flaming death.\n");
			if (studentAnswer == null) {
				System.out.println("studentAnswer was null");
			}
			System.out.println(studentAnswer.getClass().getName());
			// System.out.println(this.studentAnswer.getClass().getName());
			*/
		}
	}
}
