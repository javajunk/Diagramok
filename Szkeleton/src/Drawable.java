import java.awt.Graphics;



/**
 * @author Szendi Tam�s
 * @version 1.0
 * @created 19-m�rc.-2015 11:07:46
 */
public interface Drawable {

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