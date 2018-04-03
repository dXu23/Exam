import java.io.*;
import java.util.Scanner;

public class SAAnswer extends Answer {
	protected String text;

	public SAAnswer(String text) {
		/** SAAnswer constructor */
		this.text = text;
	}

	public SAAnswer(Scanner input) {
		this.text = input.nextLine();
	}

	public void print() {
		/** prints out the answer
		  */
		System.out.printf("%s", text);
	}

	public double getCredit(Answer rightAnswer) {
		/** Gets credit of a particular answer
		  * by comparing it to the right answer
		  * @param rightAnswer right Answer that is to be compared to this answer
		  */
		//System.out.printf("studentAnswer: %s", this.text);
		/*
		byte []stdntAnsBytes = this.text.getBytes();
		for (byte b: stdntAnsBytes) {
			System.out.println(b);
		}
		*/
		//System.out.printf("rightAnswer: %s", ((SAAnswer) rightAnswer).text);
		/*
		byte []rightAnsBytes = ((SAAnswer) rightAnswer).text.getBytes();
		for (byte b: rightAnsBytes) {
			System.out.println(b);
		}
		*/
		if (text.toUpperCase().equals(((SAAnswer) rightAnswer).text.toUpperCase())) {
			return 1;
		} else {
			return 0;
		}
	}

	public void save(PrintWriter output) {
		output.printf("%s\n", text);
	}

}
