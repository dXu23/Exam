/** @author Daniel Xu
    @version 1.1
*/
abstract class Answer {

	// Constructor 
	/**
	 * Constructs an Answer object
	 */
	protected Answer() {
	}

	/**
	  * Prints the Answer
	  */
	abstract void print();

	/**
	 * Gets credit for a Answer object by comparing it to a rightAnswer object
	 * @param rightAnswer right Answer to be compared to this Answer
	 * @return Credit given to the Answer
	 */
	abstract double getCredit(Answer rightAnswer);

}

