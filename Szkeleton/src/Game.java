import javax.swing.JComponent;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 * Ez az objektum felelős a létrehozási, fő kirajzolási és frissítési metódusok meghívásáért, 
 * vezeti a játék időkezelését és figyeli, hogy életben vannak-e még a játékosok által vezérelt robotok.
 */
public class Game extends JComponent implements Runnable {

	private static final long serialVersionUID = 7845653460750690226L;
	private KeyboardState keyboardState = new KeyboardState();
	private List<GameObject> gameObjects = new ArrayList<GameObject>();
	private Map map;
	private List<Robot> robots = new ArrayList<Robot>();
	private List<GameEndedListener> gameEndedListeners = new ArrayList<GameEndedListener>();
	
	public Game(){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
	}
	
	/**
	 * Hozzáadja a kapott GameEndedListener-t ami értesítést kap, hogyha
	 * a játék az idő lejárta vagy valamelyik játékos halála miatt véget ért.
	 * @param listener A feliratkoztatott listener.
	 */
	public void addGameEndedListener(GameEndedListener listener){
		SkeletonHelper.writeOutMethodName();
		gameEndedListeners.add(listener);
		SkeletonHelper.returnFromMethod();
	}

	/**
	 * Hozzáad egy akadályt a GameObject-es listához.
	 * @param obs A hozzáadandó akadály.
	 */
	public void addObstacle(Obstacle obs){
		SkeletonHelper.writeOutMethodName();
		this.gameObjects.add(obs);
		SkeletonHelper.returnFromMethod();
	}

	/**
	 * Meghívja a játéktér összes elemének a kirajzoló metódusát.
	 * @param g A grafikus környezet amiben a kirajzolás történik.
	 */
	public void Draw(Graphics g){
		SkeletonHelper.writeOutMethodName();
		for(GameObject gObj : gameObjects)
		{
			gObj.Draw(g);
		}
		
		SkeletonHelper.returnFromMethod();
	}

	/**
	 * Visszaadja a játéktér összes objektumát.
	 * @return A játéktér összes objektuma.
	 */
	public List<GameObject> getGameObjects(){
		SkeletonHelper.writeOutMethodName();
		
		SkeletonHelper.returnFromMethod();
		return gameObjects;
	}
	
	/**
	 * Visszaad egy KeyboardState osztályt, amivel majd a billentyűzet aktuális állapotát fogjuk tudni lekérni.
	 * @return: a billentyűzet állapotának vizsgálásra alkalmas osztály
	 */
	public KeyboardState getkeyboardState(){
		SkeletonHelper.writeOutMethodName();
		
		SkeletonHelper.returnFromMethod();
		return keyboardState;
	}
	
	/**
	 * Lekéri a játéktér térképét
	 * @return: térkép
	 */
	public Map getMap(){
		SkeletonHelper.writeOutMethodName();
		
		SkeletonHelper.returnFromMethod();
		return map;
	}
	
	/**
	 * Lekéri a játékból hátralévő időt
	 * @return: maradék idő
	 */
	public int getRemainingTime(){
		SkeletonHelper.writeOutMethodName();
		int i = SkeletonHelper.getIntAnswer("Mennyi idő van hátra a játékból", "másodperc");
		SkeletonHelper.returnFromMethod();
		return i;
	}

	/**
	 * Egy lista, amiben a robotokat tároljuk.
	 * @return: robotok listája
	 */
	public List<Robot> getRobots(){
		SkeletonHelper.writeOutMethodName();

		SkeletonHelper.returnFromMethod();
		return robots;
	}

	/**
	 * Inicializál egy új játékot.
	 */
	public void Init(){
		SkeletonHelper.writeOutMethodName();
		
		this.map = new Map();
		this.gameObjects.add(this.map);
		
		Robot newPlayer = new Robot();
		this.robots.add(newPlayer); 
		this.gameObjects.add(newPlayer);
		
		newPlayer =  new Robot();
		this.robots.add(newPlayer);
		this.gameObjects.add(newPlayer);
		
		int obstacleCnt = SkeletonHelper.getIntAnswer("Mennyi akadály kerül a pályára kezdéskor", "darab");
		for(int i = 0; i < obstacleCnt; i++)
		{
			boolean isOut = true;
			
			do
			{
				Vector2D obsPosition = new Vector2D();
				isOut = map.isOutOfTrack(obsPosition);
			} while(isOut);
			
			this.addObstacle(new Glue());
			
			do
			{
				Vector2D obsPosition = new Vector2D();
				isOut = map.isOutOfTrack(obsPosition);
			} while(isOut);
			
			this.addObstacle(new Oil());
		}
		
		SkeletonHelper.returnFromMethod();
	}

	/**
	 * Szünetelteti a játék futását.
	 */
	public void Pause(){
		SkeletonHelper.writeOutMethodName();
		
		SkeletonHelper.returnFromMethod();
	}

	/**
	 * Beállítja a játék maximális hosszát.
	 * @param sec: A játék maximális hossza másodpercben.
	 */
	public void setMaxGameTime(int sec){
		SkeletonHelper.writeOutMethodName();
		
		SkeletonHelper.returnFromMethod();
	}
	
	/**
	 * Létrehoz egy új szálat a verseny számára és elindítja.
	 */
	public void Start(){
		SkeletonHelper.writeOutMethodName();
		
		if(!SkeletonHelper.getBooleanAnswer("Fut már egy verseny"))
			this.run();
		
		SkeletonHelper.returnFromMethod();
	}

	/**
	 * Meghívja a játéktér összes elemének az Update metódusát, valamint
	 * ellenőrzi, hogy véget ért-e a játék.
	 * Ha a játék véget ért, értesíti a feliratkozókat erről és szünetelteti a játékot.
	 */
	public void Update(){
		SkeletonHelper.writeOutMethodName();
		
		for(GameObject gObj : this.gameObjects)
		{
			gObj.Update(this);
		}
		
		boolean allPlayerAlive = true;
		for(Robot rob : this.getRobots())
		{
			allPlayerAlive = allPlayerAlive && rob.isAlive();
		}
		
		boolean gameTimeExpired = this.getRemainingTime() <= 0;
		
		if(!allPlayerAlive || gameTimeExpired)
		{
			for(GameEndedListener gEndLis : gameEndedListeners)
			{
				gEndLis.GameEnded();
			}
			
			this.Pause();
		}
		
		SkeletonHelper.returnFromMethod();
	}
	
	/**
	 * Elindítja a játékot.
	 */
	@Override
	public void run() {
		SkeletonHelper.writeOutMethodName();
		
		while(!SkeletonHelper.getBooleanAnswer("Véget ért a játék"))
		{
			this.Update();
			this.Draw(this.getGraphics());
		}
				
		SkeletonHelper.returnFromMethod();
	}
}