
import java.util.ArrayList;
public class MCMAQuestion extends MCQuestion {
	// Members
	protected ArrayList<Answer> studentAnswer;
	protected ArrayList<Answer> rightAnswer;

	// Constructor(s)
	MCMAQuestion(String text, double maxValue) {
		super(text, maxValue);
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
		  * Reads String and Double from user and creates
		  * a MCMAAnswer object, which it then adds to ArrayList
		  * answer
		  */
		System.out.println("Please enter a string description for your answer.\n");
		Scanner scAns = new Scanner(System.in);
		String ansDescription = scAns.nextLine();
		System.out.println("Please enter the value of the answer.\n");
		Scanner scVal = new Scanner(System.in);
		double ansVal = scVal.nextDouble();
		Answer ans = new MCMAAnswer(ansDescription, ansVal);
		answers.add(ans);
		return ans;
	}

	public Answer getAnswerFromStudent() {
		/**
		  * Gets an Answer from the student through stdin
		  */
		System.out.println("Please enter the answers you think are correct: \n");
		Scanner scInput = new Scanner(System.in).useDelimiter("\\s*,*\\s*");
		while (scInput.hasNext()) {
			studentAnswer.add(rightAnswer.get(scInput.next().charAt(0) - 0x41));
		}

		answers.get(position).setSelected(true);
	}
}
