import java.awt.Graphics;
import java.util.Hashtable;

import javafx.scene.control.Control;


/**************************************************************************************************************************** - Tamás
 * Hibák:
 * 		A láthatóságokra figyelj oda egyik adattag sem public csak setter getter metódusokon keresztül elérhetőek
 * 		A static final adattagokhoz nem kell sem setter sem getter
 * 		Javaban csak tömbökre müködik a [] 
 * 		A setStoredOil(oil - 1) és az ehez hasonlo metodusok nem kellenek a szkeletonba, 
 * 			az objektumok belső állapotát nem szabad tárolnunk (vagy valami ilyesmi).
 * 
 * Álj át UTF-8-as kodolasra Edit->SetEncoding
 * 
 * 
 * Üdv.: Tamás
 **************************************************************************************************************************** - Tamás/
/**
 * @author Lucy
 * @version 1.0
 * @created 19-márc.-2015 11:08:15
 */
public class Robot implements GameObject {

	private boolean controllable;
	private Vector2D distance;
	//private static final int initStoredObstacles;
	//private static final Hashtable<Control,Integer> player1ControlKeys;
	private static final String player1RobotImage = "/robot1.png";
	//private static final Hashtable<Control,Integer> player2ControlKeys;
	private static final String player2RobotImage = "/robot1.png";
	private Hashtable<Control,Integer> playerControlKeys;
	private Vector2D position;
	private static final double Radius = 0/*coming soon*/;
	private Vector2D speed;
	private int storedGlue;
	private int storedOil;
	private Vector2D m_Vector2D;

	public Robot(){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
	}

	/*public void finalize() throws Throwable {

	}*/

	/**
	 * Megnézi, hogy a megvalósító objektum ütközik-e a paraméterként kapott robottal.
	 * Ha ütközik, akkor befolyásolhatja a robot viselkedését. (Pl. ragacs esetén
	 * felezi a sebességet)
	 * 
	 * @param robi
	 */
	public void CollisionWithRobot(Robot robi){
		SkeletonHelper.writeOutMethodName();
		boolean coll = SkeletonHelper.getBooleanAnswer("Ütközik a két robot?");
		if(coll)
		{
			robi.KillHim();
			KillHim();
		}
		SkeletonHelper.returnFromMethod();
	}

	public boolean getControllable(){
		SkeletonHelper.writeOutMethodName();
		boolean contr = SkeletonHelper.getBooleanAnswer("Irányítható a robot?");
		SkeletonHelper.returnFromMethod();
		return contr;
		//return controllable;
	}

	public Vector2D getDistance(){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
		return distance;
		//return distance;
	}

	public Vector2D getPosition(){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
		return position;
	}

	public Vector2D getSpeed(){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
		return speed;
	}

	public int getStoredGlue(){
		SkeletonHelper.writeOutMethodName();
		int glue = SkeletonHelper.getIntAnswer("Mennyi ragacs van még raktáron?", "darab");
		SkeletonHelper.returnFromMethod();
		return glue;
		//return storedGlue;
	}

	public int getStoredOil(){
		SkeletonHelper.writeOutMethodName();
		int oil = SkeletonHelper.getIntAnswer("Mennyi olajfolt van még raktáron?", "darab");
		SkeletonHelper.returnFromMethod();
		return oil;
		//return storedOil;
	}

	/*public Vector2D getVector2D(){
		return m_Vector2D;
	}*/

	/**
	 * Életben van-e a robot.
	 */
	public boolean isAlive(){
		SkeletonHelper.writeOutMethodName();
		boolean alive = SkeletonHelper.getBooleanAnswer("Életben van a robot?");
		SkeletonHelper.returnFromMethod();
		return alive;
	}

	/**
	 * Megöli a robotott (felrobantja...)
	 */
	public void KillHim(){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
	}

	/**
	 * A robot a földön van-e
	 */
	public boolean onTheGround(){
		SkeletonHelper.writeOutMethodName();
		boolean foldon = SkeletonHelper.getBooleanAnswer("Földön van a robot?");
		SkeletonHelper.returnFromMethod();
		return foldon;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setControllable(boolean newVal){
		SkeletonHelper.writeOutMethodName();
		if(newVal)
		{
			System.out.println(SkeletonHelper.repeat("\t",SkeletonHelper.t) + "A robot irányítható");
		}
		else
		{
			System.out.println(SkeletonHelper.repeat("\t",SkeletonHelper.t) + "A robot nem irányítható");
		}
		SkeletonHelper.returnFromMethod();
		//controllable = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDistance(Vector2D newVal){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
		//distance = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPosition(Vector2D newVal){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
		//position = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSpeed(Vector2D newVal){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
		//speed = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setStoredGlue(int newVal){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
		//storedGlue = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setStoredOil(int newVal){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
		//storedOil = newVal;
	}

	/**
	 * 
	 * @param g
	 */
	public void Update(Game g){
		SkeletonHelper.writeOutMethodName();
		if(onTheGround())
		{
			if(SkeletonHelper.getBooleanAnswer("Lerakjon a robot ragacsot?"))
			{
				g.addObstacle(new Glue());
			}
			if(SkeletonHelper.getBooleanAnswer("Lerakjon a robot olajfoltot?"))
			{
				g.addObstacle(new Oil());
			}
		}
		
		List<GameObject> gameobjects = g.getGameObjects();
		for(int i = 0; i < gameobjects.size(); i++)
		{
			gameobjects.get(i).CollisionWithRobot(this);
		}
		
		SkeletonHelper.returnFromMethod();
	}

	@Override
	public void Draw(Graphics g) {
		// TODO Auto-generated method stub
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
		
	}

}