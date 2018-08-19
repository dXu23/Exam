/** 
*  Question.java
*  @author Daniel Xu
*  @version 3.0
*/
import java.util.Scanner;
public class MCMAAnswer extends MCAnswer {

	public MCMAAnswer(String text, double creditIfSelected) {
		super(text);
		if ((creditIfSelected < -1) || (creditIfSelected > 1)) {
			this.creditIfSelected = 0;
		} else {
			this.creditIfSelected = creditIfSelected;
		}
	}

	public MCMAAnswer(Scanner input) {
		super(input);
	}

	public double getCredit() {
		if (selected) {
			return creditIfSelected;
		} else {
			return 0;
		}
	}
}
