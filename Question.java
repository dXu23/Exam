/** 
*  Question.java
*  @author Daniel Xu
*  @version 2.0
*/
import java.util.Random;

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

	/**
	 * Prints out the text of the Question object
	 */
	public void print() {
		System.out.printf("%s\n", text);
	}

	/**
	  * Sets the right answer of question. 
	  * @param ans Answer to be right
	  */
	void setRightAnswer(Answer ans) {
		this.rightAnswer = ans;
	}

	/**
	  * @return Answer object suitably matched to question type
	  */
	abstract Answer getNewAnswer();

	/**
	  * Gets an Answer from the student through stdin
	  */
	abstract void getAnswerFromStudent();

	/** Returns value of Question
	  * @return Value of question
	  */
	abstract double getValue();

}

