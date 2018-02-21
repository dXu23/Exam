
public abstract class MCAnswer extends Answer {
	protected String text;
	protected boolean selected;
	protected double creditIfSelected;

	// Constructor
	protected MCAnswer(String text, double creditIfSelected) {
		/**
		  * Constructs a multiple choice answer
		  * @param text text description of Answer object
		  * @param creditIfSelected Credit to be given to student when selected
		  */
		   
		this.text = text;
		this.selected = false;
		if ((creditIfSelected < 0) || (creditIfSelected > 1)) {
			this.creditIfSelected = 0;
		} else {
			this.creditIfSelected = creditIfSelected;
		}
	}

	protected MCAnswer(String text) {
		this(text, 1);
	}

	public void print() { 
        // Add 0x41 since 0x41 is ASCII hexadecimal for 'A'
		// System.out.println("Hello, world!\n");
		System.out.printf("%s\n", text);
	}

	public void setSelected(boolean selected) {
		/** Sets Answer to be selected
		  * @param selected If true, Answer will be set selected. Otherwise it will be set unselected. 
		  * 
		  */
		this.selected = selected;
	}

	/*
	public boolean isSelected() {
		return selected;
	}
	*/
}
