public class MCSAQuestion {

	// Constructors
	MCSAQuestion(String text, double maxValue) {
		super(text, maxValue);
	}

	MCSAQuestion(String text) {
		MCSAQuestion(text, 1);
	}

	public Answer getNewAnswer(String text) {
		Answer ans = new MCSAAnswer(text);
		return ans;
	}

	public Answer getNewAnswer(String text, double creditIfSelected) {
		Answer ans = new MCSAAnswer(text, creditIfSelected);
		return ans;
	}


	public void getAnswerFromStudent(int position) {
		/**
		  * Gets an Answer from the student through stdin
		  */

		if ((position < 0) || (position >= N)) { // Check whether position is valid or not
			return;
		}
		for (int i = 0; i < position; i++) {
			if (aArray[i].isSelected()) {
				aArray[i].setSelected(false);
			}
		}
		for (int i = position + 1; i < N; i++) {
			if (aArray[i].isSelected() == true) {
				aArray[i].setSelected(false);
			}
		}
		answers.get(position).setSelected(true);
	}

	public getAnswerFromStudent() {
		Scanner scInput = new Scanner(System.in);
		String studentInput = scInput.nextLine();
		this.studentAnswer = new MCSAAnswer(studentInput);
	}

	getValue() {
	}
}
