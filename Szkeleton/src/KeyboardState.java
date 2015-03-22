import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyboardState implements KeyListener {

	public KeyboardState(){

	}


	/**
	 * 
	 * @param keyCode
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