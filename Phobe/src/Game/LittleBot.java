package Game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;


/**
 * A játéktéren keményen dolgozó kisrobotokat reprezentáló objektum, akik szépen
 * sorban feltakarítják a pályán található foltokat.
 */
public class LittleBot extends Bot {

	public final static String littleBotPic = "littleBot.png";
	public final static double Radius = 13.0;
	public final static double CleaningSpeed = 0.333;
	private BufferedImage littleBotImage = null;
	private Obstacle targetObstacle;
	private boolean alive = false;
	private Vector2D atCollisionTarget = null;
	
	LittleBot(Vector2D initPos) {
		this.alive = true;
		this.position = initPos;
		this.speed = new Vector2D(0, 0);

		try {
			littleBotImage = ImageIO.read(new File(littleBotPic));
		} catch (IOException e) {
			System.out.println("LittleBot files not found!");
		}
	}

	@Override
	public void CollisionWithRobot(Robot robi) {
		// TODO
		if ((this.position.Distance(robi.position) < (Robot.Radius + LittleBot.Radius))
				&& robi.onTheGround()) {
			this.alive = false;
		}
	}

	private boolean CollisionDetectWithLittleBot(LittleBot lbot)
	{
		return this.position.Distance(lbot.getPosition()) <= LittleBot.Radius*2;
	}
	
	/**
	 * Teszteli, hogy a kisrobot ütközik-e a paraméterül kapott kisrobottal. Ha
	 * ütköznek, mindkét kisrobot irányt vált.
	 */
	public void CollisionWithLittleBot(LittleBot lbot, Map map) 
	{
		
		if(CollisionDetectWithLittleBot(lbot))
		{
			do
			{
				atCollisionTarget = new Vector2D(Math.random()-0.5,Math.random()-0.5);
				atCollisionTarget.Normalize();
				atCollisionTarget.Scale(LittleBot.Radius*10);
				atCollisionTarget = atCollisionTarget.Add(position);
			}while(map.isOutOfTrack(atCollisionTarget));
		}
	}

	
	ArrayList<Double> angles = new ArrayList<Double>();
	
	@Override
	public void Draw(Graphics g) {
		// TODO
		Graphics2D grap = (Graphics2D)g;
		
		angles.add(speed.getAngle());
		if(angles.size() > 10)
			angles.remove(0);
		double angleAvr = 0;
		for(double angl : angles)
		{
			angleAvr += angl;
		}
		angleAvr /=	angles.size(); 
		
		AffineTransform trans = new AffineTransform();

		trans.translate(position.getX(), position.getY());
		trans.rotate(speed.getAngle());

		trans.translate(-Radius, -Radius);
		
		grap.drawImage(littleBotImage, trans, null);
	}

	
	private void moveToPosition(Vector2D target, Map map)
	{
		// Csak hogy ne lepje at.
		if(target.Distance(this.position) < 1)
		{
			this.position = new Vector2D(target);
			return;
		}
		
		Vector2D dir = target.Subtract(this.position);
		dir.Normalize();
		this.speed = dir;
		
		if(map.isOutOfTrack(this.position.Add(this.speed)))
		{
			if(this.speed.getX()<0 && this.speed.getY()>=0) //-+ speed-koordináták
			{
				if(target.getX()<600) //-- -ba megyünk -+ -on keresztül
				{
					if(this.position.getX()>=600 && this.position.getY()<325) //++
					{
						this.speed.setCoords(-1.0, -1.0);
					}
					else if(this.position.getX()<600 && this.position.getY()<325) //-+
					{
						this.speed.setCoords(-1.0, 0.0);
					}
					else if(this.position.getX()>=600 && this.position.getY()>=325) //+-
					{
						this.speed.setCoords(0.0, 1.0);
					}
				}
				else if(target.getX()>=600 && target.getY()>=325) //+- -ba megyünk
				{
					if(this.position.getX()>=600 && this.position.getY()<325) //++
					{
						this.speed.setCoords(1.0, 0.0);
					}
					else if(this.position.getX()>=600 && this.position.getY()>=325) //+-
					{
						this.speed.setCoords(0.0, 1.0);
					}
				}
			}
			else if(this.speed.getX()>=0 && this.speed.getY()<0) //+- speed-koordináták
			{
				if(target.getX()>=600) //++ -ba megyünk +- -on keresztül
				{
					if(this.position.getX()<600 && this.position.getY()>=325) //--
					{
						this.speed.setCoords(1.0, 1.0);
					}
					else if(this.position.getX()>=600 && this.position.getY()>=325) //+-
					{
						this.speed.setCoords(1.0, 0.0);
					}
					else if(this.position.getX()<600 && this.position.getY()<325) //-+
					{
						this.speed.setCoords(0.0, -1.0);
					}
				}
				else if(target.getX()<600 && target.getY()<325) //-+ -ba megyünk
				{
					if(this.position.getX()<600 && this.position.getY()>=325) //--
					{
						this.speed.setCoords(-1.0, 0.0);
					}
					else if(this.position.getX()<600 && this.position.getY()<325) //-+
					{
						this.speed.setCoords(0.0, -1.0);
					}
				}
			}
			else if(this.speed.getX()>=0 && this.speed.getY()>0) //++ speed-koordináták
			{
				if(target.getX()>=600) //+- -ba megyünk ++ -on keresztül
				{
					if(this.position.getX()<600 && this.position.getY()<325) //-+
					{
						this.speed.setCoords(1.0, -1.0);
					}
					else if(this.position.getX()>=600 && this.position.getY()<325) //++
					{
						this.speed.setCoords(1.0, 0.0);
					}
					else if(this.position.getX()>=600 && this.position.getY()>=325) //+-
					{
						this.speed.setCoords(0.0, 1.0);
					}
					else
					{
						this.speed.setCoords(0.0, 1.0);
					}
				}
				else if(target.getX()<600 && target.getY()>=325) //-- -ba megyünk
				{
					if(this.position.getX()<600 && this.position.getY()<325) //-+
					{
						this.speed.setCoords(-1.0, 0.0);
					}
					else if(this.position.getX()<600 && this.position.getY()>=325) //--
					{
						this.speed.setCoords(0.0, 1.0);
					}
				}
			}
			else if(this.speed.getX()<0 && this.speed.getY()<0) //-- speed-koordináták
			{
				if(target.getX()<600) //-+ -ba megyünk -- -on keresztül
				{
					if(this.position.getX()>=600 && this.position.getY()>=325) //+-
					{
						this.speed.setCoords(-1.0, 1.0);
					}
					else if(this.position.getX()<600 && this.position.getY()>=325) //--
					{
						this.speed.setCoords(-1.0, 0.0);
					}
					else if(this.position.getX()<600 && this.position.getY()<325) //-+
					{
						this.speed.setCoords(0.0, -1.0);
					}
					else
					{
						this.speed.setCoords(0.0, -1.0);
					}
				}
				else if(target.getX()>=600 && target.getY()<325) //++ -ba megyünk
				{
					if(this.position.getX()>=600 && this.position.getY()>=325) //+-
					{
						this.speed.setCoords(1.0, 0.0);
					}
					else if(this.position.getX()>=600 && this.position.getY()<325) //++
					{
						this.speed.setCoords(0.0, -1.0);
					}
				}
			}

			this.position = this.position.Add(this.speed);
		}
		else
		{
			//this.speed.Normalize();
			this.position = this.position.Add(this.speed);
		}
	}
	
