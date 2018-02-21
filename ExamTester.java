/** @author Daniel Xu
    @version 1.1
*/

import java.io.*;
import java.util.Random;
public class ExamTester {
	public static void main(String args[]) {
		// Step 0: Header
		String name = "Daniel Xu";
		String netId = "dxu23";
		System.out.printf("%s\n%s\n", name, netId );
		// Step 1: Create the Exam object and Answer Objects
		System.out.println("Step 1: Creating Exam objects, Question objects, and Answer objects... \n");
		Exam newExam = new Exam("CS 342 Exam\n");

		// First question
		MCSAQuestion mcsaq = new MCSAQuestion("What is the derivative of e^x?");
		mcsaq.getNewAnswer("sin x", 0);
		mcsaq.getNewAnswer("cos x", 0);
		mcsaq.getNewAnswer("x", 0);
		mcsaq.getNewAnswer("tan x", 0);
		mcsaq.setRightAnswer(mcsaq.getNewAnswer("e^x", 1));
		newExam.addQuestion(mcsaq);

		// Second question
		mcsaq = new MCSAQuestion("How many bytes are in an int?");
		mcsaq.setRightAnswer(mcsaq.getNewAnswer("4", 1));
		mcsaq.getNewAnswer("96", 0);
		mcsaq.getNewAnswer("16", 0);
		mcsaq.getNewAnswer("8", 0);
		mcsaq.getNewAnswer("32", 0);
		newExam.addQuestion(mcsaq);

		SAQuestion saq = new SAQuestion("What OO principle is implemented with private variables?", 1);
		saq.setRightAnswer(saq.getNewAnswer("Information Hiding"));
		newExam.addQuestion(saq);

		saq = new SAQuestion("What did 8 bytes say to the bartender?", 1);
		saq.setRightAnswer(saq.getNewAnswer("Make us a double"));
		newExam.addQuestion(saq);


		// Step 2: Print the Exam
		System.out.println("Step 2: Printing exam...\n");
		newExam.print();

		// Step 3: Reorder questions on exam and answers. Then print
		System.out.println("Step 3: Reordering questions and Answers \n");
		newExam.reorderQuestions();
		newExam.reorderMCAnswers(-1);

		newExam.print();

		newExam.getAnswerFromStudent(0);
		newExam.getAnswerFromStudent(1);
		newExam.getAnswerFromStudent(2);
		newExam.getAnswerFromStudent(3);

		// Step 4: Select Answer to some or all of questions

		// newExam.print();

		// Step 5
		System.out.println("Grading exam...\n");
		newExam.reportQuestionValues();
		// System.out.printf("Score: %f\n", newExam.getValue());
	}
}
