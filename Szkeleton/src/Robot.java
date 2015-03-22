import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Robot implements GameObject {


	private double distance;
	private Vector2D position;
	//private static final double Radius = 0/*coming soon*/;
	private Vector2D speed;
	//private int storedGlue;
	//private int storedOil;
	//private Vector2D m_Vector2D;

	public Robot(){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
	}


	/**
	 * Megnézi, hogy ütközik-e egymással a két robot.
	 * 
	 * @param robi: a másik robot
	 */
	public void CollisionWithRobot(Robot robi){
		SkeletonHelper.writeOutMethodName();
		boolean coll = SkeletonHelper.getBooleanAnswer("Ütközik a két robot");
		if(coll)
		{
			robi.KillHim();
			KillHim();
		}
		SkeletonHelper.returnFromMethod();
	}

	/**
	 * Lekérdezi, hogy a verseny kezdetétől számítva mekkora távolságot tett meg az adott robot.
	 */
	public double getDistance(){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
		return distance;
	}

	/**
	 * Lekérdezi az adott robot aktuális állapotát
	 */
	public Vector2D getPosition(){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
		return position;
	}

	/**
	 * Lekérdezi az adott robot aktuális sebességét
	 */
	public Vector2D getSpeed(){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
		return speed;
	}

	/**
	 * Lekérdezi az adott robot aktuális ragacskészletét
	 */
	public int getStoredGlue(){
		SkeletonHelper.writeOutMethodName();
		int glue = SkeletonHelper.getIntAnswer("Mennyi ragacs van még raktáron?", "darab");
		SkeletonHelper.returnFromMethod();
		return glue;
	}
	
	/**
	 * Lekérdezi az adott robot aktuális olajkészletét
	 */
	public int getStoredOil(){
		SkeletonHelper.writeOutMethodName();
		int oil = SkeletonHelper.getIntAnswer("Mennyi olajfolt van még raktáron?", "darab");
		SkeletonHelper.returnFromMethod();
		return oil;
	}
	/**
	 * Megadja, hogy életben van-e a robot.
	 */
	public boolean isAlive(){
		SkeletonHelper.writeOutMethodName();
		boolean alive = SkeletonHelper.getBooleanAnswer("Életben van a robot");
		SkeletonHelper.returnFromMethod();
		return alive;
	}

	/**
	 * Megöli a robotot.
	 */
	public void KillHim(){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
	}

	/**
	 * Megadja, hogy a robot a földön van-e
	 */
	public boolean onTheGround(){
		SkeletonHelper.writeOutMethodName();
		boolean foldon = SkeletonHelper.getBooleanAnswer("Földön van a robot?");
		SkeletonHelper.returnFromMethod();
		return foldon;
	}

	/**
	 * Beállítja a robot állapotát, ami lehet irányítható, vagy irányíthatatlan
	 * 
	 * @param newState: az új állapot (true vagy false)
	 * 
	 * newState = true -> irányítható
	 * newState = false -> irányíthatatlan
	 */
	public void setControllable(boolean newState){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
	}


	/**
	 * Beállítja az adott robot új sebességét
	 * @param newSp: az új sebesség
	 */
	public void setSpeed(Vector2D newSp){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
	}


	/**
	 * Frissíti a robotok állapotát.
	 * 
	 * @param g: az objektumot vezérlő Game osztály.
	 */
	public void Update(Game g){
		SkeletonHelper.writeOutMethodName();
		if(onTheGround())
		{
			if(SkeletonHelper.getKeyState(KeyEvent.VK_UP))
			{
				this.setSpeed(new Vector2D());
			}
			if(SkeletonHelper.getKeyState(KeyEvent.VK_DOWN))
			{
				this.setSpeed(new Vector2D());
			}
			if(SkeletonHelper.getKeyState(KeyEvent.VK_LEFT))
			{
				this.setSpeed(new Vector2D());
			}
			if(SkeletonHelper.getKeyState(KeyEvent.VK_RIGHT))
			{
				this.setSpeed(new Vector2D());
			}
		}
		
		if(SkeletonHelper.getKeyState(KeyEvent.VK_G))
		{
			g.addObstacle(new Glue());
		}
		
		if(SkeletonHelper.getKeyState(KeyEvent.VK_O))
		{
			g.addObstacle(new Oil());
		}
		for(GameObject gObj : g.getGameObjects())
		{
			if(gObj!=this)
			{
				gObj.CollisionWithRobot(this);
			}
		}
		
		SkeletonHelper.returnFromMethod();
	}

	/**
	 * Kirajzolja a robotokat.
	 * 
	 * @param g: a grafikus környezet, amiben a kirajzolás történik.
	 */
	@Override
	public void Draw(Graphics g) {
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
	}

}