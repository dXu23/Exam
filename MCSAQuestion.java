import java.util.ArrayList;
public class MCSAQuestion extends MCQuestion{

	// Constructors
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
		Answer ans = new MCSAAnswer(ansDescription, ansVal);
		answers.add(ans);
		return ans;
	}

	public Answer getNewAnswer(String text) {
		/** Creates a new Answer object
		  * @param text string to be description of answer
		  *
		  */
		Answer ans = new MCSAAnswer(text);
		answers.add(ans);
		return ans;
	}

	public Answer getNewAnswer(String text, double creditIfSelected) {
		Answer ans = new MCSAAnswer(text, creditIfSelected);
		answers.add(ans);
		return ans;
	}


	public Answer getAnswerFromStudent() {
		/**
		  * Gets an Answer from the student through stdin
		  */
		System.out.println("Please enter your answer: \n");
		Scanner scInput = new Scanner(System.in);
		char charStdntAns = reader.findInLine(".").charAt(0);
		studentAnswer = answers.get(charStdntAns - 0x41);
		return studentAnswer;
	}

	public double getValue() {
		return studentAnswer.getCredit(rightAnswer);
	}
}
