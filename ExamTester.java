/** ExamTester.java
  * @author Daniel Xu
  * @version 2.0
*/

import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.Locale;

public class ExamTester {
	public static void main(String args[]) {
		// Step 0: Header
		String name = "Daniel Xu";
		String netId = "dxu23";
		System.out.printf("%s\n%s\n", name, netId );

		try {
			
			System.out.print("Please enter the name of your Exam file: ");
			// Create ScannerFactory to accept exam name input
			// ScannerFactory keyboardInput = new ScannerFactory();

			// get exam name from ScannerFactory
			String examFileName = ScannerFactory.getKeyboardScanner().nextLine();

			// Open exam file
			File examFile = new File(examFileName);

			// Step 1: Create the Exam object and Answer Objects from Exam file input
			System.out.println("Step 1: Create the Exam object and Answer Objects from Exam file input");

			// Create Scanner object to be passed into methods
			Scanner examInput = new Scanner(examFile).useLocale(Locale.US);

			// Create new Exam object
			Exam newExam = new Exam(examInput);

			// Step 2: Reorder questions on exam and answers. Then print
			System.out.println("Step 2: Reordering questions and Answers \n");
			newExam.print();

			newExam.reorderQuestions();
			newExam.reorderMCAnswers(-1);

			newExam.print();

			// Step 3: Save reordered exam to some file
			System.out.println("Step 3: Save reordered exam to some file");
			File reordered = new File("reorderedExam.txt");
			PrintWriter PWReorderedExam = new PrintWriter(reordered);
			newExam.save(PWReorderedExam);

			// Step 4: get student answers for question
			newExam.getAnswerFromStudent(0);
			newExam.getAnswerFromStudent(1);
			newExam.getAnswerFromStudent(2);
			/*
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

			// Third Question
			SAQuestion saq = new SAQuestion("What OO principle is implemented with private variables?", 1);
			saq.setRightAnswer(saq.getNewAnswer("Information Hiding"));
			newExam.addQuestion(saq);

			// Third Question
			saq = new SAQuestion("What did 8 bytes say to the bartender?", 1);
			saq.setRightAnswer(saq.getNewAnswer("Make us a double"));
			newExam.addQuestion(saq);

			// Fourth Question
			MCMAQuestion mcmaq = new MCMAQuestion("What do you put on a peanut butter and jelly sandwich?", 5, 0);
			mcmaq.getNewAnswer("Peanut better", 0.5);
			mcmaq.getNewAnswer("Peanut butter and jelly", 1.0);
			mcmaq.getNewAnswer("Jelly", 0.5);
			mcmaq.getNewAnswer("Onions", 0.0);
			mcmaq.getNewAnswer("Horseradish", 0.0);
			newExam.addQuestion(mcmaq);
			*/

			/*
			// Step 4: Select Answer to some or all of questions

			newExam.getAnswerFromStudent(0);
			newExam.getAnswerFromStudent(1);
			newExam.getAnswerFromStudent(2);
			newExam.getAnswerFromStudent(3);
			newExam.getAnswerFromStudent(4);
			*/


			newExam.print();

			// Step 5
			System.out.println("Grading exam...\n");
			newExam.reportQuestionValues();
			// System.out.printf("Score: %f\n", newExam.getValue());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File not found. Please check whether file was in directory or not.");
		}
	}
}
