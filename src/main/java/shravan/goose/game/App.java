package shravan.goose.game;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class App {
	
	List<Player> players = new ArrayList<Player>();
	Set<String> names = new LinkedHashSet<String>();
	boolean playersReady = false;

    public static void main(String[] args) {
    	System.out.println("********Welcome to Goose game kata********");
    	App app = new App();
    	app.addPlayers();
    }

	private void addPlayers() {
		Scanner in = new Scanner(System.in);
		String pattern ="-?\\d+";
		System.out.println("Enter 1 to add players");
		System.out.println("Enter 2 to start game");
		String value = in.nextLine();
		if(value.matches(pattern)) {
			switch (Integer.valueOf(value)) {
			case 1:
				Scanner player = new Scanner(System.in);
				System.out.println("Enter "+ (players.size()+1) +" st Player name");
				String name = player.nextLine();
				//player.close();
				if(isDuplicate(name)) {
					System.out.println(name +" already existing player");
					addPlayers();
				}else {
					Player p = new Player(name);
					players.add(p);
					addPlayers();
				}
				break;
			case 2:
				startGame();
				break;
			default:
				System.out.println("---Invalid Option---");
				addPlayers();
				break;
			}
		}else {
			System.out.println("---Invalid Option---");
			addPlayers();
		}
				
	}

	private void startGame() {
		GameControl gc = new GameControl();
		System.out.println("Game begings");
		int playerIterations = 0;
		while(!gc.isFinshed()) {
			System.out.println(">>>>No.of Player iterations so far: "+playerIterations);
			for(int i = 0; i< players.size(); i++) {
				if(!gc.isFinshed())
					gc.beginDiceRoll(players.get(i), gc);
				else
					break;
			}
			playerIterations++;
		}
		
		System.out.println("Game is Finished: "+gc.isFinshed());
	}

	private boolean isDuplicate(String name) {
		if(names.contains(name.toLowerCase()))
			return true;
		else
			names.add(name.toLowerCase());
			return false;
	}
}
