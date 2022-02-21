package dicegame;


public class Dicegame {
	// Variables
	private boolean started = false;
	private boolean ended = false;
	private int diced;
	private boolean blocked1 = true;
	private boolean blocked2 = true;
	private int points1 = 0;
	private int points2 = 0;
	private int current1 = 0;
	private int current2 = 0;
	private int rounds = 0;
	private int maxrounds = 5;
	private int maxdices = 5;
		
	// Dice
	public int dice() {
		diced = (int)((Math.random()) * 6 + 1);
		return diced;
	}
	
	// Players & points
	public void addPoints(int player) {
		if(player == 1) {
			points1 = points1+current1;
		}else if(player == 2) {
			points2 = points2+current2;
		}
	}
	
	public void addToCurrent(int player, int p) {
		if(player == 1) {
			current1 = current1+p;
		}else if(player == 2) {
			current2 = current2+p;
		}
	}
	
	public void resetCurrent(int player) {
		if(player == 1) {
			current1 = 0;
		}else if(player == 2) {
			current2 = 0;
		}
	}
	
	public void blockPlayer(int player) {
		if(player == 1) {
			blocked1 = true;
		} else if(player == 2) {
			blocked2 = true;
		}
	}
	
	public void unblockPlayer(int player) {
		if(player == 1) {
			blocked1 = false;
		} else if(player == 2) {
			blocked2 = false;
		}
	}
	
	public boolean checkBlocked(int player) {
		if(player == 1) {
			return blocked1;
		} else {
			return blocked2;
		}
	}
	
	public int getPoints1() {
		return points1;
	}
	public int getPoints2() {
		return points2;
	}
	
	// Round
	public void end() {
		ended = true;
	}
	
	public void start() {
		started = true;
	}
	
	public boolean checkEnd() {
		if(ended == true && blocked1 == true && blocked2 == true) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean checkStart() {
		if(started == true) {
			return true;
		} else {
			return false;
		}
	}
	
	public void addRound() {
		rounds += 1;
	}
	
	public boolean lastRound() {
		if(rounds == maxrounds) {
			return true;
		} else {
			return false;
		}
	}
	
	public int currentRound() {
		return rounds;
	}
	
	public int maxRounds() {
		return maxrounds;
	}
	
	public int getMaxDices() {
		return maxdices;
	}
}
