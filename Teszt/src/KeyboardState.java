import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Hashtable;


public class KeyboardState implements KeyListener {

	Hashtable<Integer,Boolean> keyStates = new Hashtable<Integer,Boolean>();
	static final int a = 5;
	public boolean isKeyDown(int keyCode)
	{
		return (keyStates.containsKey(keyCode)) ? keyStates.get(keyCode) : false;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {

		keyStates.put(e.getKeyCode(), true);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keyStates.put(e.getKeyCode(), false);
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}