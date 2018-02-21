import java.util.Scanner;
public class SAQuestion extends Question {
	public SAQuestion(String text, double maxValue) {
		super(text, maxValue);
	}

	public Answer getNewAnswer() {
		System.out.println("Please enter a short answer.");
		Scanner scAns = new Scanner(System.in);
		String ansDescription = scAns.nextLine();
		SAAnswer ans = new SAAnswer(ansDescription);
		return ans;
	}

	public Answer getNewAnswer(String text) {
		SAAnswer ans = new SAAnswer(text);
		return ans;
	}

	public void getAnswerFromStudent() {
		System.out.println("Please enter your answer.");
		Scanner scInput = new Scanner(System.in);
		String studentInput = scInput.nextLine();
		this.studentAnswer = new SAAnswer(studentInput);
	}

	public double getValue() {
		if (this.equals(rightAnswer)) {
			return maxValue;
		}
		else {
			return 0;
		}
	}
}
