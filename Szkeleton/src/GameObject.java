import java.awt.Graphics;



/**
 * @author Lucy
 * @version 1.0
 * @created 19-m�rc.-2015 11:07:58
 */
public interface GameObject extends Drawable {

	/**
	 * Megn�zi, hogy a megval�s�t� objektum �tk�zik-e a param�terk�nt kapott robottal.
	 * Ha �tk�zik, akkor befoly�solhatja a robot viselked�s�t. (Pl. ragacs eset�n
	 * felezi a sebess�get)
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