

/**
 * @author Lucy
 * @version 1.0
 * @created 19-márc.-2015 11:08:15
 */
public class Robot implements GameObject {

	private boolean controllable;
	private Vector2D distance;
	private static final int initStoredObstacles;
	private static final Hashtable<Control,int> player1ControlKeys;
	private static final string player1RobotImage = /robot1.png;
	private static final Hashtable<Control,int> player2ControlKeys;
	private static final string player2RobotImage = /robot1.png;
	private Hashtable<Control,int> playerControlKeys;
	private Vector2D position;
	private static final double Radius = /*coming soon*/;
	private Vector2D speed;
	private int storedGlue;
	private int storedOil;
	private Vector2D m_Vector2D;

	public Robot(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * Megnézi, hogy a megvalósító objektum ütközik-e a paraméterként kapott robottal.
	 * Ha ütközik, akkor befolyásolhatja a robot viselkedését. (Pl. ragacs esetén
	 * felezi a sebességet)
	 * 
	 * @param robi
	 */
	public void CollisionWithRobot(Robot robi){

	}

	/**
	 * 
	 * @param g
	 */
	public void Draw(Graphics g){

	}

	public boolean getcontrollable(){
		return controllable;
	}

	public Vector2D getdistance(){
		return distance;
	}

	public int getinitStoredObstacles(){
		return initStoredObstacles;
	}

	public Hashtable<Control,int> getplayer1ControlKeys(){
		return player1ControlKeys;
	}

	public string getplayer1RobotImage(){
		return player1RobotImage;
	}

	public Hashtable<Control,int> getplayer2ControlKeys(){
		return player2ControlKeys;
	}

	public string getplayer2RobotImage(){
		return player2RobotImage;
	}

	public Vector2D getposition(){
		return position;
	}

	public double getRadius(){
		return Radius;
	}

	public Vector2D getspeed(){
		return speed;
	}

	public int getstoredGlue(){
		return storedGlue;
	}

	public int getstoredOil(){
		return storedOil;
	}

	public Vector2D getVector2D(){
		return m_Vector2D;
	}

	public Vector2D getVector2D(){
		return m_Vector2D;
	}

	/**
	 * Élteben van-e a robot.
	 */
	public boolean isAlive(){
		return false;
	}

	/**
	 * Megöli a robotott (felrobantja...)
	 */
	public void KillHim(){

	}

	/**
	 * A robot a földön van-e
	 */
	public boolean onTheGround(){
		return false;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setcontrollable(boolean newVal){
		controllable = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setdistance(Vector2D newVal){
		distance = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setinitStoredObstacles(int newVal){
		initStoredObstacles = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setplayer1ControlKeys(Hashtable<Control,int> newVal){
		player1ControlKeys = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setplayer1RobotImage(string newVal){
		player1RobotImage = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setplayer2ControlKeys(Hashtable<Control,int> newVal){
		player2ControlKeys = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setplayer2RobotImage(string newVal){
		player2RobotImage = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setposition(Vector2D newVal){
		position = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRadius(double newVal){
		Radius = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setspeed(Vector2D newVal){
		speed = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setstoredGlue(int newVal){
		storedGlue = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setstoredOil(int newVal){
		storedOil = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setVector2D(Vector2D newVal){
		m_Vector2D = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setVector2D(Vector2D newVal){
		m_Vector2D = newVal;
	}

	/**
	 * 
	 * @param g
	 */
	public void Update(Game g){

	}

}