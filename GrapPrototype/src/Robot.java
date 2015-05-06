import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.LinkedHashMap;

import javax.imageio.ImageIO;

/**
 * Az osztály feladata a játékos által irányított robot legfontosabb paramétereinek a tárolása. 
 * Ilyen például a robot pozíciója, sebessége, vagy a megtett távolság. 
 * Ezen kívül az is a feladata, hogy frissítse és kirajzolja a robotot.
 */
public class Robot extends Bot implements GameObject, Dumpable {

	/*private Vector2D position;
	private Vector2D speed;*/
	public boolean controllable;
	private double distance;
	private static final int inAirTime = 60;
	public static final int initStoredObstacles = 8;
	private Hashtable<Control, Integer> playerControlKeys = new Hashtable<Control, Integer>();
	public static final double Radius = 21;
	private BufferedImage robotImage;
	public int storedGlue;
	public int storedOil;
	private boolean alive;
	private boolean ontheGround = true;
	
	private int botHeight = 0;

	private boolean glueBtnLastState = false; 	//A cuccok lerakasa false -> true atmenetre
	private boolean oilBtnLastState = false;	//
	
	private int protoID;
	private static int protoIdNext = 0;
	
	public Robot(PlayerInitParams params) {
		
		protoIdNext++;
		protoID=protoIdNext;
		controllable = true;
		distance = 0;
		storedGlue = initStoredObstacles;
		storedOil = initStoredObstacles;
		alive = true;
		speed = new Vector2D(0,0);
		playerControlKeys = params.getControlKeys();
		position = params.getInitPosition();
		
		try {
			robotImage = ImageIO.read(new File(params.getImageSrc()));
		} catch (IOException e) {
			System.out.println("Robot files not found!");			
		}
		
		
	}


	/**
	 * Megnézi, hogy ütközik-e egymással a két robot.
	 * 
	 * @param robi: a másik robot
	 */
	public void CollisionWithRobot(Robot robi){
		/*Vector2D dist = this.getPosition();
		dist.Subtract(robi.getPosition());*/
		//Vector2D dist = new Vector2D(position.getX(), position.getY());
		//dist.Subtract(robi.getPosition());
		
		//if(dist.Length() < 2 * Radius && robi.isAlive() && alive)
		if(position.Distance(robi.getPosition()) < 2 * Radius && robi.isAlive() && alive)
		{
			double r1Speed = this.getSpeed().Length();
			double r2Speed = robi.getSpeed().Length();
			Vector2D newSp = new Vector2D((speed.getX() + robi.getSpeed().getX()) / 2, (speed.getY() + robi.getSpeed().getY()) / 2);
			if(r1Speed < r2Speed)
			{
				/*Vector2D newSpeed = this.getSpeed();
				newSpeed.Add(robi.getSpeed());
				newSpeed.Scale(0.5);
				robi.setSpeed(newSpeed);
				this.KillHim();*/
				robi.setSpeed(newSp);
				this.KillHim();
			}
			else if(r1Speed > r2Speed)
			{
				/*Vector2D newSpeed = this.getSpeed();
				newSpeed.Add(robi.getSpeed());
				newSpeed.Scale(0.5);
				robi.KillHim();
				this.setSpeed(newSpeed);*/
				this.setSpeed(newSp);
				robi.KillHim();
			}
			else
			{
				robi.KillHim();
				this.KillHim();
			}
		}
	}

	/**
	 * Lekérdezi, hogy a verseny kezdetétől számítva mekkora távolságot tett meg az adott robot.
	 * @return: megtett távolság
	 */
	public double getDistance(){

		return distance;
	}

	/**
	 * Lekérdezi az adott robot aktuális helyzetét
	 * @return: a robot helyzete
	 */
	public Vector2D getPosition(){

		return position;
	}

	/**
	 * Lekérdezi az adott robot aktuális sebességét
	 * @return: a robot sebessége
	 */
	public Vector2D getSpeed(){

		return speed;
	}

	/**
	 * Lekérdezi az adott robot aktuális ragacskészletét
	 * @return: ragacskészlet mérete
	 */
	public int getStoredGlue(){
		
		return storedGlue;
	}
	
	/**
	 * Lekérdezi az adott robot aktuális olajkészletét
	 * @return: olajkészlet mérete
	 */
	public int getStoredOil(){

		return storedOil;
	}
	/**
	 * Megadja, hogy életben van-e a robot.
	 * @return: true -> életben van
	 * @return: false -> nincs már életben
	 */
	public boolean isAlive(){

		return alive;
	}

	/**
	 * Megöli a robotot.
	 */
	public void KillHim(){

		alive = false;
	}

	/**
	 * Megadja, hogy a robot a földön van-e
	 * @return: true -> földön van
	 * @return: false -> levegőben van
	 */
	public boolean onTheGround(){

		return this.ontheGround;
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

		controllable = newState;
	}

