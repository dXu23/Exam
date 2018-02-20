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

		// Third Question
		mcsaq = new MCSAQuestion("How many steps are in the first flight of UIC's library?");
		mcsaq.getNewAnswer("9", 0);
		mcsaq.setRightAnswer(mcsaq.getNewAnswer("15", 1));
		mcsaq.getNewAnswer("13", 0);
		mcsaq.getNewAnswer("10", 0);
		mcsaq.getNewAnswer("42", 0);
		newExam.addQuestion(mcsaq);

		// Fourth Question
		mcsaq = new MCSAQuestion("What is the speed of light in m/s ?");
		mcsaq.setRightAnswer(mcsaq.getNewAnswer("299792458", 1));
		mcsaq.getNewAnswer("186282", 0.5);
		mcsaq.getNewAnswer("9192631770", 0);
		mcsaq.getNewAnswer("9.10938215 * 10^{-31}", 0);
		newExam.addQuestion(mcsaq);

		// Fifth Question
		mcsaq = new MCSAQuestion("What is the ASCII encoding in hexadecimal for 'Hello world!'?");
		mcsaq.getNewAnswer("0x4920646f6e2774206b6e6f772e", 0);
		mcsaq.setRightAnswer(mcsaq.getNewAnswer("0x48656c6c6f20776f626c6421", 1));
		mcsaq.getNewAnswer("0x466f6f2062617221", 0);
		mcsaq.getNewAnswer("0x54686973206578616d2064756d622e", 0);
		mcsaq.getNewAnswer("4f6e6520646f6573206e6f742073696d707c792062616c616e63652062696e61727920736561726368207472656573", 0);
		newExam.addQuestion(mcsaq);

		// Sixth Question
		MCMAQuestion mcmaq = new MCMAQuestion("Which of the the following will be prizes at the CS Scavenger hosted by WICS?");
		mcmaq.setRightAnswer(mcmaq.getNewAnswer("VR Headset", 1));
		mcmaq.getNewAnswer("T-1000", 0);
		mcmaq.getNewAnswer("4096 Drummers Drumming", 0);
		mcmaq.getNewAnswer("1024 Lords a-Leaping", 0);
		mcmaq.getNewAnswer("Raspberry Pi", 1);
		newExam.addQuestion(mcmaq);

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
		newExam.getAnswerFromStudent(4);
		newExam.getAnswerFromStudent(5);

		// Step 4: Select Answer to some or all of questions

		// newExam.print();

		// Step 5
		System.out.println("Grading exam...\n");
		System.out.printf("Score: %f\n", newExam.getValue());
	}
}
