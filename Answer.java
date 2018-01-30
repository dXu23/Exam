// Name: Daniel Xu
// NetId: dxu23
public class Answer {
	private String _A;
	private boolean _selected;
	private double _selectedValue;
	private double _unselectedValue;

	// Constructor 
	Answer(String A) {
		_A = A;
		this.setSelected(false);
	}

	// Set Methods
	public void setSelected(boolean selected) {
		_selected = selected;
	}

	public void setValue(double selectedValue, double unselectedValue) {
		_selectedValue = selectedValue;
		_unselectedValue = unselectedValue;
	}

	// Get Methods

	public String getA() {
		return _A;
	}

	public boolean isSelected() {
		return _selected;
	}

	public double getValue() {
		if (_selected == true) {
			return _selectedValue;
		} else if (_selected == false) {
			return _unselectedValue;
		}
		return 0;
	}

	// Miscelleaneous

	public void print(int position) { 
        // Add 0x41 since 0x41 is ASCII hexadecimal for 'A'
		// System.out.println("Hello, world!\n");
		if (this.isSelected()) {
			System.out.printf("[%c] %s\n", position + 0x41, _A);
		} else {
			System.out.printf("(%c) %s\n", position + 0x41, _A);
		}
	}
}
