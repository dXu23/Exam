import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NumQuestion extends Question {
	// double tolerance;

	public NumQuestion(String text, double maxValue) {
		super(text, maxValue);
	}

	public NumQuestion(Scanner input) {
		super(input);
		rightAnswer = new NumAnswer(input);
	}

	public Answer getNewAnswer() {
		System.out.println("Please enter a numerical value and a tolerance level for your answer.");
		rightAnswer = new NumAnswer(ScannerFactory.getKeyboardScanner());
		ScannerFactory.getKeyboardScanner().nextLine();
		return rightAnswer;
	}

	public void getAnswerFromStudent() {
		System.out.println("Please enter a numerical answer:");
		double val = ScannerFactory.getKeyboardScanner().nextDouble();
		studentAnswer = new NumAnswer(val);
		ScannerFactory.getKeyboardScanner().nextLine();
		// Advance Scanner to next line, so question coming after this one will parse input instead 
		// just getting an EOL character. 
		return;
	}

	public double getValue() {
		return maxValue * studentAnswer.getCredit(rightAnswer);
	}

	public void save(PrintWriter output) {
		output.println("NumQuestion");
		output.printf("%.1f\n" + 
				"%s\n", this.maxValue, this.text);
		output.printf("%.2f\n%.2f", ((NumAnswer) rightAnswer).val, ((NumAnswer) rightAnswer).tolerance);
	}

	public void restoreStudentAnswers(Scanner input) {
		System.out.printf("In restoreStudentAnswers of NumQuestion right now...\n");
		String something = input.nextLine();
		System.out.printf("%s\n", something);
		if (!something.equals("NumAnswer")) {
			System.out.println("Warning! NumQuestion in Exam object not matching that of file!");
		}
		studentAnswer = new NumAnswer(input.nextDouble());
	}

	public JPanel createPanel() {
		JPanel questionPanel = new JPanel();
		JLabel questionText = new JLabel(this.text);
		JLabel prompt = new JLabel("Your answer:");
		JTextField SAstudentAnswer = new JTextField("");
		return questionPanel;
	}

}
