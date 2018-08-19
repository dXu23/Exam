/** 
 *  Question.java
 *  @author Daniel Xu
 *  @version 3.0
*/

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.PrintWriter;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
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
	public MCAnswer(String text) {
		this(text, 0);
	}

	protected MCAnswer(Scanner input) {
		double ansVal;
		String ansText;
		String MCAnsLine = input.nextLine();
		// System.out.printf("MCAnsLine: %s\n", MCAnsLine);
		Pattern ansValPattern = Pattern.compile("^-?[01]\\.\\d+");
		Matcher m = ansValPattern.matcher(MCAnsLine);
		int firstSpace;
		// System.out.println("In MCAnswer constructor...");
		// boolean something = false;
		/*
		for (int i = 0; i < m.groupCount(); i++) {
			System.out.printf("%d: %s\n", m.group(i));
		}
		*/
		if (m.find()) {
			ansVal = Double.parseDouble(m.group(0));
			// System.out.printf("ansVal: %f\n", ansVal);
			firstSpace = MCAnsLine.indexOf(" ");
			ansText = MCAnsLine.substring(firstSpace + 1);
		} else {
			// System.out.println("In else condition");
			ansVal = 0.0;
			ansText = MCAnsLine;
		}

		if ((ansVal < -1) || (ansVal > 1)) {
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
		if (this.selected) {
			return creditIfSelected;
		} else {
			return 0;
		}
		/*
		if (this.equals(rightAnswer) || this.selected) {
			System.out.printf("creditIfSelected: %f\n", ((MCAnswer) rightAnswer).creditIfSelected);
			return ((MCAnswer) rightAnswer).creditIfSelected;
		} else {
			return 0;
		}
		*/
	}

	public void save(PrintWriter output) {
		System.out.println("Saving MCAnswer right now...\n");
		output.printf("%.1f %s\n", this.creditIfSelected, this.text);
	}

	public JRadioButton createMCRadioButton() {
		return new JRadioButton(this.text);
	}

	public boolean equals(MCAnswer ans) {
		return this.text.equals(ans.text);
	}

}

