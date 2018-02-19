public class MCMAAnswer extends MCAnswer {

	public MCMAAnswer(String text, double creditIfSelected) {
		super(text, creditIfSelected);
	}

	public double getCredit(Answer rightAnswer) {
        return 2.0;
	}
}
