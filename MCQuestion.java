
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
		for (Answer loopMCAns : answers) {
			if (loopMCAns == null) {
				System.out.println("loopMCAns was null");
			}
			if (MCAns.getCredit(loopMCAns) != 0.0) {
				return MCAns.getCredit(loopMCAns) * maxValue;
			}
		}
		return 0;
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
