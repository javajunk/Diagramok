import javax.swing.JComponent;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Ez az objektum felelős a létrehozási, fő kirajzolási és frissítési metódusok meghívásáért, 
 * vezeti a játék időkezelését és figyeli, hogy életben vannak-e még a játékosok által vezérelt robotok.
 */

public class Game extends JComponent implements Runnable, Dumpable {

	private static final int initialPlacedObstacles = 2;
	private static final Vector2D littleBotsEntryPosition = new Vector2D(600,30);
	private static final int littleBotEntryPeriod = 5;
	private static final PlayerInitParams[] PlayersInitParams = new PlayerInitParams[2];
	private static final int targetFrameTime = 16;
	private static final long serialVersionUID = 7845653460750690226L;
	
	static {
		Hashtable<Control,Integer> p1Control = new Hashtable<Control,Integer>();
		p1Control.put(Control.UP, KeyEvent.VK_W);
		p1Control.put(Control.DOWN,  KeyEvent.VK_S);
		p1Control.put(Control.LEFT,  KeyEvent.VK_A);
		p1Control.put(Control.RIGHT,  KeyEvent.VK_D);
		p1Control.put(Control.GLUE,  KeyEvent.VK_Q);
		p1Control.put(Control.OIL,  KeyEvent.VK_E);
		
		PlayersInitParams[0] = new PlayerInitParams(p1Control,"p1Rob.png",new Vector2D(600,594));
		
		Hashtable<Control,Integer> p2Control = new Hashtable<Control,Integer>();
		p2Control.put(Control.UP, KeyEvent.VK_P);
		p2Control.put(Control.DOWN,  39);
		p2Control.put(Control.LEFT,  KeyEvent.VK_L);
		p2Control.put(Control.RIGHT,  40);
		p2Control.put(Control.GLUE,  26);
		p2Control.put(Control.OIL,  KeyEvent.VK_O);
		
		PlayersInitParams[1] = new PlayerInitParams(p2Control,"p2Rob.png",new Vector2D(600,532));
	}
	
	private int elapsedTime = 0;
	private int gameTime = 0;
	private boolean isRunning = false;

	private Map map;
	private List<LittleBot> littleBots = new ArrayList<LittleBot>();
	private List<Robot> robots = new ArrayList<Robot>();
	private List<Obstacle> obstacles = new ArrayList<Obstacle>();

	private KeyboardState keyboardState = new KeyboardState();
	private List<GameEndedListener> gameEndedListeners = new ArrayList<GameEndedListener>();
	
	private int protoID;
	private static int protoIdNext = 0;
	
	public Game(){
		protoIdNext++;
		protoID = protoIdNext;
	}
	
	/**
	 * Hozzáadja a kapott GameEndedListener-t ami értesítést kap, hogyha
	 * a játék az idő lejárta vagy valamelyik játékos halála miatt véget ért.
	 * @param listener A feliratkoztatott listener.
	 */
	public void addGameEndedListener(GameEndedListener listener){
		gameEndedListeners.add(listener);
	}

	/**
	 * Hozzáad egy akadályt a GameObject-es listához.
	 * @param obs A hozzáadandó akadály.
	 */
	public void addObstacle(Obstacle obs){
		this.obstacles.add(obs);
	}

	/**
	 * Meghívja a játéktér összes elemének a kirajzoló metódusát.
	 * @param g A grafikus környezet amiben a kirajzolás történik.
	 */
	public void Draw(Graphics g){

	}
	
	/**
	 * Visszaad egy KeyboardState osztályt, amivel majd a billentyűzet aktuális állapotát fogjuk tudni lekérni.
	 * @return: a billentyűzet állapotának vizsgálásra alkalmas osztály
	 */
	public KeyboardState getkeyboardState(){
		return keyboardState;
	}
	
	/**
	 * Lekéri a játéktér térképét
	 * @return: térkép
	 */
	public Map getMap(){
		return map;
	}
	
	public List<Obstacle> getObstacles()
	{
		return obstacles;
	}
	
	public List<LittleBot> getLittleBots()
	{
		return littleBots;
	}
	