	public boolean getControllable()
	{
		return controllable;
	}
	

	/**
	 * Beállítja az adott robot új sebességét
	 * @param newSp: az új sebesség
	 */
	public void setSpeed(Vector2D newSp){
		
		speed = newSp;
	}

	Vector2D addSpeed;
	/**
	 * Frissíti a robotok állapotát.
	 * 
	 * @param g: az objektumot vezérlő Game osztály.
	 */
	public void Update(Game g)
	{
		
		if(alive)
		{
			ontheGround = g.getElapsedTime() % inAirTime == 0;
			KeyboardState kb = g.getKeyboardState();
			
			botHeight = g.getElapsedTime() % (inAirTime);
			

				addSpeed = new Vector2D(0,0);
				if(kb.isKeyDown(playerControlKeys.get(Control.UP)) && controllable)
				{
					addSpeed = addSpeed.Add(new Vector2D(0, -1));
				}
				if(kb.isKeyDown(playerControlKeys.get(Control.DOWN)) && controllable)
				{
					addSpeed = addSpeed.Add(new Vector2D(0, 1));
				}
				if(kb.isKeyDown(playerControlKeys.get(Control.LEFT)) && controllable)
				{
					addSpeed = addSpeed.Add(new Vector2D(-1, 0));
				}
				if(kb.isKeyDown(playerControlKeys.get(Control.RIGHT)) && controllable)
				{
					addSpeed = addSpeed.Add(new Vector2D(1, 0));
				}
				addSpeed.Normalize();
				addSpeed.Scale(speedUnit);
							
			//Majdnem joo volt csak 2 sorral lejebb kellet volna ---- Tamas
			position = position.Add(speed);
			distance += speed.Length(); // Ez így jó? 

			
			
			boolean glueBtnState = kb.isKeyDown(playerControlKeys.get(Control.GLUE));
			if(!glueBtnLastState && glueBtnState && storedGlue > 0)
			{
				g.addObstacle(new Glue(position));
				storedGlue--;
			}
			glueBtnLastState = glueBtnState;
			
			boolean oilBtnState = kb.isKeyDown(playerControlKeys.get(Control.OIL));
			if(!oilBtnLastState && oilBtnState && storedOil > 0)
			{
				g.addObstacle(new Oil(position));
				storedOil--;
			}
			oilBtnLastState = oilBtnState;
			
			g.getMap().CollisionWithRobot(this);
			
			for(GameObject gObj : g.getRobots())
			{
				if(gObj!=this)
				{
					gObj.CollisionWithRobot(this);
				}
			}
			
			this.controllable = true;
			for(GameObject gObj : g.getObstacles())
			{
				gObj.CollisionWithRobot(this);
			}
			
			for(GameObject gObj : g.getLittleBots())
			{
				gObj.CollisionWithRobot(this);
			}
			
			if(onTheGround() && controllable)
			{
				speed = speed.Add(addSpeed);
			}
		}		
	}

	/**
	 * Kirajzolja a robotokat.
	 * 
	 * @param g: a grafikus környezet, amiben a kirajzolás történik.
	 */
	@Override
	public void Draw(Graphics g) {
		Graphics2D grap = (Graphics2D)g;
		
		AffineTransform trans = new AffineTransform();
		Vector2D spd = new Vector2D(speed.getX(),speed.getY());
		spd = spd.Add(addSpeed);
		
		double scale = Math.abs(Math.sin(
				((double)botHeight/inAirTime)*Math.PI
				))*0.3+1;
	
		trans.translate(position.getX(), position.getY());
		trans.rotate(spd.getAngle());
		trans.scale(scale,scale);

		trans.translate(-Radius, -Radius);
		
		grap.drawImage(robotImage, trans, null);
	}

int i = 0;
	@Override
	public int getProtoId() {
		return protoID;
	}


	@Override
	public LinkedHashMap<String, String> dump() {
		LinkedHashMap<String,String> infos = new LinkedHashMap<String,String>();
		infos.put("speed", speed.toString());
		infos.put("position", position.toString());
		infos.put("alive", String.valueOf(alive));
		infos.put("controllable", String.valueOf(controllable));
		
		infos.put("storedGlue", String.valueOf(storedGlue));
		infos.put("storedOil", String.valueOf(storedOil));
		if(playerControlKeys.get(Control.UP) == KeyEvent.VK_W) // Nem a legelegánsabb, de rövid és egyszerű
		{
			infos.put("playerControlKeys", "(Up:W,Down:S,Left:A,Right:D,Glue:Q,Oil:E)");
		}
		else
		{
			infos.put("playerControlKeys", "(Up:P,Down:É,Left:L,Right:Á,Glue:Ő,Oil:O)");
		}
		return infos;
	}

}
