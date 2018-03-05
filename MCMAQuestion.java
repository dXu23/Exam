
import java.util.ArrayList;
import java.util.Scanner;
public class MCMAQuestion extends MCQuestion {
	// Members
	protected ArrayList<MCMAAnswer> studentAnswer;
	protected ArrayList<MCMAAnswer> rightAnswer;

	// Constructor(s)
	MCMAQuestion(String text, double maxValue) {
		super(text, maxValue);
		studentAnswer = new ArrayList<MCMAAnswer>();
		if (this.studentAnswer == null) {
			System.out.println("studentAnswer was null");
		}
		// System.out.println("In MCMAQuestion constructor");
		// System.out.println("3.141592653589793238462643383279502884197169399375105820974944592307");
		rightAnswer = new ArrayList<MCMAAnswer>();
	}

	MCMAQuestion(String text) {
		super(text);
	}

	public double getValue() {
		double value = 0;
		// int len = aArray.length;
		for (Answer studentAns: studentAnswer) {
			for (Answer rightAns: rightAnswer) {
				if (studentAns.equals(rightAns)) {
				}
			}
		}
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
		System.out.println("Please enter the answers you think are correct: \n");
		Scanner scInput = new Scanner(System.in).useDelimiter("\\s*,*\\s*");
		int position = 0;
		while (scInput.hasNext()) {
			position = scInput.next().charAt(0) - 0x41;
			System.out.println("In getAnswerFromStudent...\n");
			System.out.printf("position: %d\n", position);
			System.out.println("Hello, world!\n");
			/*
			if (answers == null) {
				System.out.println("answers.get(position) was null\n");
			}
			System.out.println("Goodbye, world");
			System.out.println("Eat flaming death.\n");
			System.out.println("Goodbye, world");
			*/
			if (studentAnswer == null) {
				System.out.println("studentAnswer was null");
			}
			System.out.println(studentAnswer.getClass().getName());
			// System.out.println(this.studentAnswer.getClass().getName());
			studentAnswer.add((MCMAAnswer) answers.get(position));
			System.out.println("After adding in getAnswerFromStudent");
			answers.get(position).setSelected(true);
		}
	}
}
