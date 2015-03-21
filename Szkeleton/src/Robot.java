import java.awt.Graphics;
import java.util.Hashtable;



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
		boolean coll = SkeletonHelper.getIntAnswer("Ütközik a két robot?");
		if(coll)
		{
			robi.KillHim();
			KillHim();
		}
		SkeletonHelper.returnFromMethod();
	}

	public boolean getcontrollable(){
		SkeletonHelper.writeOutMethodName();
		boolean contr = SkeletonHelper.getBooleanAnswer("Irányítható a robot?");
		SkeletonHelper.returnFromMethod();
		return contr;
		//return controllable;
	}

	public Vector2D getdistance(){
		SkeletonHelper.writeOutMethodName();
		Vector2D dist = SkeletonHelper.getVector2DAnswer("Mekkora távolságot tett már meg a robot?");
		SkeletonHelper.returnFromMethod();
		return dist;
		//return distance;
	}

	public int getinitStoredObstacles(){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
		return initStoredObstacles;
	}

	public Hashtable<Control,Integer> getplayer1ControlKeys(){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
		return player1ControlKeys;
	}

	/*public String getplayer1RobotImage(){
		return player1RobotImage;
	}*/

	public Hashtable<Control,Integer> getplayer2ControlKeys(){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
		return player2ControlKeys;
	}

	/*public String getplayer2RobotImage(){
		return player2RobotImage;
	}*/

	public Vector2D getposition(){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
		return position;
	}

	public double getRadius(){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
		return Radius;
	}

	public Vector2D getspeed(){
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
	 * Élteben van-e a robot.
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
		boolean onTheGround = SkeletonHelper.getBooleanAnser("Földön van a robot?");
		SkeletonHelper.returnFromMethod();
		return onTheGround;
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
	public void setdistance(Vector2D newVal){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
		distance = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setinitStoredObstacles(int newVal){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
		initStoredObstacles = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setplayer1ControlKeys(Hashtable<Control,Integer> newVal){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
		player1ControlKeys = newVal;
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
		//System.out.println(SkeletonHelper.repeat("\t",SkeletonHelper.t) + "A robot sebessége megváltozott");
		SkeletonHelper.returnFromMethod();
		speed = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setStoredGlue(int newVal){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
		storedGlue = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setStoredOil(int newVal){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
		storedOil = newVal;
	}

	/**
	 * 
	 * @param g
	 */
	public void Update(Game g){
		SkeletonHelper.writeOutMethodName();
		boolean onTheGround = onTheGround();
		boolean upkey = g.keyboardState.isKeyDown(playerControlKeys[control.up]);
		if(onTheGround && upkey)
		{
			setSpeed(new Vector2D(0,0,0));
		}
		boolean downkey = g.keyboardState.isKeyDown(playerControlKeys[control.down]);
		if(onTheGround && downkey)
		{
			setSpeed(new Vector2D(0,0,0));
		}
		boolean leftkey = g.keyboardState.isKeyDown(playerControlKeys[control.left]);
		if(onTheGround && leftkey)
		{
			setSpeed(new Vector2D(0,0,0));
		}
		boolean rightkey = g.keyboardState.isKeyDown(playerControlKeys[control.right]);
		if(onTheGround && rightkey)
		{
			setSpeed(new Vector2D(0,0,0));
		}
		
		//boolean gluekey = g.keyboardState.isKeyDown(playerControlKeys[control.glue]);
		if(g.keyboardState.isKeyDown(playerControlKeys[control.glue])) // Itt nem vagyok biztos, hogy milyen controlkey-t kell figyelni
		{
			int glue = getStoredGlue();
			if(glue > 0)
			{
				g.addObstacle(new Glue());
				setStoredGlue(glue - 1); // jelenleg lehet fiktív érték is
			}
		}
		
		if(g.keyboardState.isKeyDown(playerControlKeys[control.oil])) // Itt nem vagyok biztos, hogy milyen controlkey-t kell figyelni
		{
			int oil = getStoredOil();
			if(oil > 0)
			{
				g.addObstacle(new Oil());
				setStoredOil(oil - 1); // jelenleg lehet fiktív érték is
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