import java.util.Scanner;
public class SAQuestion extends Question {
	public SAQuestion(String text, double maxValue) {
		super(text, maxValue);
	}

	public Answer getNewAnswer() {
		System.out.println("Please enter a short answer.\n");
		Scanner scAns = new Scanner(System.in);
		String ansDescription = scAns.nextLine();
		System.out.println("Please enter the value of the short answer.\n");
		Scanner scVal = new Scanner(System.in);
		double ansVal = scVal.nextDouble();
		Answer ans = new SAAnswer(ansDescription, ansVal);
		answers.add(ans);
		return ans;
	}

	public Answer getAnswerFromStudent() {
		Scanner scInput = new Scanner(System.in);
		String studentInput = scInput.nextLine();
		this.studentAnswer = new SAAnswer(studentInput);
	}

	public double getValue() {
	}
}
