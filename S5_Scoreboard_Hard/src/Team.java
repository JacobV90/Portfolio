/**
 * The "Team" class represents a generic sports team. Providing a team name and
 * score.
 * 
 * @author Jacob Veal
 *
 */
public class Team {

	/**
	 * The name of the team
	 */
	private final String teamName;
	
	/**
	 * The score the team has
	 */
	private int score = 0;

	/**
	 * no parameter constructor
	 */
	public Team(){
		this.teamName = null;
	}
	/**
	 * 
	 * The "Team" class constructor requires a string as a parameter and sets
	 * that string to the team name
	 * 
	 * @param teamName - the name of the team
	 */
	public Team(String teamName) {
		this.teamName = teamName;
	}

	/**
	 * The "getTeamName" method returns the name of the team specified
	 * 
	 * @return - the name of the team
	 */
	public String getTeamName() {
		return this.teamName;
	}

	/**
	 * The "addPoints" method adds points to the variable "score"
	 * 
	 * @param points - number of points to add
	 */
	public void addPoints(int points) {
		this.score += points;
	}

	/**
	 * The "getScore" methods returns the value of "score"
	 * 
	 * @return - the score value
	 */
	public int getScore() {
		return this.score;
	}

}
