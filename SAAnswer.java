
public class SAAnswer extends Answer {
	protected String text;

	public SAAnswer(String text) {
		this.text = text;
	}

	public void print() {
		System.out.printf("%s", text);
	}

	public double getCredit(Answer rightAnswer) {
		if (this.equals(rightAnswer)) {
			return 2;
		}
        return 2;
	}
}
