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
		MCSAQuestion q = new MCSAQuestion("What is the derivative of e^x?");
		q.getNewAnswer("sin x", 0);
		q.getNewAnswer("cos x", 0);
		q.getNewAnswer("x", 0);
		q.getNewAnswer("tan x", 0);
		q.getNewAnswer("e^x", 1);
		newExam.addQuestion(q);

		// Second question
		q = new MCSAQuestion("How many bytes are in an int?");
		q.getNewAnswer("4", 1);
		q.getNewAnswer("96", 0);
		q.getNewAnswer("16", 0);
		q.getNewAnswer("8", 0);
		q.getNewAnswer("32", 0);
		newExam.addQuestion(q);

		// Third Question
		q = new MCSAQuestion("How many steps are in the first flight of UIC's library?");
		q.getNewAnswer("9", 0);
		q.getNewAnswer("15", 1);
		q.getNewAnswer("13", 0);
		q.getNewAnswer("10", 0);
		q.getNewAnswer("42", 0);
		newExam.addQuestion(q);

		// Fourth Question
		q = new MCSAQuestion("What is the speed of light in m/s ?");
		q.getNewAnswer("299792458", 1);
		q.getNewAnswer("186282", 0.5);
		q.getNewAnswer("9192631770", 0);
		q.getNewAnswer("9.10938215 * 10^{-31}", 0);
		newExam.addQuestion(q);

		// Fifth Question
		q = new MCSAQuestion("What is the ASCII encoding in hexadecimal for 'Hello world!'?");
		q.getNewAnswer("0x4920646f6e2774206b6e6f772e", 0);
		q.getNewAnswer("0x48656c6c6f20776f626c6421", 1);
		q.getNewAnswer("0x466f6f2062617221", 0);
		q.getNewAnswer("0x54686973206578616d2064756d622e", 0);
		q.getNewAnswer("4f6e6520646f6573206e6f742073696d707c792062616c616e63652062696e61727920736561726368207472656573", 0);
		newExam.addQuestion(q);

		// Sixth Question
		q = new MCSAQuestion("Which of the the following will be prizes at the CS Scavenger hosted by WICS?");
		q.getNewAnswer("VR Headset", 1);
		q.getNewAnswer("Raspberry Pi", 1);
		q.getNewAnswer("T-1000", 0);
		q.getNewAnswer("4096 Drummers Drumming", 0);
		q.getNewAnswer("1024 Lords a-Leaping", 0);
		newExam.addQuestion(q);

		// Step 2: Print the Exam
		System.out.println("Step 2: Printing exam...\n");
		newExam.print();

		// Step 3: Reorder questions on exam and answers. Then print
		System.out.println("Step 3: Reordering questions and Answers \n");
		newExam.reorderQuestions();
		newExam.reorderMCAnswers(-1);

		newExam.print();

		// Step 4: Select Answer to some or all of questions

		// newExam.print();

		// Step 5
		System.out.println("Grading exam...\n");
		System.out.printf("Score: %f\n", newExam.getValue());
	}
}
