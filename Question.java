/** 
*  Question.java
*  @author Daniel Xu
*  @version 1.2
*/
import java.util.Random;

public abstract class Question {
	protected String text;
	protected Answer rightAnswer;
	protected Answer studentAnswer;
	protected double maxValue;

	// Constructor
	protected Question(String text, double maxValue) {
		/**
		  * Constructs the Question object. 
		  * @param text argument that should have the Question text
		  * @param maxValue the maximum value or total possible points of the Question object
		  */
		this.text = text;
		this.maxValue = maxValue;
	}

	// Second constructor
	protected Question(String text) {
		this(text, 1);
	}

	public void print() {
		/**
		  * Prints out the Question
		  */
		System.out.printf("%s\n", text);
	}

	void setRightAnswer(Answer ans) {
		/**
		  * Sets the right answer of question. 
		  * @param ans Answer to be right
		  */
		this.rightAnswer = ans;
		// System.out.println("In setRightAnswer...\n");
	}

	// Get Methods

	abstract Answer getNewAnswer();
		/**
		  * @return Answer object suitably matched to question type
		  */
		/*
		Answer NewAnswer = new Answer();
		return NewAnswer;
		*/

	abstract void getAnswerFromStudent();
		/**
		  * Gets an Answer from the student through stdin
		  */

	abstract double getValue();
		/** Returns value of Question
		  * @return Value of question
		  */
	// Set Methods

	/*
	public void unselectAnswer(int position) {
		aArray[position].setSelected(false);
	}
	*/


}

