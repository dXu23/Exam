
public class SAQuestion() {
	abstract Answer getAnswerFromStudent() {
		Scanner scInput = new Scanner(System.in);
		String studentInput = scInput.nextLine();
		this.studentAnswer = new MCSAAnswer(studentInput);
	}
}
