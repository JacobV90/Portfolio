import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

/**
 * The "Planet" class represents a planet. It is called in the "Universe" class.
 * 
 * @author Jacob Veal
 *
 */
@SuppressWarnings("serial")
public class Planet extends ObjectsInSpace {

	/**
	 * An array of that holds the class object "Moon"
	 */
	private Moon moons[] = new Moon[2];
	
	/**
	 * Determines how many moons the class object has.
	 */
	private int numberOfMoons = 0;
	
	/**
	 * Determines if the class object "activateMoon" method has been called.
	 */
	private boolean hasMoons = false;
	
	/**
	 * 2 parameter constructor
	 * 
	 * @param name - Name of the planet
	 * @param distance - Radial distance from its star
	 */
	public Planet(String name, int distance) {
		super(name, distance);

	}
	
	/**
	 *  The "run" method renders the object, gets the new position and updates the GUI.
	 */
	@Override
	public void run() {
		
		renderOrbitingObject();
		
		while (true) {

			try {
				getNextPosition();
				if(hasMoons){
					giveNextPosition();
					//System.out.printf("%d\n", this.moon.getCOR());
				}
				repaint();
				Thread.sleep(speed);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
	
	/**
	 * The "giveNextPosition" method passes the current location of the planet to the 
	 * Moon objects in the "moons" array.
	 */
	private void giveNextPosition(){
		
		int x = (int) positions[0][positionCounter];
		int y = (int) positions[1][positionCounter];
		
		for(int i = 0; i < numberOfMoons; ++i){
			
			moons[i].setCOR(x,y);
		}
		
	}

	/**
	 * Adds the passed in moon object to the "moons" array, and then executes its runnable method
	 * @param moon - the moon to execute its runnable method
	 */
	public void activateMoon(Moon moon) {
		
		
		if (numberOfMoons < 2) {
			
			moons[numberOfMoons] = moon;
			executor.execute(moons[numberOfMoons]);
			++numberOfMoons;
			hasMoons = true;
		}
	}
	
	/**
	 *  The "paint" method draws a filled circle at a specified location.
	 */
	public void paint(Graphics g) {

		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;

		int x = (Universe.DEM_WIDTH / 2) - (getDiameter() / 2);
		int y = (Universe.DEM_WIDTH / 2) - (getDiameter() / 2);

		g2d.setColor(color);

		g2d.fillOval(x + (int) positions[0][positionCounter], y + (int) positions[1][positionCounter], getDiameter(),
				getDiameter());

		Toolkit.getDefaultToolkit().sync(); //used for Linux computers
		g.dispose();

	}
}