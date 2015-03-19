import java.awt.Graphics;
import java.util.List;

import javax.swing.JComponent;



/**
 * @author Lucy
 * @version 1.0
 * @created 19-márc.-2015 11:07:53
 */
public class Game extends JComponent implements Runnable {

	private int gameStarted;
	private int gameTime;
	private boolean isRunning;
	private KeyboardState keyboardState;
	private static final int targetFrameTime = 16;
	private Drawable m_Drawable;
	private GameObject m_GameObject;
	private KeyboardState m_KeyboardState;
	private HUD m_HUD;
	private Map m_Map;
	private Robot m_Robot;

	public Game(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * 
	 * @param listener
	 */
	public void addGameEndedListener(GameEndedListener listener){

	}

	/**
	 * 
	 * @param gObj
	 */
	public void addObstacle(GameObject gObj){

	}

	/**
	 * 
	 * @param g
	 */
	public void Draw(Graphics g){

	}

	public Drawable getDrawable(){
		return m_Drawable;
	}

	public GameObject getGameObject(){
		return m_GameObject;
	}

	public List<GameObject> getGameObjects(){
		return null;
	}

	public HUD getHUD(){
		return m_HUD;
	}

	public KeyboardState getkeyboardState(){
		return keyboardState;
	}

	public KeyboardState getKeyboardState(){
		return m_KeyboardState;
	}

	public Map getMap(){
		return m_Map;
	}

	public void getRemainingTime(){

	}

	public List<Robot> getRobots(){
		return null;
	}

	public void Init(){

	}

	public void Pause(){

	}

	/**
	 * 
	 * @param sec
	 */
	public void setMaxGameTime(int sec){

	}

	public void Start(){

	}

	public void Update(){

	}

}