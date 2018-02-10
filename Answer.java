/** @author Daniel Xu
    @version 1.1
*/
public class Answer {

	// Constructor 
	protected Answer() {
	}

	abstract void print() { 
		/**
		  * Prints the Answer
		  */
	}

	// Get Methods
	abstract double getCredit(Answer rightAnswer) {
		/**
		  * Gets credit for Answer
		  */
	}

	// Set Methods

	/*
	public void setValue(double selectedValue, double unselectedValue) {
		_selectedValue = selectedValue;
		_unselectedValue = unselectedValue;
	}
	*/



}

