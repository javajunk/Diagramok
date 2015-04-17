/**
 * Az Obstacle absztrakt osztály tartalmazza az akadályok közös attribútumait és metódusát.
 * Az akadályok (Glue és Oil) őse.
 * Az osztály fő feladata az ütközések detektálása egy robot és egy akadály között.
 */

public abstract class Obstacle implements GameObject {
	
	public Vector2D position;
	public final static double Radius = 42;
	protected double life = 100;

	/**
	 * Megnézi, hogy a megvalósító objektum ütközik-e a paraméterként kapott robottal.
	 * @param robi: a robot, amivel az adott objektum ütközik
	 */
	protected boolean CollisionDetectWithRobot(Robot robi)
	{
		SkeletonHelper.writeOutMethodName();
		
		boolean collision = robi.onTheGround();
		robi.getPosition();
		collision = collision && SkeletonHelper.getBooleanAnswer("Történt ütközés a robottal?");
		SkeletonHelper.returnFromMethod();
		return collision;
	}
	
	public void DecreaseLife(double d)
	{
		this.life -= d;
	}
}