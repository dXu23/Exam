
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
		for (Answer ans: studentAnswer) {
			if () {
				value = value + ans.getValue();
			}
		}
		return value;
	}

	public void getAnswerFromStudent(int position) {
		if ((position < 0) || (position >= N)) { // Check whether position is valid or not
			return;
		}

		answers.get(position).setSelected(true);
	}
}
