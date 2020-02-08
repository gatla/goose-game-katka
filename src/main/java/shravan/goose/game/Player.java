package shravan.goose.game;

public class Player {

    private final String name;
    
    private int currentPostion = 0; 

	public Player(String name) {
        this.name = name;
        this.currentPostion = 0;
    }

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the currentPostion
	 */
	public int getCurrentPostion() {
		return currentPostion;
	}

	/**
	 * @param currentPostion the currentPostion to set
	 */
	public void setCurrentPostion(int currentPostion) {
		this.currentPostion = currentPostion;
	}

    
}
