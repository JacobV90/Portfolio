import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JPanel;

/**
 * 
 * The abstract class "ObjectsInSpace" holds the variables and methods that are common to all in objects in space.
 * The class extends a JPanel for which to draw a circle on the GUI representing that object. Also implements Runnable 
 * so each object has its own thread to calculate its position and update the GUI independently of the event dispatch thread.
 * 
 * @author Jacob Veal
 *
 */

@SuppressWarnings("serial")
public abstract class ObjectsInSpace extends JPanel implements Runnable {

	/**
	 * Name of the space object
	 */
	private String name = null;

	/**
	 * Radial distance from the objects center of rotation
	 */
	private int distance = 0;

	/**
	 * Diameter of the space object
	 */
	private int diameter = 0;

	/**
	 * Direction of rotation. 0 for clockwise, anything else for counter-clockwise
	 */
	protected int direction = 0;

	/**
	 * Speed of the moving space object. Sets how long the objects thread sleeps.
	 */
	protected int speed = 0;

	/**
	 * Color of the space object
	 */
	protected Color color;

	/**
	 * Determines the position to be used
	 */
	protected int positionCounter = 0;

	/**
	 * Total number of positions around the objects center of rotation
	 */
	protected int numberOfPositions = 120;

	/**
	 * An array of the angles between the object and the center of rotation relative to the x-axis
	 */
	protected double angles[] = new double[numberOfPositions];

	/**
	 * A double array containing the x and y components of the objects position;
	 */
	protected double positions[][] = new double[numberOfPositions][numberOfPositions];

	/**
	 * The executor service the "Planet" class uses to call its moons runnable method
	 */
	protected ExecutorService executor = Executors.newCachedThreadPool();

	/**
	 * 2 parameter constructor
	 * 
	 * @param name - name of the object
	 * @param distanceFromStar - radial distance from the objects center of rotation
	 */
	public ObjectsInSpace(String name, int distanceFromStar) {

		this.setName(name);
		this.setDistanceFromStar(distanceFromStar);
		this.setDoubleBuffered(true);
		this.setOpaque(false);
		this.setLayout(null);
	}
	
	/**
	 * Returns the objects name
	 * 
	 * @return - name
	 */
	public String getPlanetName() {
		return name;
	}
	
	/**
	 * Sets the objects name
	 */
	public void setName(String planetName) {
		this.name = planetName;
	}
	
	/**
	 * Returns the radial distance from the objects center of rotation
	 * 
	 * @return - distance
	 */
	public int getDistanceFromStar() {
		return distance;
	}
	
	/**
	 * Sets the radial distance from the objects center of rotation
	 * 
	 * @param distanceFromStar The radial distance from the objects center of rotation
	 */
	public void setDistanceFromStar(int distanceFromStar) {
		this.distance = distanceFromStar;
	}

	/**
	 * Returns the objects diameter 
	 *
	 * @return - diameter
	 */
	public int getDiameter() {
		return diameter;
	}
	
	/**
	 * Sets the objects diameter
	 * 
	 * @param diameter The diameter of the object
	 */
	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}

	/**
	 * Returns the preferred size of the panel
	 * 
	 * @return - JFrames preferred size
	 */
	@Override
	public Dimension getPreferredSize() {
		return Universe.d;
	}
	
	/**
	 * The "renderOrbitingObject" method sets the speed, color, diameter and direction of the object. 
	 * Also calculates its every position based on its distance from the center of rotation;
	 */
	protected void renderOrbitingObject() {

		Random rand = new Random();
		speed = rand.nextInt(100) + 5;

		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();

		color = new Color(r, g, b);
		direction = rand.nextInt(2);
		setDiameter(rand.nextInt(60) + 20);

		int j = 0;
		for (int i = 0; i < numberOfPositions; ++i) {
			angles[i] = Math.toRadians(j);
			j += (360 / numberOfPositions);

		}
		for (j = 0; j < 2; ++j) {
			for (int i = 0; i < numberOfPositions; ++i) {
				if (j == 0) {
					positions[j][i] = getDistanceFromStar() * Math.cos(angles[i]);
				} else {
					positions[j][i] = getDistanceFromStar() * Math.sin(angles[i]);
				}
			}
		}
	}

	/**
	 * The "getNextPosition" method updates the next position of the object
	 */
	protected void getNextPosition() {

		if (direction == 0) {
			if (positionCounter == numberOfPositions - 1) {
				positionCounter = 0;
			}
			++positionCounter;
		} else {
			if (positionCounter == numberOfPositions - 1 || positionCounter == 0) {
				positionCounter = numberOfPositions - 1;
			}
			--positionCounter;
		}
	}

}