/** 
*  Question.java
*  @author Daniel Xu
*  @version 3.0
*/

import java.util.Scanner;
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

	public MCSAAnswer(Scanner input) {
		super(input);
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

}
