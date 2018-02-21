/** 
*  Question.java
*  @author Daniel Xu
*  @version 2.0
*/
public class MCSAAnswer extends MCAnswer {

	/**
	 * Constructs a MCSAAnswer object.
	 * @param text String to be made text of MCSAAnswer object
	 * @param creditIfSelected double to be made the value of the Answer if selected
	 *
	 */
	public MCSAAnswer(String text, double creditIfSelected) {
		super(text, creditIfSelected);
        // System.out.printf("text: %s\n", this.text);
	}

	/**
	 * Constructs a MCSAAnswer object with a creditIfSelected value
	 * of 0 when given a String input
	 * @param text String to be made text of MCSAAnswer object
	 *
	 */
	public MCSAAnswer(String text) {
		this(text, 0);
	}

	/**
	 * Prints out the text of the MCSAAnswer object
	 */
	public void print() {
		System.out.printf("%s", text);
	}

	/**
	 * gets the credit for a student's answer
	 * @param rightAnswer MCSAAnswer object that will be compared to the student's answer
	 * @return credit the student will receive. 
	 *
	 */
	public double getCredit(Answer rightAnswer) {
		if (this.equals(rightAnswer) || this.selected) {
			return creditIfSelected;
		} else {
			return 0;
		}
	}
}
