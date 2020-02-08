/**
 * 
 */
package shravan.goose.game;

import java.util.Random;

/**
 * @author Shravan Gatla
 *
 */
public class DiceRoll {
	
	private int value1;
	
	private int value2;
	
	public DiceRoll() {
		this.value1 = randInt(1, 6);
		this.value2 = randInt(1, 6);
	}
	
	
	
	public static int randInt(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}


	/**
	 * @return the value1
	 */
	public int getValue1() {
		return value1;
	}


	/**
	 * @return the value2
	 */
	public int getValue2() {
		return value2;
	}

}
