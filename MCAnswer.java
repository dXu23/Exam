/** 
 *  Question.java
 *  @author Daniel Xu
 *  @version 3.0
*/

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.PrintWriter;
import java.lang.*;
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
		this(text, 0);
	}

	protected MCAnswer(Scanner input) {
		double ansVal;
		String ansText;
		String MCAnsLine = input.nextLine();
		// System.out.printf("MCAnsLine: %s\n", MCAnsLine);
		Pattern ansValPattern = Pattern.compile("^-?0.\\d+");
		Matcher m = ansValPattern.matcher(MCAnsLine);
		// System.out.println("In MCAnswer constructor...");
		// boolean something = false;
		if (m.find()) {
			// System.out.println(something);
			ansVal = Double.parseDouble(m.group(0));
		} else {
			ansVal = 0.0;
		}
		int firstSpace = MCAnsLine.indexOf(" ");
		ansText = MCAnsLine.substring(firstSpace + 1);

		if ((ansVal < 0) || (ansVal > 1)) {
			this.creditIfSelected = 0;
		} else {
			this.creditIfSelected = ansVal;
		}
		this.selected = false;
		this.text = ansText;
		// System.out.printf("text: %s\n", this.text);
		// System.out.printf("creditIfSelected: %.3f\n", this.creditIfSelected);
	}

	/**
	 * prints out text of MCAnswer
	 */
	public void print() { 
		System.out.printf("%s", text);
	}

	/** Sets Answer to be selected
	 * @param selected If true, Answer will be set selected. Otherwise it will be set unselected. 
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
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

	public void save(PrintWriter output) {
		output.printf("%.1f %s\n", this.creditIfSelected, this.text);
	}

}

