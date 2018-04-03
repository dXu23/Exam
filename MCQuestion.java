/** 
 *  Question.java
 *  @author Daniel Xu
 *  @version 3.0
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// public static final String ANSI_RESET = "\u001B[0m";
// public static final String ANSI_BLUE = "\u001B[34m";

public abstract class MCQuestion extends Question {
	// Members
	protected ArrayList<MCAnswer> answers;
	
	// Constructor
	protected MCQuestion(String text, double maxValue) {
		super(text, maxValue);
		answers = new ArrayList<MCAnswer>();
	}

	protected MCQuestion(String text) {
		this(text, 1);
	}

	protected MCQuestion(Scanner input) {
		super(input);
		answers = new ArrayList<MCAnswer>();
	}

	public void addAnswer(MCAnswer MCA) {
		/**
		  * Adds an answer to the Question
		  * @param MCA Answer to be added
		  */

		try {
			answers.add(MCA);
		} catch(NullPointerException e) {
			System.out.println("In addAnswer method of MCQuestion class: MCAnswer input was null");
			e.printStackTrace();
		}
	}

	public void reorderAnswers() {
		/**
		 * reorders MCAnswers in MCQuestion
		 */

		Collections.shuffle(answers);
	}

	public double getValue(MCAnswer MCAns) {
		double value = 0;
		try {
			for (Answer loopMCAns : answers) {
				if (MCAns.getCredit(loopMCAns) != 0.0) {
					value = MCAns.getCredit(loopMCAns) * maxValue;
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println(e);
			System.out.println("getAnswerFromStudent was likely not called for some MCQuestion or student" +
					"enter answer.");
			System.out.println("You might want to double-check the number of getAnswerFromStudent calls");
			return 0.0;
		}
		return value;
	}

	public void print() {
		super.print();
		// System.out.printf("numAns: %d\n", numAns);
		int i = 0;
		for (MCAnswer ans: answers) {
			if (ans.selected) {
				System.out.printf("[%c]. ", i + 0x41);
			} else {
				System.out.printf("(%c). ", i + 0x41);
			}
            answers.get(i).print();
            System.out.print("\n");
            i++;
		}
		System.out.print("\n");
	}

	public void save(PrintWriter output) {
		output.printf("%s\n" +
				"%.1f\n" + 
				"%s\n", this.getClass().toString().substring(6), this.maxValue, this.text);
		for (MCAnswer MCans : answers) {
			MCans.save(output);
		}
	}
}
