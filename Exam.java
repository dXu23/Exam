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

	public void reorderMCAnswers(int position) {
		/**
		  * Reorders the Answers in Multiple Choice Questions
		  * @param position position of Question whose answers are being reordered
		  */
		if (position == -1) {
			for (Question examQuestion : questions) {
				if (examQuestion instanceof MCQuestion) {
					System.out.println(examQuestion.getClass().getName());
                    ((MCQuestion) examQuestion).reorderAnswers();
				}
			}
		}
		else {
			if (questions.get(position) instanceof MCQuestion) {
                System.out.println(questions.get(position).getClass().getName());
				((MCQuestion) questions.get(position)).reorderAnswers();
			} else {
				System.out.println("Question was not a MCQuestion\n");
			}
		}
	}

	/*
	public Question getQuestion(int position) {
		return questions[position];
	}
	*/

	public void print() {
		/** Prints the Exam
		  */
		System.out.printf("%s\n", text);
		int i = 1;
		for (Question examQuestion : questions) {
			System.out.printf("%d. ", i);
			examQuestion.print();
			i++;
		}
	}

	public void getAnswerFromStudent(int position) {
		/** Gets an answer from student
		  * given the question position. 
		  * @param position Question position in the exam
		  */

		System.out.printf("For question %d\n", position + 1);
		questions.get(position).getAnswerFromStudent();
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
		double total = 0;
		// System.out.println("In Exam getValue right now...\n");
		for (Question examQuestion : questions) {
			total += examQuestion.getValue();
		}
		return total;
	}
}

