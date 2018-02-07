/** 
*  Question.java
*  @author Daniel Xu
*  @version 1.1
*/
import java.util.Random;

public abstract class Question {
	private String text;
	private Answer rightAnswer;
	private Answer studentAnswer;
	private double maxValue;
	private boolean _multiple;
	private int N;
	private int numAns;

	// Constructor
	Question(String text, double maxValue) {
		/**
		  * Constructs the Question object. 
		  * @param text argument that should have the Question text
		  * @param maxValue the maximum value or total possible points of the Question object
		  */
		this.text = text;
		this.maxValue = maxValue
		N = 5;
		aArray = new Answer[N];
		numAns = 0;
	}


	// Set Methods
	public void addAnswer(Answer A) {
		if (numAns >= N) {
			// System.out.printf("numAns: %d, N: %d\n");
			return;
		}
		aArray[numAns] = A;
		numAns = numAns + 1;
		System.out.println("Answer was added.\n");
	}

	public void unselectAnswer(int position) {
		aArray[position].setSelected(false);
	}



	// Get Methods

	public double getValue() {
		double value = 0;
		int len = aArray.length;
		for (int i = 0; i < len; i++) {
			value = value + aArray[i].getValue();
		}
		return value;
	}

	public Answer getNewAnswer() {
		/**
		  * @return Answer object suitably matched to question type
		  */
		Answer newAnswer = new Answer()
		return newAnswer;
	}

	public void print() {
		System.out.printf("%s\n", text);
	}
}

	Question(String Q, boolean multiple) {
		text = Q;
		N = 5;
		aArray = new Answer[N];
		numAns = 0;
		_multiple = multiple;
	}

	public void selectAnswer(int position) {
		if ((position < 0) || (position >= N)) { // Check whether position is valid or not
			return;
		}
		if (_multiple == false) {
			for (int i = 0; i < position; i++) {
				if (aArray[i].isSelected() == true) {
					aArray[i].setSelected(false);
				}
			}
			for (int i = position + 1; i < N; i++) {
				if (aArray[i].isSelected() == true) {
					aArray[i].setSelected(false);
				}
			}
		}
		aArray[position].setSelected(true);
	}

	private void swapAnswers(int posFirst, int posSecond) {
		Answer tempAns = aArray[posFirst];
		aArray[posFirst] = aArray[posSecond];
		aArray[posSecond] = tempAns;
	}

	public void reorderAnswers() {
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
	public void print() {
		System.out.printf("%s\n", getQ());
		// System.out.printf("numAns: %d\n", numAns);
		for (int i = 0; i < numAns; i++) {
			if (aArray[i].isSelected()) {
				System.out.printf("[%c]. ", i + 0x41);
			} else {
				System.out.printf("(%c). ", i + 0x41);
			}
            aArray[i].print();
		}
	}
