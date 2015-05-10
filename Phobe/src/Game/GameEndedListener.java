package Game;
/**
 * Egy listener interfész, ami értesít, ha a verseny véget ért.
 */

public interface GameEndedListener {

	public void GameEnded(Robot winnerBot);

}