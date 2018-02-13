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
		newExam.addQuestion(new MCSAQuestion("What is the derivative of e^x?"));
		MCSAAnswer a = new MCSAAnswer("e^x");
		a.setValue(4, 0);
		newExam.getQuestion(0).addAnswer(a);
		a = new Answer("sin x");
		a.setValue(0, 0);
		newExam.getQuestion(0).addAnswer(a);
		a = new Answer("cos x");
		a.setValue(0, 0);
		newExam.getQuestion(0).addAnswer(a);
		a = new Answer("x");
		a.setValue(0, 0);
		newExam.getQuestion(0).addAnswer(a);
		a = new Answer("tan x");
		a.setValue(0, 0);
		newExam.getQuestion(0).addAnswer(a);
		newExam.addQuestion(new MCSAQuestion("How many bytes are in an int?"));
		a = new Answer("4");
		a.setValue(4, 0);
		newExam.getQuestion(1).addAnswer(a);
		a = new Answer("96");
		a.setValue(0, 0);
		newExam.getQuestion(1).addAnswer(a);
		a = new Answer("16");
		a.setValue(0, 0);
		newExam.getQuestion(1).addAnswer(a);
		a = new Answer("8");
		a.setValue(0, 0);
		newExam.getQuestion(1).addAnswer(a);
		a = new Answer("32");
		a.setValue(0, 0);
		newExam.getQuestion(1).addAnswer(a);
		newExam.addQuestion(new Question("How many steps are in the first flight of UIC's library?"));
		a = new Answer("9");
		a.setValue(0, 0);
		newExam.getQuestion(2).addAnswer(a);
		a = new Answer("15");
		a.setValue(4, 0);
		newExam.getQuestion(2).addAnswer(a);
		a = new Answer("13");
		a.setValue(0, 0);
		newExam.getQuestion(2).addAnswer(a);
		a = new Answer("10");
		a.setValue(0, 0);
		newExam.getQuestion(2).addAnswer(a);
		a = new Answer("42");
		a.setValue(0, 0);
		newExam.getQuestion(2).addAnswer(a);
		newExam.addQuestion(new Question("What is the speed of light in m/s ?"));
		a = new Answer("299792458");
		a.setValue(4, 0);
		newExam.getQuestion(3).addAnswer(a);
		a = new Answer("186282");
		a.setValue(0, 0);
		newExam.getQuestion(3).addAnswer(a);
		a = new Answer("340");
		a.setValue(0, 0);
		newExam.getQuestion(3).addAnswer(a);
		a = new Answer("9192631770");
		a.setValue(0, 0);
		newExam.getQuestion(3).addAnswer(a);
		a = new Answer("9.10938215 * 10^{-31}");
		a.setValue(0, 0);
		newExam.getQuestion(3).addAnswer(a);
		newExam.addQuestion(new Question("What is the ASCII encoding in hexadecimal for 'Hello world!'?"));
		a = new Answer("0x4920646f6e2774206b6e6f772e");
		a.setValue(0, 0);
		newExam.getQuestion(4).addAnswer(a);
		a = new Answer("0x48656c6c6f20776f626c6421");
		a.setValue(4, 0);
		newExam.getQuestion(4).addAnswer(a);
		a = new Answer("0x466f6f2062617221");
		a.setValue(0, 0);
		newExam.getQuestion(4).addAnswer(a);
		a = new Answer("0x54686973206578616d2064756d622e");
		a.setValue(0, 0);
		newExam.getQuestion(4).addAnswer(a);
		a = new Answer("4f6e6520646f6573206e6f742073696d707c792062616c616e63652062696e61727920736561726368207472656573");
		a.setValue(0, 0);
		newExam.getQuestion(4).addAnswer(a);
		newExam.addQuestion(new Question("Which of the the following will be prizes at the CS Scavenger hosted by WICS?"));
		a = new Answer("VR Headset");
		a.setValue(2, 0);
		newExam.getQuestion(5).addAnswer(a);
		a = new Answer("Raspberry Pi");
		a.setValue(2, 0);
		newExam.getQuestion(5).addAnswer(a);
		a = new Answer("T-1000");
		a.setValue(-2, 0);
		newExam.getQuestion(5).addAnswer(a);
		a = new Answer("4096 Drummers Drumming");
		a.setValue(-2, 0);
		newExam.getQuestion(5).addAnswer(a);
		a = new Answer("1024 Lords a-Leaping");
		a.setValue(-2, 0);
		newExam.getQuestion(5).addAnswer(a);

		// Step 2: Print the Exam
		System.out.println("Step 2: Printing exam...\n");
		newExam.print();

		// Step 3: Reorder questions on exam and answers. Then print
		System.out.println("Step 3: Reordering questions and Answers \n");
		newExam.reorderQuestions();
		for (int j = 0; j < newExam.getNumQuestions(); j++) { 
			newExam.getQuestion(j).reorderAnswers();
		}

		newExam.print();

		// Step 4: Select Answer to some or all of questions
		newExam.getQuestion(0).selectAnswer(4);
		newExam.getQuestion(1).selectAnswer(2);
		newExam.getQuestion(2).selectAnswer(3);
		newExam.getQuestion(3).selectAnswer(0);
		newExam.getQuestion(4).selectAnswer(1);
		newExam.getQuestion(5).selectAnswer(3);
		newExam.getQuestion(5).selectAnswer(2);

		// newExam.print();

		// Step 5
		System.out.println("Grading exam...\n");
		System.out.printf("Score: %f\n", newExam.getValue());
	}
}
