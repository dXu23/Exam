import java.util.Scanner;
import java.util.Locale;

public class ScannerFactory {
	private static Scanner keyboardScanner;

	public static Scanner getKeyboardScanner() {
		if (keyboardScanner == null) {
			Locale.setDefault(Locale.US);
			keyboardScanner = new Scanner(System.in);
		}
		return keyboardScanner;
	}
}
