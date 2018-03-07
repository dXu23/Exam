
import java.util.ArrayList;
import java.util.Collections;

public abstract class MCQuestion extends Question {
	// Members
	protected ArrayList<MCAnswer> answers;
	
	// Constructor
	MCQuestion(String text, double maxValue) {
		super(text, maxValue);
		answers = new ArrayList<MCAnswer>();
	}

	MCQuestion(String text) {
		this(text, 1);
	}

	public void addAnswer(MCAnswer MCA) {
		/**
		  * Adds an answer to the Question
		  * @param MCA Answer to be added
		  */

		/*
		if (answers == null) {
			System.out.println("Answers was null");
		}
		*/
		// System.out.println("Answers was not null");
		answers.add(MCA);
	}

	public void reorderAnswers() {
		/**
		 * reorders MCAnswers in MCQuestion
		 */

		Collections.shuffle(answers);
	}

	public double getValue(MCAnswer MCAns) {
		double value = 0;
		try {
			for (Answer loopMCAns : answers) {
				if (MCAns.getCredit(loopMCAns) != 0.0) {
					value = MCAns.getCredit(loopMCAns) * maxValue;
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println(e);
			System.out.println("getAnswerFromStudent was likely not called for some MCQuestion.");
			System.out.println("You might want to double-check the number of getAnswerFromStudent calls");
			System.exit(0);
		}
		return value;
	}

	public void print() {
		super.print();
		// System.out.printf("numAns: %d\n", numAns);
		int i = 0;
		for (MCAnswer ans: answers) {
			if (ans.selected) {
				System.out.printf("[%c]. ", i + 0x41);
			} else {
				System.out.printf("(%c). ", i + 0x41);
			}
            answers.get(i).print();
            System.out.print("\n");
            i++;
		}
		System.out.print("\n");
	}
}
