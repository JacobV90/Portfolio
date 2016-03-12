import java.util.ArrayList;
/**
 * The "Basketball" class represents a football game. It extends the abstract class "Game".
 * 
 * @author Jacob Veal
 *
 */
public class Basketball extends Game {

	/**
	 * A scoring method in a game of basketball
	 */
	private int freethrow = 1;
	
	/**
	 * A scoring method in a game of basketball
	 */
	private int twoPointShot = 2;
	
	/**
	 * A scoring method in a game of basketball
	 */
	private int threePointShot = 3;
	
	public Basketball(){
		super();
		initialize();
	}

	/**
	 * The "Basketball" class constructor calls its super class constructor and specifies
	 * the scoring methods and adds them into the ArrayList "scoringMethod".
	 * 
	 * @param team1
	 * @param team2
	 */
	public Basketball(Team team1, Team team2) {

		super(team1, team2);
		initialize();
		

	}
	
	/**
	 * Initializes a basketball by game by setting the number of periods, period name, and adding
	 * to the scoring method array .
	 */
	private void initialize(){
		
		try {
			this.setNumberOfPeriods(4);
			this.setPeriodName("quarter");

			scoringMethod.add(new ScoringMethods(freethrow, "freethrow"));
			scoringMethod.add(new ScoringMethods(twoPointShot, "twoPointShot"));
			scoringMethod.add(new ScoringMethods(threePointShot, "threePointShot"));
		} catch (Exception e) {
	
			e.printStackTrace();
		}
	}

	/**
	 * The overriden "getScoringMethod" abstract method returns the ArrayList "scoringMethod"
	 * specific to this class
	 * 
	 * @return scoringMethod
	 */
	@Override
	ArrayList<ScoringMethods> getScoringMethod() {
		return scoringMethod;
	}
	
	/**
	 * Returns the name of the class
	 */
	@Override
	public String toString(){
		return String.format("Basketball");
	}

}
