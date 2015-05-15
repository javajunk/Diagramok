package Game;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Hashtable;

/**
* A billentyűzet aktuális állapotának lekérdezésére alkalmas osztály
 * 	(Az átadott objektumnak kell focus-ban lennie)
 */
public class KeyboardState implements KeyListener {

	private Hashtable<Integer, Boolean> keyStates;
	
	public KeyboardState(){
		
	}

	/**
	 * Megadja, hogy a paraméterül kapott billentyű le van-e nyomva.
	 * @param keyCode: annak a billentyűnek a kódja, ami le van nyomva
	 */
	public boolean isKeyDown(int keyCode)
	{
		return (keyStates.containsKey(keyCode)) ? keyStates.get(keyCode) : false;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {

		keyStates.put(e.getKeyCode(), true);
	}
	/***
	 * Alaphejzetbe álitja a billentyűk állapotát.
	 */
	public void Init()
	{
		keyStates = new Hashtable<Integer,Boolean>();
	}
	
	/**
	 * Egyéb, az interface által előírt, de nem használt metódusok
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		keyStates.put(e.getKeyCode(), false);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {}

}