	/**
	 * A kisrobot pályára lépése után kiválasztja a hozzá legközelebbi foltot és
	 * elindul felé. Ezután minden Update-ben ellenőrzi, lett-e újabb folt, ami
	 * közelebb van hozzá. Ha nem talált közelebbit, folytatja útját a
	 * kiválasztott folt felé, ha viszont talált, az újabb, közelebbi folt felé
	 * navigálja magát.
	 */
	@Override
	public void Update(Game g) {
		
		if (this.alive)
		{		
			//Folkereses.
			List<Obstacle> obs = g.getObstacles();
			if(obs.size() > 0)
			{
				targetObstacle = obs.get(0);
			
				for(int i=1; i<obs.size(); i++)
				{
					if(this.position.Distance(obs.get(i).getPosition())<this.position.Distance(targetObstacle.getPosition()))
					{
						targetObstacle = obs.get(i);
					}
				}
				
				if(this.position.Distance(targetObstacle.getPosition())<LittleBot.Radius)
				{
					targetObstacle.DecreaseLife(CleaningSpeed);
				}
			}
			else //Ha nincs folt akkor nincs mit takaritani.
			{
				targetObstacle = null; 
			}
			
			if(atCollisionTarget == null)
			{
				for(LittleBot littleBot : g.getLittleBots())
				{
					if(littleBot != this)
					{
						this.CollisionWithLittleBot(littleBot,g.getMap()); 	//Ha utkozik valaszt egy random pontott es oda megy.
																			//Közben nem vizsgal utkozest.
																			//Ha ott megint utkozik akkor ujra keres egy masik pontott.
					}
				}
			}
			else if(this.position.Distance(atCollisionTarget)<LittleBot.Radius)
			{
				atCollisionTarget = null;									
			}

			//Prioritas az utkozes elkerulese, ha nem volt utkozes irany a kiszemelt folt (ha van).
			if(atCollisionTarget != null || targetObstacle != null)
				moveToPosition((atCollisionTarget == null) ? targetObstacle.getPosition() : atCollisionTarget,g.getMap());
		}
		else
		{
			g.addObstacle(new Oil(this.position));
			g.removeLittleBot(this);
		}
	}
}

