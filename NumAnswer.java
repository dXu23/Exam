import java.lang.Math;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.*;
public class NumAnswer extends Answer {
	protected double val;
	public double tolerance;

	public NumAnswer(double val, double tolerance) {
		this.val = val;
		this.tolerance = tolerance;
	}

	public NumAnswer(double val) {
		this(val, 0.01);
	}
	public NumAnswer() {
		this(0);
	}

	public NumAnswer(Scanner input) {
		try {
			val = input.nextDouble();
			tolerance = input.nextDouble();
		} catch(InputMismatchException e) {
			System.out.printf("Either val or tolerance was missing in exam file!\n");
			e.printStackTrace();
		}
		System.out.printf("val: %f\ntolerance: %f\n", val, tolerance);
		input.nextLine();
	}

	public double getTolerance() {
		return tolerance;
	}

	public double getCredit(Answer rightAnswer) {
		if (Math.abs(((NumAnswer) rightAnswer).val - val) < ((NumAnswer) rightAnswer).tolerance) {
			return 1;
		}
		else {
			return 0;
		}
	}

	public void print() {
		System.out.printf("%.1f\n", val);
	}

	public void save(PrintWriter output) {
		output.printf(".1f\n" +
				".1f\n", val, tolerance);
	}

}
