/** @author Daniel Xu
    @version 1.1
*/

import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;

public class Exam {
	private String text;
	private ArrayList<Question> qArrayList;

	Exam(String header) {
		/**
		  Constructs the Exam object
		  @param header This String argument will be the header of the exam
		  @return Exam object. 
		*/
		System.out.printf("Creating new exam with header %s...\n", header);
		text = header;
		qArrayList = new ArrayList<Question>();
	}

	// Get Method
	public String getHeader() {
		return this.text;
	}

	/*
	public int getNumQuestions() {
		return numQuestions;
	}
	*/

	// Set Methods
	public void addQuestion(Question question) {
		// In case user enters more questions than there is memory in qArrayList
		qArrayList.add(question);
	}

	/*
	public Question getQuestion(int position) {
		return qArrayList[position];
	}
	*/

	public void print() {
		System.out.printf("%s\n", text);
		Iterator<Question> iterQuestions = qArrayList.iterator();
		int i = 1;
		while (iterQuestions.hasNext()) {
			System.out.printf("%d. ", i);
			iterQuestions.next().print();
			i++;
		}
	}

/*
	private void swapQuestions(int posFirst, int posSecond) {
		Question tempAns = qArray[posFirst];
		qArray[posFirst] = qArray[posSecond];
		qArray[posSecond] = tempAns;
	}
	*/

	public void reorderQuestions() {
		/**
		  * Randomly reorders questions in Exam object using 
		  * shuffle method from Collections
		  */
		Collections.shuffle(qArrayList);
	}

	double getValue() {
		/**
		  Gets overall score of Exam. 
		  @return Total score of Exam. 
		  */
		Iterator<Question> iterQuestions = qArrayList.iterator();
		double total = 0;
		while (iterQuestions.hasNext()) {
			total += iterQuestions.next().getValue();
		}
		return total;
	}
}

