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
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

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
				continue;
			}
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
				case "NumQuestion":
					questionToAdd = new NumQuestion(input);
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

	public JFrame makeExamGui() {
		JFrame examFrame = new JFrame(text);
		JPanel questionPanel;
        Container content = examFrame.getContentPane(); // unnecessary in 5.0+
        content.setLayout(new GridLayout(3, 1));
		for (Question question : questions) {
			questionPanel = question.createPanel();
			content.add(questionPanel);
		}
        examFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        examFrame.setSize(300, 150);
        examFrame.setVisible(true);
		return examFrame;
	}

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
		System.out.println("----------------------------------------");
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
		System.out.println("----------------------------------------");
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
		output.printf("%s\n\n", text);
		for (Question examQuestion: questions) {
			examQuestion.save(output);
			output.printf("\n");
		}
		output.close();
	}

	void saveStudentAnswers(PrintWriter output) {
		System.out.println("In saveStudentAnswers right now...\n");
		int i = 0;
		for (Question question : questions) {
			System.out.printf("i: %d\n", i);
			question.saveStudentAnswer(output);
			i++;
		}
	}

	void restoreStudentAnswers(Scanner input) {
		int i = 0;
		int numOfQuestions = questions.size();
		String line = "";
		while ((i < numOfQuestions) && (input.hasNextLine())) {
			line = input.nextLine();
			// System.out.printf("line: %s\n", line);
			if (line == "") {
				continue;
			}
			questions.get(i).restoreStudentAnswers(input);
			i++;
		}
	}

	void saveScore(PrintWriter output) {
		output.printf("%f\n", getValue());
		int fencePosts = questions.size() - 1;
		int i = 0;
		for (Question question : questions) {
			output.printf("%f", question.getValue());
			if (i < fencePosts) {
				output.print(", ");
			}
			i++;
		}
	}
}