	public void removeLittleBot(LittleBot ltb)
	{
		littleBots.remove(ltb);
	}
	
	public void removeObstacle(Obstacle obst)
	{
		obstacles.remove(obst);
	}
	
	/**
	 * Egy lista, amiben a robotokat tároljuk.
	 * @return: robotok listája
	 */
	public List<Robot> getRobots(){
		return robots;
	}
	
	/**
	 * Lekéri a játékból hátralévő időt
	 * @return: maradék idő
	 */
	public int getRemainingTime(){
		return gameTime-elapsedTime;
	}
	
	public int getElapsedTime(){
		return this.elapsedTime;
	}
	private Vector2D getRandomOnMapPostition()
	{
		//Vegtelen loop lehet ha szar erteket adnak meg
		boolean isOut = true;
		Vector2D pos;
		do
		{
			pos = new Vector2D(PrototypeHelper.getNextRandomCodrinatePart(),
					PrototypeHelper.getNextRandomCodrinatePart());
			isOut = map.isOutOfTrack(pos);
		} while(isOut);
		return pos;
	}
	
	/**
	 * Inicializál egy új játékot.
	 */
	public void Init() {
		this.elapsedTime = 0;
		this.obstacles.clear();
		this.robots.clear();
		this.littleBots.clear();
		
		this.map = new Map();
		
		for(PlayerInitParams param : PlayersInitParams)
			robots.add(new Robot(param));
		
		for(int i = 0; i < initialPlacedObstacles; i++)
		{
			this.addObstacle(new Glue(getRandomOnMapPostition()));
		}
		
		for(int i = 0; i < initialPlacedObstacles; i++)
		{
			this.addObstacle(new Oil(getRandomOnMapPostition()));
		}
		
		Start();
	}

	/**
	 * Szünetelteti a játék futását.
	 */
	public void Pause(){
		isRunning = false;
	}

	/**
	 * Beállítja a játék maximális hosszát.
	 * @param sec: A játék maximális hossza másodpercben.
	 */
	public void setMaxGameTime(int sec){
		gameTime = sec*1000/targetFrameTime;
	}
	
	/**
	 * Létrehoz egy új szálat a verseny számára és elindítja.
	 */
	public void Start(){
		isRunning = true;
	}

	/**
	 * Meghívja a játéktér összes elemének az Update metódusát, valamint
	 * ellenőrzi, hogy véget ért-e a játék.
	 * Ha a játék véget ért, értesíti a feliratkozókat erről és szünetelteti a játékot.
	 */
	public void Update(){

		if(elapsedTime % littleBotEntryPeriod == 0)
		{
			littleBots.add(new LittleBot(littleBotsEntryPosition));
		}
		
		map.Update(this);
		
		for(int i = 0; i < obstacles.size(); i++)
		{
			obstacles.get(i).Update(this);
		}
		
		for(int i = 0; i < littleBots.size(); i++)
		{
			littleBots.get(i).Update(this);
		}
		
		for(int i = 0; i < robots.size(); i++)
		{
			robots.get(i).Update(this);
		}

		boolean onePlayerAlive = false;
		for(Robot rob : this.getRobots())
		{
			onePlayerAlive = onePlayerAlive || rob.isAlive();
		}
		
		boolean gameTimeExpired = this.getRemainingTime() <= 0;
		
		if(!onePlayerAlive || gameTimeExpired)
		{
			this.Pause();
			for(GameEndedListener gEndLis : gameEndedListeners)
			{
				gEndLis.GameEnded();
			}
		}
		
		elapsedTime++;
	}
	
	/**
	 * Elindítja a játékot.
	 */
	@Override
	public void run() {
		
	}

	@Override
	public int getProtoId() {
		return protoID;
	}

	@Override
	public LinkedHashMap<String, String> dump() {
		LinkedHashMap<String,String> infos = new LinkedHashMap<String,String>();
		
		infos.put("gameTime", String.valueOf(gameTime));
		infos.put("elapsedTime", String.valueOf(elapsedTime));
		infos.put("isRuning", String.valueOf(isRunning));
		
		return infos;
	}
}