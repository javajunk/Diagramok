import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
* A billentyűzet aktuális állapotának lekérdezésére alkalmas osztály
 * 	(Az átadott objektumnak kell focus-ban lennie)
 */
public class KeyboardState implements KeyListener {

	public KeyboardState(){

	}

	/**
	 * Megadja hogy a paraméterül kapott billentyű le van-e nyomva.
	 * @param keyCode Az ellenőrizendő billentyű kódja.
	 */
	public boolean isKeyDown(int keyCode){
		return SkeletonHelper.getKeyState(keyCode);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}