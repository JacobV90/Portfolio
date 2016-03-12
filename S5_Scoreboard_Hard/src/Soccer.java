import java.util.ArrayList;

/**
 * The "Soccer" class represents a soccer game. It extends the abstract class
 * "Game".
 * 
 * @author Jacob Veal
 *
 */
public class Soccer extends Game {

	/**
	 * The scoring method in a game of soccer
	 */
	private int goal = 1;

	/**
	 * calls the super class constructor and the initialize method
	 * 
	 */
	public Soccer() {

		super();
		initialize();

	}
	/**
	 * calls the super class constructor and the initialize method
	 * 
	 * @param team1
	 * @param team2
	 */
	public Soccer(Team team1, Team team2) {

		super(team1, team2);
		initialize();

	}
	/**
	 * specifies the scoring methods and adds them into the ArrayList
	 * "scoringMethod".
	 */
	public void initialize() {
		try {
			this.setNumberOfPeriods(2);
			this.setPeriodName("half");

			scoringMethod.add(new ScoringMethods(goal, "goal"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * The overriden "getScoringMethod" method returns the ArrayList
	 * "scoringMethod" specific to this class
	 * 
	 * @return scoringMethod
	 */
	@Override
	ArrayList<ScoringMethods> getScoringMethod() {
		return scoringMethod;
	}

	/**
	 * Returns the name of this class
	 */
	@Override
	public String toString() {
		return String.format("Soccer");
	}

}
