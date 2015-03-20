import java.awt.Graphics;


/**
 * A GameObject interf�sz deklar�lja a j�t�kobjektumok k�z�s f�ggv�nyeit,
 * amit majd az implement�l� oszt�lyok defini�lnak. Lehet�v� teszi, hogy 
 * a j�t�kobjektumokat egy k�z�s list�ban tudjuk t�rolni.
 */
public interface GameObject extends Drawable {

	/**
	 * Akkor h�v�dik meg, amikor a robot �tk�zik egy objektummal.
	 * Az objektumt�l f�gg�en m�s-m�s t�rt�nik,
	 * pl. ragacs eset�n a robot sebess�ge megfelez�dik.
	 * @param robi: az a robot, amelyiket �rinti az �tk�z�s
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