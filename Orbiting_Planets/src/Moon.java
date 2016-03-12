import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

/**
 * The "Moon" class represents a moon. The constructor class is called in the "Universe" class.
 * 
 * @author Jacob Veal
 *
 */
@SuppressWarnings("serial")
public class Moon extends ObjectsInSpace {
	/**
	 * xCon: X component of the location at the center of rotation
	 */
	private int xCOR = 0;
	
	/**
	 * yCon: y component of the location at the center of rotation
	 */
	private int yCOR = 0;
	

	/**
	 * 2 Parameter constructor for class "Moon"
	 * 
	 * @param name name of the moon
	 * @param distance radial distance from the center of rotation
	 */
	public Moon(String name, int distance) {
		super(name, distance);
	}

	/**
	 * The "run" method  renders the object at every location. Sets the next position repaint the component 
	 * makes the thread sleep before running the loop again.
	 */
	@Override
	public void run() {
		
		renderOrbitingObject();
		setDiameter(15);
		
		while (true) {

			try {
				getNextPosition();
				repaint();
				Thread.sleep(speed);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
	
	/**
	 * The "setCor" updates the xCOR and yCOR variables
	 * @param x: X component of the location at the center of rotation
	 * @param y: Y component of the location at the center of rotation
	 */
	public void setCOR(int x, int y) {
		this.xCOR = x;
		this.yCOR = y;

	}
	/**
	 * The "run" method renders the object, gets the new position and updates the GUI.
	 */
	public void paint(Graphics g) {

		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.setColor(color);
		
		int x = (Universe.DEM_WIDTH / 2) - (getDiameter() / 2);
		int y = (Universe.DEM_WIDTH / 2) - (getDiameter() / 2);


		g2d.fillOval(x + xCOR + (int) positions[0][positionCounter], y + yCOR + (int) positions[1][positionCounter], getDiameter(),
				getDiameter());

		Toolkit.getDefaultToolkit().sync(); //used for Linux computers
		g.dispose();

	}
}
