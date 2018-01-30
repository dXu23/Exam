// Name: Daniel Xu
// NetId: dxu23
import java.util.Random;

public class Question {
	private String _Q;
	private Answer [] aArray;
	private boolean _multiple;
	private int N;
	private int numAns;

	// Constructor
	Question(String Q) {
		_Q = Q;
		N = 5;
		aArray = new Answer[N];
		numAns = 0;
	}

	Question(String Q, boolean multiple) {
		_Q = Q;
		N = 5;
		aArray = new Answer[N];
		numAns = 0;
		_multiple = multiple;
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

	// Get Methods
	public String getQ() {
		return this._Q;
	}

	public double getValue() {
		double value = 0;
		int len = aArray.length;
		for (int i = 0; i < len; i++) {
			value = value + aArray[i].getValue();
		}
		return value;
	}

	public void print(int position) {
		System.out.printf("%d. %s\n", position + 1, getQ());
		System.out.printf("numAns: %d\n", numAns);
		for (int i = 0; i < numAns; i++) {
			aArray[i].print(i);
		}
	}
}
