
public class SAQuestion {
	public SAQuestion(String text, double maxValue) {
		super(text, maxValue);
	}

	public Answer getAnswerFromStudent() {
		Scanner scInput = new Scanner(System.in);
		String studentInput = scInput.nextLine();
		this.studentAnswer = new MCSAAnswer(studentInput);
	}
}
