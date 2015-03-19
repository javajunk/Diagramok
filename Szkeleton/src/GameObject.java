import java.awt.Graphics;



/**
 * @author Lucy
 * @version 1.0
 * @created 19-márc.-2015 11:07:58
 */
public interface GameObject extends Drawable {

	/**
	 * Megnézi, hogy a megvalósító objektum ütközik-e a paraméterként kapott robottal.
	 * Ha ütközik, akkor befolyásolhatja a robot viselkedését. (Pl. ragacs esetén
	 * felezi a sebességet)
	 * 
	 * @param robi
	 */
	public void CollisionWithRobot(Robot robi);

	/**
	 * 
	 * @param g
	 */
	public void Draw(Graphics g);

	/**
	 * 
	 * @param g
	 */
	public void Update(Game g);

}