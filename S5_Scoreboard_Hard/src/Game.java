import java.util.ArrayList;

/**
 * The abstract class "Game" is the superclass of 4 subclasses. This class
 * contains methods and variables that are all common to the subclasses. As well
 * has two composite classes. This class simulates a sports game between teams.
 * 
 * @author Jacob Veal
 *
 */
public abstract class Game {

	/**
	 * An array list holding the team class objects
	 */
	private ArrayList<Team> teams = new ArrayList<Team>();
	
	/**
	 * An array ist holding the scoringMethod class objects
	 */
	protected ArrayList<ScoringMethods> scoringMethod = new ArrayList<ScoringMethods>();
	
	/**
	 * The number of periods the game has.
	 */
	private int numberOfPeriods;
	
	/**
	 * The name of the period 
	 */
	private String periodName = null;
	
	/**
	 * The current period number
	 */
	private int currentPeriod = 1;
	
	public Game(){
		
	}

	/**
	 * The superclass constructor takes in two "Team" classes as parameters and
	 * stores them in the array "team".
	 * 
	 * @param team1
	 * @param team2
	 */

	public Game(Team team1, Team team2) {
		this.teams.add(team1);
		this.teams.add(team2);
	}

	/**
	 * The "setTeams method sets the team objects in the array "team"
	 * 
	 * @param team1
	 * @param team2
	 */
	void setTeams(Team team1, Team team2) {
		this.teams.add(team1);
		this.teams.add(team2);
	}

	/**
	 * The "getTeams" method returns the specified team object based on the
	 * index passed in
	 * 
	 * @param index
	 * @return Team
	 */
	Team getTeams(int index) {
		return this.teams.get(index);
	}

	/**
	 * The "setNumberOfPeriods" method sets the number of periods the object has
	 * based on the passed in integer.
	 * 
	 * @param n
	 */
	void setNumberOfPeriods(int n) {
		this.numberOfPeriods = n;
	}

	/**
	 * The "getNumberOfPeriods" class returns the number of periods
	 * 
	 * @return numberOfPeriods
	 */
	int getNumberOfPeriods() {
		return this.numberOfPeriods;
	}

	/**
	 * The "setPeriodName" sets the name of the periods in the game
	 * 
	 * @param name
	 */
	void setPeriodName(String name) {
		this.periodName = name;
	}

	/**
	 * The "getPeriodName" returns the name of the periods
	 * 
	 * @return periodName
	 */
	String getPeriodName() {
		return this.periodName;
	}

	void changePeriod() {
		++this.currentPeriod;
	}

	int getCurrentPeriod() {
		return this.currentPeriod;
	}

	/**
	 * The "addScore" method adds points to the passed in team based on the
	 * passed in scoring method object.
	 * 
	 * @param scoringMethod
	 * @param team
	 */
	void addScore(ScoringMethods scoringMethod, Team team) {
		team.addPoints(scoringMethod.getScoringValue());
	}

	/**
	 * The "isGameOVer" method determines if the game is over and returns true
	 * or false
	 * 
	 * @return boolean
	 */
	boolean isGameOver() {
		if (currentPeriod > numberOfPeriods) {
			--currentPeriod;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * The "getScoringMethod" abstract method provides the subclasses an
	 * overrideable method to implement for their specific scoring methods.
	 * 
	 * @return scoringMethod
	 */
	abstract ArrayList<ScoringMethods> getScoringMethod();

	/**
	 * 
	 * @param input
	 */
	void startGame(int input) {
		int index = 0;
		int size = this.getScoringMethod().size();

		if (!(input > 2 * size)) {

			if (input > size) {
				index = 1;
				input = input - size;
			}
			this.addScore(scoringMethod.get(input - 1), this.getTeams(index));
		} else {
			this.changePeriod();
		}
	}

	/**
	 * The "theWinnerIs" method returns the winning team or null if the scores
	 * are the same.
	 * 
	 * @return - Team
	 */
	Team theWinnerIs() {

		Team home = new Team();
		home = this.getTeams(0);
		Team away = new Team();
		away = this.getTeams(1);

		if (home.getScore() == away.getScore() && this.currentPeriod != 1) {
			return null;
		}
		if (home.getScore() > away.getScore()) {
			return home;
		} else {
			return away;
		}
	}

}
