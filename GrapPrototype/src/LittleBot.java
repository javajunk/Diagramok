import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import javax.imageio.ImageIO;

/**
 * A játéktéren keményen dolgozó kisrobotokat reprezentáló objektum, akik szépen
 * sorban feltakarítják a pályán található foltokat.
 */
public class LittleBot extends Bot implements Dumpable {

	public final static String littleBotPic = "littleBot.png";
	public final static double Radius = 13.0;
	public final static double CleaningSpeed = 0.015;
	private BufferedImage littleBotImage = null;
	private Obstacle targetObstacle;
	private boolean alive = false;
	private int protoID;
	private static int protoIdNext = 0;

	LittleBot(Vector2D initPos) {
		protoIdNext++;
		protoID = protoIdNext;
		this.alive = true;
		this.position = initPos;
		this.speed = new Vector2D(0, 0);
		
		try {
			littleBotImage = ImageIO.read(new File(littleBotPic));
		} catch (IOException e) {
			System.out.println("Robot files not found!");			
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

	/**
	 * Teszteli, hogy a kisrobot ütközik-e a paraméterül kapott kisrobottal. Ha
	 * ütköznek, mindkét kisrobot irányt vált.
	 */
	public void CollisionWithLittleBot(LittleBot lbot) {

		if (this.position.Distance(lbot.position) < 2 * LittleBot.Radius) {
			this.speed.setDegreeAngle(-90.0);
			lbot.speed.setDegreeAngle(-90.0);
		}
	}

	@Override
	public void Draw(Graphics g) {
		// TODO
		Graphics2D grap = (Graphics2D)g;
		
		AffineTransform trans = new AffineTransform();

		trans.translate(position.getX(), position.getY());
		trans.rotate(speed.getAngle());

		trans.translate(-Radius, -Radius);
		
		grap.drawImage(littleBotImage, trans, null);
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
			List<Obstacle> obs = g.getObstacles();
			if(obs.size() > 0)
			{
				targetObstacle = obs.get(0);
			
				for(int i=1; i<obs.size(); i++)
				{
					if(this.position.Distance(obs.get(i).position)<this.position.Distance(targetObstacle.position))
					{
						targetObstacle = obs.get(i);
					}
				}
				
				//A kisrobot mozgatása a kiszemelt folt felé
				Vector2D dir = new Vector2D(targetObstacle.position.getX(),targetObstacle.position.getY());
				dir = dir.Subtract(this.position);
				dir.Normalize();
				this.speed = dir;
			
			this.position = this.position.Add(this.speed);
			
			//Ha kisrobot eléri a kiszemelt foltot, elkezdi takarítani
			if(this.position.Distance(targetObstacle.position)<LittleBot.Radius)
			{
				targetObstacle.DecreaseLife(LittleBot.CleaningSpeed);
			}
			}
		}
		else
		{
				g.addObstacle(new Oil(this.position));
				g.removeLittleBot(this);
		}
		
	}

	@Override
	public int getProtoId() {
		return protoID;
	}

	@Override
	public LinkedHashMap<String, String> dump() {
		LinkedHashMap<String, String> infos = new LinkedHashMap<String, String>();

		infos.put("position", this.position.toString());
		infos.put("speed", this.speed.toString());
		infos.put("targetObstacle (Id)",
				String.valueOf(this.targetObstacle.getProtoId()));

		return infos;
	}

}
