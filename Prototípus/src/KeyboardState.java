import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Hashtable;
import java.util.List;

/**
* A billentyűzet aktuális állapotának lekérdezésére alkalmas osztály
 * 	(Az átadott objektumnak kell focus-ban lennie)
 */
public class KeyboardState implements KeyListener {

	private Hashtable<Integer, Boolean> keyStates = new Hashtable<Integer,Boolean>();
	
	public KeyboardState(){
		
	}

	/**
	 * Megadja, hogy a paraméterül kapott billentyű le van-e nyomva.
	 * @param keyCode: annak a billentyűnek a kódja, ami le van nyomva
	 */
	public boolean isKeyDown(int keyCode){
		if(keyStates.containsKey(keyCode))
		{
			return keyStates.get(keyCode);
		}
		
		return false;
	}

	public void PRORO_setKeysDown(List<Integer> keys)
	{
		keyStates.clear();
		
		for(int k : keys)
		{
			keyStates.put(k, true);
		}
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