/**
 * @author Rodhit
 */

import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.Locale;
public class ExamBuilder {
	public static void main(String args[]) {
		String commandLine;
		String cmdArgs[];
		String examFileName;
		Scanner examInput = null;
		int questionNo;
		File examFile = null;
		Exam newExam = null;
		System.out.println("Please enter some commands:\n");
		System.out.println(">");
		commandLine = ScannerFactory.getKeyboardScanner().nextLine();
		cmdArgs = commandLine.split("\\s");
		switch (cmdArgs[0]) {
			case "load":
				examFileName = cmdArgs[1];
				examFile = new File(examFileName);

				try {
					examInput = new Scanner(examFile);
				} catch (FileNotFoundException e) {
					System.out.println("File not found. Please check whether file is in directory or not.");
				}

				// Create new Exam object
				newExam = new Exam(examInput);
				break;
			case "add":
				switch (cmdArgs[2]) {
					case "MCMAQuestion":
					case "MCSAQuestion":
					case "NumQuestion":
					case "SAQuestion":
				}
				break;
			case "remove":
				break;
			case "questionReorder":
				newExam.reorderQuestions();
				break;
			case "answerReorder":
				if (cmdArgs[1].equals("all")) {
					newExam.reorderMCAnswers(-1);
				} else {
					questionNo = Integer.parseInt(cmdArgs[2]);
				}
				break;
			case "print":
				newExam.print();
				break;
			case "quit":
				break;
			default:
				System.out.println("You did not enter a valid command. Please try again.\n");
		}
	}
}
