import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.Locale;

public class ExamGrader {
	public static void main(String args[]) {
		// Step 1: Load up an exam file and answer file, confiriming that they match
		System.out.println("Please enter an Exam file:");
		String examFileName = ScannerFactory.getKeyboardScanner().nextLine();
		File examFile = new File(examFileName);
		Scanner scExam = null; 
		Scanner scExamAnswers = null;
		PrintWriter pwCSV = null;
		while (!examFile.exists()) {
			System.out.println("Hmmm... for some reason, file does not exist. Please try again:");
			examFileName = ScannerFactory.getKeyboardScanner().nextLine();
			examFile = new File(examFileName);
		}

		try {
			scExam = new Scanner(examFile);
		} catch (FileNotFoundException e) {
			System.out.println("Was trying to create scanner object from exam file...");
			System.out.println("Something must be really wrong...\n");
			e.printStackTrace();
		}

		String examNameInExamFile = "";
		while (examNameInExamFile == "") {
			examNameInExamFile = scExam.nextLine();
		}

		System.out.println("Now please enter an answer file:");
		String examAnswerFileName = ScannerFactory.getKeyboardScanner().nextLine();
		System.out.printf("examAnswerFileName: %s\n", examAnswerFileName);
		File examAnswerFile = new File(examAnswerFileName);
		while (!examAnswerFile.exists()) {
			System.out.println("Hmmm... for some reason, file does not exist. Please try again:");
			examAnswerFileName = ScannerFactory.getKeyboardScanner().nextLine();
			examFile = new File(examAnswerFileName);
		}

		try {
			scExamAnswers = new Scanner(examAnswerFile);
		} catch (FileNotFoundException e) {
			System.out.println("Was trying to create scanner object from answers file...");
			System.out.println("Something must be really wrong...");
			e.printStackTrace();
		}

		String studentName = scExamAnswers.nextLine();
		System.out.printf("studentName: %s\n", studentName);
		String examNameInAnsFile = "";
		while (examNameInAnsFile == "") {
			examNameInAnsFile = scExamAnswers.nextLine();
		}

		if (!examNameInExamFile.equals(examNameInAnsFile)) {
			System.out.println("Exam file and answer file are not matching set!\n");
			System.out.printf("exam name in exam file: %s\n", examNameInExamFile);
			System.out.printf("exam name in ansswer file: %s\n", examNameInAnsFile);
		} else {
			System.out.println("Exam file and answer file match.\n");
		}

		Exam studentExam = new Exam(scExam);
		studentExam.print();
		studentExam.restoreStudentAnswers(scExamAnswers);
		studentExam.print();

		//Step 2: Evaluate the answers and report the results to the screen. 
		studentExam.reportQuestionValues();

		System.out.println("Now please enter a csv file name:\n");
		String CSVFileName = ScannerFactory.getKeyboardScanner().nextLine();
		File CSVFile = new File(CSVFileName);
		while (!CSVFile.exists()) {
			System.out.println("Hmmm... for some reason, file does not exist. Please try again:");
			CSVFileName = ScannerFactory.getKeyboardScanner().nextLine();
			CSVFile = new File(examAnswerFileName);
		}

		try {
			pwCSV = new PrintWriter(CSVFile);
		} catch (FileNotFoundException e) {
			System.out.println("Was trying to create a PrintWriter object from a CSV file...");
			System.out.println("Something must be really wrong...");
			e.printStackTrace();
		}

		// Step 3: Save student answers to CSV file
		pwCSV.printf("%s\n", studentName);
		studentExam.saveScore(pwCSV);
		pwCSV.close();
	}
}
