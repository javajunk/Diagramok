import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
* A billentyűzet aktuális állapotának lekérdezésére alkalmas osztály
 * 	(Az átadott objektumnak kell focus-ban lennie)
 */
public class KeyboardState implements KeyListener {

	public KeyboardState(){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
	}

	/**
	 * Megadja, hogy a paraméterül kapott billentyű le van-e nyomva.
	 * @param keyCode: annak a billentyűnek a kódja, ami le van nyomva
	 */
	public boolean isKeyDown(int keyCode){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
		return SkeletonHelper.getKeyState(keyCode);
	}

	/**
	 * Egyéb, az interface által előírt, de nem használt metódusok
	 */
	@Override
	public void keyPressed(KeyEvent arg0) {}

	@Override
	public void keyReleased(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent arg0) {}

}