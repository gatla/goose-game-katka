package shravan.goose.game;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameControl {

	List<Integer> gooosePostions = Arrays.asList(5, 9, 14, 18, 23, 27);
	
	int theBridge = 6;
    
	private boolean isFinshed = false;

	public void setFinshed(boolean isFinshed) {
		this.isFinshed = isFinshed;
	}

	/**
	 * @return the isFinshed
	 */
	public boolean isFinshed() {
		return isFinshed;
	}
	
	public void beginDiceRoll(Player player, GameControl gc){
		//Roll Dice for current Player
		DiceRoll dc = new DiceRoll();
		System.out.println("Current Position of "+player.getName()+ " is "+ player.getCurrentPostion());
		System.out.println("Player "+player.getName()+ " gets "+ String.valueOf(dc.getValue1()) +", "+ String.valueOf(dc.getValue2()));
		updateNewPosition(player, gc, dc);
	}

	private void updateNewPosition(Player player, GameControl gc, DiceRoll dc) {
		/*Scanner sc = new Scanner(System.in);
		String pattern ="-?\\d+";
		System.out.println("Enter 5 to move player : "+player.getName());
		System.out.println("Enter 0 to skip to next player");
		String value = sc.nextLine();
		if(value.matches(pattern)) {
			switch (Integer.valueOf(value)) {
			case 5:*/
				//check for the bride and update current position
				boolean isBridge = checkIsBridgePositon(player, dc);
				boolean isGreaterThan60 = checkGreaterThan60(player, dc);
				if(isBridge) {
					System.out.println(player.getName()+" gets THE BRIDGE, updating current position to 12.");
					player.setCurrentPostion(12);
				}
				//greatethan60
				else if(isGreaterThan60) {
					System.out.println("New Position greater than 60: updating "+player.getName()+ "positon by 1");
					player.setCurrentPostion(player.getCurrentPostion()+1);
				}else {
					int diceTotal = dc.getValue1()+dc.getValue2();
					int newPositon = player.getCurrentPostion()+diceTotal;
					if(gooosePostions.contains(newPositon)) {
						System.out.println(player.getName()+" gets THE GOOSE POSITION: "+newPositon+" !!!");
						player.setCurrentPostion(newPositon+diceTotal);
					}else {
						player.setCurrentPostion(newPositon);
					}
				}
				//check for winner and update isFinised else continue iterations
				System.out.println("#############Checking for Winner#########################");
				if(player.getCurrentPostion() == 63) {
					System.out.println("******************Player: "+player.getName()+" Wins!!!******************");
					gc.setFinshed(true);
				}else {
					System.out.println("############# No Winner Yet, Game continues #############");
				}
				dc = null;
		/*		break;
			default:
				break;
			}
		}else {
			System.out.println("<<<Wrong Choice>>>>");
			updateNewPosition(player, gc, dc);
		}*/
		
		
	}

	private boolean checkIsBridgePositon(Player player, DiceRoll dc) {
		int diceValue = dc.getValue1() + dc.getValue2();
		int newPosition = player.getCurrentPostion()+diceValue;
		if(player.getCurrentPostion()<6 && newPosition == 6) {
			return true;
		}else {
			return false;
		}
	}

	private boolean checkGreaterThan60(Player player, DiceRoll dc) {
		int diceTotal = dc.getValue1()+dc.getValue2();
		int newPositon = player.getCurrentPostion()+diceTotal;
		if(newPositon > 60)
			return true;
		else
			return false;
	}
}	