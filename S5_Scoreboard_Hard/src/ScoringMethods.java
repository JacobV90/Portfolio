/**
 * The "ScoringMethod" class represents a scoring method. It sets and returns a point value.
 * 
 * @author Jacob Veal
 *
 */
public class ScoringMethods {
	
	/**
	 * The value of the scoring method
	 */
	private int pointValue = 0;
	
	/**
	 * Name of the scoring method
	 */
	private String pointName;

	/**
	 * The "ScoringMethods" class constructor requires a passed in integer and string
	 * assign to "pointValue" and "pointName"
	 * 
	 * @param pointValue
	 */
	public ScoringMethods(int pointValue, String pointName) {
		this.pointValue = pointValue;
		this.pointName = pointName;
	}

	/**
	 * The "getScoringValue" method returns the value of the specified
	 * point value.
	 * 
	 * @return - pointValue
	 */
	public int getScoringValue() {
		return this.pointValue;
	}
	
	/**
	 * The "getScoringName" returns the name of the scoring method
	 * @return
	 */
	public String getScoringName(){
		return this.pointName;
	}
}
