import java.awt.Graphics;


/**
 * A GameObject interfész deklarálja a játékobjektumok közös függvényeit,
 * amit majd az implementáló osztályok definiálnak. Lehetõvé teszi, hogy 
 * a játékobjektumokat egy közös listában tudjuk tárolni.
 */
public interface GameObject extends Drawable {

	/**
	 * Akkor hívódik meg, amikor a robot ütközik egy objektummal.
	 * Az objektumtól függõen más-más történik,
	 * pl. ragacs esetén a robot sebessége megfelezõdik.
	 * @param robi: az a robot, amelyiket érinti az ütközés
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