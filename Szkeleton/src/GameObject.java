import java.awt.Graphics;


/**
 * A GameObject interfész deklarálja a játékobjektumok közös függvényeit,
 * amit majd az implementáló osztályok definiálnak. Lehetővé teszi, hogy 
 * a játékobjektumokat egy közös listában tudjuk tárolni.
 */
public interface GameObject extends Drawable {

	/**
	 * Akkor hívódik meg, amikor a robot ütközik egy objektummal.
	 * Az objektumtól függően más-más történik,
	 * pl. ragacs esetén a robot sebessége megfeleződik.
	 * @param robi: az a robot, amelyiket érinti az ütközés
	 */
	public void CollisionWithRobot(Robot robi);

	/**
	 * Kirajzolja az adott objektumot.
	 * 
	 * @param g: a grafikus környezet, amiben a kirajzolás történik.
	 */
	public void Draw(Graphics g);

	/**
	 * Frissíti az adott objektum állapotát.
	 * 
	 * @param g: az objektumot vezérlő Game osztály
	 */
	public void Update(Game g);

}