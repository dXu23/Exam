
/** 
 *  Question.java
 *  @author Daniel Xu
 *  @version 3.0
*/

import java.util.Scanner;
import java.io.PrintWriter;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SAQuestion extends Question {
	public SAQuestion(String text, double maxValue) {
		/** SAQuestion constructor
		  * @param text String to be made the text of SAQuestion object
		  * @param maxValue double to made the maximum value of SAQuestion
		  */
		super(text, maxValue);
	}

	public SAQuestion(Scanner input) {
		super(input);
		rightAnswer = new SAAnswer(input);
	}

	public Answer getNewAnswer() {
		/** Gets a new answer using standard input
		  */
		System.out.println("Please enter a short answer.");
		Scanner scAns = new Scanner(System.in);
		String ansDescription = scAns.nextLine();
		SAAnswer ans = new SAAnswer(ansDescription);
		return ans;
	}

	public Answer getNewAnswer(String text) {
		/** Gets a new answer using a text string as a parameter
		  * @param text String to be made the text of the answer
		  */
		SAAnswer ans = new SAAnswer(text);
		return ans;
	}

	public void getAnswerFromStudent() {
		/** Takes a string from the student using
		  * standard input which will be the answer
		  * of the student. 
		  */
		System.out.println("Please enter your short answer as text input:");
		String studentInput = ScannerFactory.getKeyboardScanner().nextLine();
		this.studentAnswer = new SAAnswer(studentInput);
	}

	public double getValue() {
		/** Calculates the value of the SAQuestion object
		  * after student has entered in an answer
		  */
		double value = 0;
		try {
			value = maxValue * studentAnswer.getCredit(rightAnswer);
		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println(e);
			System.out.println("getAnswerFromStudent was likely not called for some SAQuestion.");
			System.out.println("You might want to double-check the number of getAnswerFromStudent calls");
		}
		return value;
	}

	public void save(PrintWriter output) {
		output.println("SAQuestion");
		output.printf("%.1f\n" + 
				"%s\n", this.maxValue, this.text);
		this.rightAnswer.save(output);
	}

	public void restoreStudentAnswers(Scanner input) {
		if (!input.nextLine().equals("SAAnswer")) {
			System.out.println("Warning! SAQuestion in Exam object not matching that of file!");
		}
		studentAnswer = new SAAnswer(input);
	}

	public JPanel createPanel() {
		JPanel questionPanel = new JPanel();
		JLabel questionText = new JLabel(this.text);
		JLabel prompt = new JLabel("Your answer:");
		JTextField SAstudentAnswer = new JTextField("");
		return questionPanel;
	}
}
