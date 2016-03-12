import java.util.ArrayList;
/**
 * The "Hockey" class represents a hockey game. It extends the abstract class "Game".
 * 
 * @author Jacob Veal
 *
 */
public class Hockey extends Game {
	/**
	 * The scoring method in a game of Hockey
	 */
	private int goal = 1;
	
	/**
	 * Calls the super class constructor
	 */
	public Hockey(){
		super();
	}

	/**
	 * The "Hockey" class constructor calls its super class constructor and specifies
	 * the scoring methods and adds them into the ArrayList "scoringMethod".
	 * 
	 * @param team1
	 * @param team2  
	 */
	public Hockey(Team team1, Team team2) {

		super(team1, team2);

		this.setNumberOfPeriods(2);
		this.setPeriodName("half");

		scoringMethod.add(new ScoringMethods(goal, "goal"));
	}

	/**
	 * The overriden "getScoringMethod" method returns the ArrayList "scoringMethod"
	 * specific to this class
	 * 
	 * @return scoringMethod
	 */
	@Override
	ArrayList<ScoringMethods> getScoringMethod() {
		return scoringMethod;
	}
	
	/**
	 * Returns the name of the this class
	 */
	@Override
	public String toString(){
		return String.format("Hockey");
	}
}
