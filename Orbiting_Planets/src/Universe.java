import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JFrame;
import javax.swing.OverlayLayout;

/**
 * The "Universe" class which acts like the universe in which it holds the
 * objects in space. The universe is represented by a JFrame. It creates the
 * stars, planets, and moons and are added to the JFrame. Then the universe
 * starts each objects thread.
 * 
 * @author Jacob Veal
 *
 */

@SuppressWarnings("serial")
public class Universe extends JFrame implements KeyListener {

	/**
	 * Width of the frame
	 */
	public static final int DEM_WIDTH = 1000;

	/**
	 * Height of the frame
	 */
	public static final int DEM_HEIGHT = 1000;

	/**
	 * A dimension object with the frame parameters
	 */
	public static Dimension d = new Dimension(DEM_WIDTH, DEM_HEIGHT);

	/**
	 * An array that holds the "Planet" objects
	 */
	private ArrayList<Planet> planets = new ArrayList<Planet>();

	/**
	 * Determines how many planet objects can be created
	 */
	private int numberOfAllowedPlanets = 8;

	/**
	 * Random generator for the class to determine random properties for each
	 * planet
	 */
	private Random randNum = new Random();

	/**
	 * The planet object that the other planet objects rotate around.
	 */
	private Planet star;

	/**
	 * The executor service that calls each planet objects runnable method
	 */
	private ExecutorService executorService = Executors.newCachedThreadPool();

	/**
	 * A no argument constructor that sets up the GUI and creates a single
	 * orbiting planet
	 */
	public Universe() {

		setTitle("Orbiting Planets");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(DEM_WIDTH, DEM_HEIGHT);
		addKeyListener(this);

		star = new Planet("Star", 0);
		star.setDiameter(randNum.nextInt(150) + 50);
		star.setBackground(Color.BLACK);
		star.setForeground(Color.YELLOW);
		star.setOpaque(true);
		star.addMouseListener(new MouseListener() {

			int i = 1;

			/**
			 * Creates and adds a planet to the GUI and calls its runnable
			 * method
			 */
			@Override
			public void mouseClicked(MouseEvent e) {

				if (i < numberOfAllowedPlanets) {
					Planet planet = new Planet("",
							(randNum.nextInt((Universe.DEM_WIDTH / 2) - star.getDiameter()) + star.getDiameter()));
					planets.add(planet);
					star.add(planet);

					star.updateUI();
					executorService.execute(planet);
					++i;
				}

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

		});

		OverlayLayout overlay = new OverlayLayout(star);
		star.setLayout(overlay);

		Planet earth = new Planet("Earth", 150);
		earth.setDiameter(30);

		planets.add(earth);
		star.add(earth);

		add(star);

		executorService.execute(earth);

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	/**
	 * Receives an input from the keyboard, creates a new Moon object and
	 * selects the corresponding planet from the array then calls its
	 * "activateMoon" method and finally updates the GUI.
	 */
	@Override
	public void keyReleased(KeyEvent e) {

		Planet planet;

		try {
			String tempNum = KeyEvent.getKeyText(e.getKeyChar());
			int index = Integer.parseInt(tempNum) - 1;

			if (index < planets.size()) {
				planet = planets.get(index);
				Moon moon = new Moon("moon", randNum.nextInt(50) + (planet.getDiameter() / 2));
				star.add(moon);
				star.validate();
				planet.activateMoon(moon);
			}

		} catch (NumberFormatException e1) {

			e1.printStackTrace();
		}

	}
}