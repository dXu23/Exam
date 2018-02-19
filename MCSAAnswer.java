
public class MCSAAnswer extends MCAnswer {
	private String text;
	private boolean selected;

	MCSAAnswer(String text, double creditIfSelected) {
		super(text, creditIfSelected);
	}

	MCSAAnswer(String text) {
		this(text, 0);
	}

	/*
	public double getValue() {
		return 0;
	}
	*/

	public void print() {
		System.out.printf("%s", text);
	}

	public double getCredit(Answer rightAnswer) {
		if (this.equals(rightAnswer)) {
			return creditIfSelected;
		} else {
			return 0;
		}
	}
}
