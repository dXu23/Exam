/** 
 *  Question.java
 *  @author Daniel Xu
 *  @version 3.0
*/
import java.util.Random;
import java.util.Scanner;
import java.io.PrintWriter;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public abstract class Question {
	protected String text;
	protected Answer rightAnswer;
	protected Answer studentAnswer;
	protected double maxValue;

	/**
	  * Constructs the Question object. 
	  * @param text argument that should have the Question text
	  * @param maxValue the maximum value or total possible points of the Question object
	  */
	protected Question(String text, double maxValue) {
		this.text = text;
		this.maxValue = maxValue;
	}

	protected Question(String text) {
		this(text, 1);
	}

	protected Question(Scanner input) {
		this.maxValue = input.nextDouble();
		input.nextLine();
		this.text = input.nextLine();
	}

	/**
	 * Prints out the text of the Question object
	 */
	public void print() {
		try {
			System.out.printf("%s\n", text);
			/*
			System.out.println("Student Answer:");
			studentAnswer.print();
			*/
		} catch(NullPointerException e) {
			System.out.println("text is null\n");
			e.printStackTrace();
		}
	}

	/**
	  * Sets the right answer of question. 
	  * @param ans Answer to be right
	  */
	public void setRightAnswer(Answer ans) {
		this.rightAnswer = ans;
	}

	/**
	  * @return Answer object suitably matched to question type
	  */
	public abstract Answer getNewAnswer();

	/**
	  * Gets an Answer from the student through stdin
	  */
	public abstract void getAnswerFromStudent();

	/** Returns value of Question
	  * @return Value of question
	  */
	public abstract double getValue();

	public abstract void save(PrintWriter output);

	public void saveStudentAnswer(PrintWriter output) {
		output.printf("%s\n", this.getClass().toString().substring(6));
		if (studentAnswer == null) {
			System.out.println("studentAnswer was null.\n");
		}
		try {
			studentAnswer.save(output);
		} catch (NullPointerException e) {
			System.out.println("In method saveStudentAnswer, studentAnswer member was likely null.");
			e.printStackTrace();
		}
	}

	public abstract void restoreStudentAnswers(Scanner input);
	public abstract JPanel createPanel();
}

