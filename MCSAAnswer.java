
public class MCSAAnswer extends MCAnswer {

	public MCSAAnswer(String text, double creditIfSelected) {
		super(text, creditIfSelected);
        // System.out.printf("text: %s\n", this.text);
	}

	public MCSAAnswer(String text) {
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
