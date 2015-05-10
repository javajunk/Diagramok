package Game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Az Obstacle absztrakt osztály tartalmazza az akadályok közös attribútumait és metódusát.
 * Az akadályok (Glue és Oil) őse.
 * Az osztály fő feladata az ütközések detektálása egy robot és egy akadály között.
 */

public abstract class Obstacle implements GameObject {
	public final static double Radius = 42;
	
	protected BufferedImage obstacleImage = null;
	
	private Vector2D position;
	private double life = 100;
	
	protected int protoID;
	protected static int protoIdNext = 0;
	
	public Vector2D getPosition()
	{
		return position;
	}
	
	public Obstacle(Vector2D pos)
	{
		position = pos;
		Obstacle.protoIdNext++;
		this.protoID = Obstacle.protoIdNext;
	}
	
	/**
	 * Megnézi, hogy a megvalósító objektum ütközik-e a paraméterként kapott robottal.
	 * @param robi: a robot, amivel az adott objektum ütközik
	 */
	protected boolean CollisionDetectWithRobot(Robot robi)
	{
		return robi.getPosition().Distance(position) < Radius && robi.onTheGround();
	}
	
	public void DecreaseLife(double d)
	{
		this.life -= d;
	}
	
	public void Update(Game g)
	{
		if(life < 1)
			g.removeObstacle(this);
	}
	
	public void Draw(Graphics g)
	{
		g.drawImage(obstacleImage, (int)(position.getX() - Radius), (int)(position.getY() - Radius), null);
	}
}