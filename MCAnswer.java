
public abstract class MCAnswer extends Answer {
	protected String text;
	protected boolean selected;
	protected double creditIfSelected;

	/**
	 * Constructs a multiple choice answer
	 * @param text text description of Answer object
	 * @param creditIfSelected Credit to be given to student when selected
	 */
	protected MCAnswer(String text, double creditIfSelected) {
		this.text = text;
		this.selected = false;
		if ((creditIfSelected < 0) || (creditIfSelected > 1)) {
			this.creditIfSelected = 0;
		} else {
			this.creditIfSelected = creditIfSelected;
		}
	}

	/**
	 * Secondary constructor for MCAnswer object that only takes in a String as argument
	 * @param text String to be made the text of MCSAAnswer object
	 */
	protected MCAnswer(String text) {
		this(text, 1);
	}

	/**
	 * prints out text of MCAnswer
	 */
	public void print() { 
		System.out.printf("%s\n", text);
	}

	/** Sets Answer to be selected
	 * @param selected If true, Answer will be set selected. Otherwise it will be set unselected. 
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

}
