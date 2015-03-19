import java.awt.Graphics;



/**
 * @author Lucy
 * @version 1.0
 * @created 19-márc.-2015 11:07:46
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