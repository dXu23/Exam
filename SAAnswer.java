
public class SAAnswer extends Answer {
	protected String text;

	public SAAnswer(String text) {
		this.text = text;
	}

	public void print() {
		System.out.printf("%s", text);
	}

	public double getCredit(Answer rightAnswer) {
        return 2;
	}
}
