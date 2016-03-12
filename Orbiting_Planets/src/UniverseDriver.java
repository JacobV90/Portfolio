import javax.swing.SwingUtilities;

/**
 * The UnvierseDriver class creates and runs the Universe class and sets 
 * the frame visibility to true.
 * 
 * @author Jacob Veal
 *
 */
public class UniverseDriver {

	/**
	 * The main method that runs the application
	 * 
	 * @param args - command line argument
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {

				Universe universe = new Universe();
				universe.setVisible(true);
			}

		});

	}
}
