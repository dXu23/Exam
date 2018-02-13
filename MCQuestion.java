
import java.util.ArrayList;
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
		  * @return Nothing
		  */

		answers.add(Answer);
	}

	public void reorderAnswers() {
		Collections.shuffle(answers);
	}

	/*
	private void swapAnswers(int posFirst, int posSecond) {
		Answer tempAns = aArray[posFirst];
		aArray[posFirst] = aArray[posSecond];
		aArray[posSecond] = tempAns;
	}

	public void reorderAnswers() {
		Collections.shuffle();
		Random rand = new Random();
		int randNumA;
		int randNumB;
		int iterTotal = N * 4;
		for (int i = 0; i < iterTotal; i++) {
			randNumA = rand.nextInt(N);
			randNumB = rand.nextInt(N);
			swapAnswers(randNumA, randNumB);
		}
	}
	*/
	public void print() {
		System.out.printf("%s\n", text);
		// System.out.printf("numAns: %d\n", numAns);
		char i = 'A';
		for (Answer ans: answers) {
			if (ans.selected) {
				System.out.printf("[%c]. ", i++);
			} else {
				System.out.printf("(%c). ", i++);
			}
            answers.get(i).print();
		}
	}
}
