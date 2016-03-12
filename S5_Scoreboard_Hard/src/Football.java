import java.util.ArrayList;

/**
 * The "Football" class represents a football game. It extends the abstract class "Game".
 * 
 * @author Jacob Veal
 *
 */
public class Football extends Game {

	/**
	 * A scoring method in a game of football
	 */
	private final int touchdown = 6;
	
	/**
	 * A scoring method in a game of football
	 */
	private final int extraPoint = 1;
	
	/**
	 * A scoring method in a game of football
	 */
	private final int fieldgoal = 3;
	
	/**
	 * A scoring method in a game of football
	 */
	private final int safety = 2;
	
	/**
	 * A scoring method in a game of football
	 */
	private final int twoPointConversion = 2;
	
	public Football(){
		super();
		this.initialize();
	}

	/**
	 * The "Football" class constructor calls its super class constructor and specifies
	 * the scoring methods and adds them into the ArrayList "scoringMethod".
	 * 
	 * @param team1
	 * @param team2
	 */
	public Football(Team team1, Team team2) {

		super(team1, team2);
		this.initialize();
		
	}
	
	/**
	 * Initializes a football by game by setting the number of periods, period name, and adding
	 * to the scoring method array .
	 */
	public void initialize(){
		
		try {
			this.setNumberOfPeriods(4);
			this.setPeriodName("quarter");

			scoringMethod.add(new ScoringMethods(touchdown, "Touchdown"));
			scoringMethod.add(new ScoringMethods(extraPoint, "Extra-Point"));
			scoringMethod.add(new ScoringMethods(twoPointConversion, "Two-Point Conversion"));
			scoringMethod.add(new ScoringMethods(safety, "Safety"));
			scoringMethod.add(new ScoringMethods(fieldgoal, "Fieldgoal"));
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
	public ArrayList<ScoringMethods> getScoringMethod() {
		return scoringMethod;
	}
	
	/**
	 * Returns the name of the class
	 */
	@Override
	public String toString(){
		return String.format("FootBall");
				
	}

}
