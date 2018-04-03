/**
 * Exam.java
 * @author Daniel Xu
 * @version 3.0
*/

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
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
		text = header;
		questions = new ArrayList<Question>();
	}

	public Exam(Scanner input) {
		this(input.nextLine());
		/*
		MCSAQuestion MCSAQuestionToAdd;
		MCMAQuestion MCMAQuestionToAdd;
		SAQuestion SAQuestionToAdd;
		*/
		Question questionToAdd = null;
		String questionType = "something";
		int i = 0;
		while (input.hasNextLine()) {
			questionType = input.nextLine();
			// Take care of empty lines
			if (questionType.equals("")) {
				System.out.println("Empty line");
				continue;
			}
			System.out.printf("i: %d\n", i);
			System.out.printf("questionType: %s\n", questionType);
			switch (questionType) {
				case "MCSAQuestion":
					questionToAdd = new MCSAQuestion(input);
					break;
				case "MCMAQuestion":
					questionToAdd = new MCMAQuestion(input);
					break;
				case "SAQuestion":
					questionToAdd = new SAQuestion(input);
					break;
				default:
					break;
			}

			if (questionToAdd != null) {
				this.addQuestion(questionToAdd);
			}
			i++;
		}
	}


	// Works
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
					// System.out.println(examQuestion.getClass().getName());
                    ((MCQuestion) examQuestion).reorderAnswers();
				}
			}
		}
		else {
			if (questions.get(position) instanceof MCQuestion) {
                // System.out.println(questions.get(position).getClass().getName());
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

	// Works
	public void print() {
		/** Prints the Exam
		  */
		System.out.printf("%s\n", text);
		int i = 1;
		for (Question examQuestion : questions) {
			System.out.printf("%d. ", i);
			try {
				examQuestion.print();
			} catch(NullPointerException e) {
				System.out.println("Question was null.");
				e.printStackTrace();
			}
			i++;
		}
	}

	// Works
	public void getAnswerFromStudent(int position) {
		/** Gets an answer from student
		  * given the question position. 
		  * @param position Question position in the exam
		  */

		System.out.printf("For question %d\n", position + 1);
		questions.get(position).getAnswerFromStudent();
	}


	// Works
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

	public void reportQuestionValues() {
		int i = 1;
		System.out.print(
				"+===============+============+\n" +
				"|    Question   |   Value    |\n" +
				"+===============+============+\n");
		for (Question examQuestion : questions) {
			System.out.printf(
					"|       %d       |  %f  |\n" + 
					"+---------------+------------+\n", i, examQuestion.getValue());
			i++;
		}
		System.out.printf(
				"|     Total     |  %f  |\n" +
				"+---------------+------------+\n", getValue());
	}

	public void save(PrintWriter output) {
		System.out.println("In save method of Exam object right now...");
		System.out.printf("\n\n");
		output.printf("%s\n", text);
		for (Question examQuestion: questions) {
			examQuestion.save(output);
			output.printf("\n");
		}
		output.close();
	}

	void saveStudentAnswers(PrintWriter output) {
		for (Question question : questions) {
			question.save(output);
		}
	}
}
