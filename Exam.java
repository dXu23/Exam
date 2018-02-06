// Name: Daniel Xu
// NetId: dxu23

import java.util.Random;

public class Exam {
	private String _header;
	private int numQuestions;
	private Question [] qArray;
	Exam(String header) {
		System.out.printf("Creating new exam with header %s...\n", header);
		_header = header;
		numQuestions = 0;
		qArray = new Question [10];
	}

	// Get Method
	public String getHeader() {
		return this._header;
	}

	public int getNumQuestions() {
		return numQuestions;
	}

	// Set Methods
	public void addQuestion(Question Q) {
		// In case user enters more questions than there is memory in qArray
		if (numQuestions >= qArray.length) {
			Question [] qTmp = new Question[2 * qArray.length];
			System.arraycopy(qArray, 0, qTmp, 0, qArray.length);
			qArray = qTmp;
		} 
		qArray[numQuestions] = Q;
		this.numQuestions = this.numQuestions + 1;
	}

	public Question getQuestion(int position) {
		return qArray[position];
	}

	public void print() {
		System.out.printf("%s\n", getHeader());
		for (int i = 0; i < this.numQuestions; i++) {
			System.out.printf("%d. ", i);
			getQuestion(i).print();
		}
	}

	private void swapQuestions(int posFirst, int posSecond) {
		Question tempAns = qArray[posFirst];
		qArray[posFirst] = qArray[posSecond];
		qArray[posSecond] = tempAns;
	}

	public void reorderQuestions() {
		Random rand = new Random();
		int randNumA;
		int randNumB;
		int numQ = getNumQuestions();
		int iterTotal = numQ * 4; // Randomly swap two elements 4 * numQ times
		for (int i = 0; i < iterTotal; i++) { // Use variable to reduce runtime
			randNumA = rand.nextInt(numQ);
			randNumB = rand.nextInt(numQ);
			swapQuestions(randNumA, randNumB);
		}
	}

	double getValue() {
		int numQ = getNumQuestions();
		double total = 0;
		for (int i = 0; i < numQ; i++) {
			total += qArray[i].getValue();
		}
		return total;
	}
}

