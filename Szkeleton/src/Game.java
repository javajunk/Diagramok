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
	
	/**
	 * 
	 * @param listener
	 */
	public void addGameEndedListener(GameEndedListener listener){
		SkeletonHelper.writeOutMethodName();
	}

	/**
	 * 
	 * @param gObj
	 */
	public void addObstacle(GameObject gObj){
		SkeletonHelper.writeOutMethodName();

	}

	/**
	 * 
	 * @param g
	 */
	public void Draw(Graphics g){
		SkeletonHelper.writeOutMethodName();
	}

	public List<GameObject> getGameObjects(){
		SkeletonHelper.writeOutMethodName();
		return null;
	}
	
	public KeyboardState getkeyboardState(){
		SkeletonHelper.writeOutMethodName();
		return keyboardState;
	}

	public Map getMap(){
		SkeletonHelper.writeOutMethodName();
		Pause();
		return m_Map;
	}

	public void getRemainingTime(){
		SkeletonHelper.writeOutMethodName();
	}

	public List<Robot> getRobots(){
		SkeletonHelper.writeOutMethodName();
		return null;
	}

	public void Init(){
		SkeletonHelper.writeOutMethodName();
	}

	public void Pause(){
		SkeletonHelper.writeOutMethodName();
	}

	/**
	 * 
	 * @param sec
	 */
	public void setMaxGameTime(int sec){
		SkeletonHelper.writeOutMethodName();
	}

	public void Start(){
		SkeletonHelper.writeOutMethodName();
		getMap();
	}

	public void Update(){
		SkeletonHelper.writeOutMethodName();
		Start();
	}
}