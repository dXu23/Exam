/** @author Daniel Xu
    @version 1.1
*/

import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;

public class Exam {
	private String text;
	private ArrayList<Question> questions;

	public Exam(String header) {
		/**
		  Constructs the Exam object
		  @param header This String argument will be the header of the exam
		  @return Exam object. 
		*/
		System.out.printf("Creating new exam with header %s...\n", header);
		text = header;
		questions = new ArrayList<Question>();
	}

	// Get Method
	/*
	public String getHeader() {
		return this.text;
	}
	*/

	/*
	public int getNumQuestions() {
		return numQuestions;
	}
	*/

	// Set Methods
	public void addQuestion(Question question) {
		/** Adds Question to Exam class
		  * @param question Question to be added to Exam class
		  */
		questions.add(question);
	}

	public void reorderQuestions() {
		/**
		  * Randomly reorders questions in Exam object using 
		  * shuffle method from Collections
		  * @return Nothing
		  */
		Collections.shuffle(questions);
	}

	public void reorderMCAnswer(int position) {
		/**
		  * Reorders the Answers in Multiple Choice Questions
		  * @param position position of Question whose answers are being reordered
		  */
		if (position == -1) {
			for (Answer examQuestion : questions) {
				if (examQuestion instanceof MCQuestion) {
					examQuestion.reorderAnswers();
				}
			}
		}
		else {
			questions.get(position).reorderAnswers();
		}
		
	}

	/*
	public Question getQuestion(int position) {
		return questions[position];
	}
	*/

	public void print() {
		System.out.printf("%s\n", text);
		Iterator<Question> iterQuestions = questions.iterator();
		int i = 1;
		while (iterQuestions.hasNext()) {
			System.out.printf("%d. ", i);
			iterQuestions.next().print();
			i++;
		}
	}

/*
	private void swapQuestions(int posFirst, int posSecond) {
		Question tempAns = qArray[posFirst];
		qArray[posFirst] = qArray[posSecond];
		qArray[posSecond] = tempAns;
	}
	*/


	double getValue() {
		/**
		  Gets overall score of Exam. 
		  @return Total score of Exam. 
		  */
		Iterator<Question> iterQuestions = questions.iterator();
		double total = 0;
		while (iterQuestions.hasNext()) {
			total += iterQuestions.next().getValue();
		}
		return total;
	}
}

