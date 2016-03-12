import java.util.ArrayList;
import java.util.Scanner;

/**
 * The "GameTest" class stimulates sport games by displaying a menu of different games to play.
 * Once a game is selected two team names are prompted for input then a scoredboard and a scoring 
 * menu is displayed.
 * 
 * @author Jacob Veal
 *
 */
public class GameTest {

	/**
	 * The names of the two teams in the game
	 */
	private static String teamName1, teamName2;
	
	/**
	 * The input stream the class uses to receive inputs from the user
	 */
	private static Scanner sc;
	
	/**
	 * The input received from the user
	 */
	private static int input = 0;
	
	/**
	 * An array list holding the different games that can be created and simulated
	 */
	private static ArrayList<Game> games = new ArrayList<Game>();
	
	/**
	 * The main method to run the application
	 * 
	 * @param args - command line argument
	 */
	public static void main(String args[]) {
		
		
		
		games.add(new Basketball());
		games.add(new Football());
		games.add(new Soccer());
		games.add(new Hockey());
		

		displayStartMenu();
		sc = new Scanner(System.in);

		while (input != games.size() + 1) {
			
			try {
				
				try{
				input = sc.nextInt();
				Game game = games.get(input - 1);
				
				
					if (input != games.size() + 1) {
						getTeams();
						Team team1 = new Team(teamName1);
						Team team2 = new Team(teamName2);
						game.setTeams(team1, team2);
						runGame(game);
						displayStartMenu();
						}
						
					 else {
						System.out.printf("\nTanks for playing!\n");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (Exception e) {

				e.printStackTrace();
			}
			
			
		}
		
		sc.close();
	}

	/**
	 * Displays the start menu consisting of the different types of sports games 
	 * to play.
	 */
	private static void displayStartMenu() {

		int i = 0;
		System.out.println("Select a game to play:");
		for (i = 0; i < games.size(); ++i) {
			System.out.printf("%d. %s\n", i + 1, games.get(i).toString());
		}
		System.out.printf("%d. Exit\nChoice: ", i + 1);
	}

	/**
	 * Displays the scoring method menu receiving information from the passed in game object
	 * 
	 * @param game
	 */
	private static void displayGameMenu(Game game) {

		int size = game.getScoringMethod().size();
		int i = 0;
		for (int j = 0; j < 2; ++j) {
			for (i = 0; i < size; ++i) {
				System.out.printf("%d. %s %s\n", (j == 0) ? i + 1 : i + size + 1, game.getTeams(j).getTeamName(),
						game.scoringMethod.get(i).getScoringName());
			}
		}
		System.out.printf("%d. End %s \n", i + size + 1, game.getPeriodName());
		System.out.printf("Choice:");
	}

	/**
	 * Displays the score board of the passing game object.
	 * 
	 * @param game
	 */
	private static void displayScoreBoard(Game game) {

		Team home = game.getTeams(0);
		Team away = game.getTeams(1);

		System.out.printf("\n%s - %d   %s - %d\n%s: %d\n\n", home.getTeamName(), home.getScore(), away.getTeamName(),
				away.getScore(), game.getPeriodName(), game.getCurrentPeriod());
	}

	/**
	 * Prompts the user two input two strings and sets the team name of both teams
	 * 
	 */
	private static void getTeams() {

		System.out.printf("Enter home team:");
		teamName1 = sc.next();
		System.out.printf("Enter away team:");
		teamName2 = sc.next();

	}

	/**
	 * Displays the scored board and the scoring method menu until the method "isGameOVer"
	 * returns a true value. Then displays which team had the most points.
	 * 
	 * @param game
	 */
	private static void runGame(Game game) {

		while (!game.isGameOver()) {
			displayScoreBoard(game);
			displayGameMenu(game);
			input = sc.nextInt();
			game.startGame(input);
		}

		if (game.theWinnerIs() != null) {
			System.out.printf("\nThe winner is %s!\n", game.theWinnerIs().getTeamName());
			displayScoreBoard(game);
		} else {
			System.out.printf("\nIt's a tie!");
			displayScoreBoard(game);
		}
	}
}
