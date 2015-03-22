import java.awt.Graphics;



/**
 * @author Lucy
 * @version 1.0
 * @created 19-márc.-2015 11:08:13
 */
public abstract class Obstacle implements GameObject {

	protected Vector2D position;
	protected int radius;

	/**
	 * Megnézi, hogy a megvalósító objektum ütközik-e a paraméterként kapott robottal.
	 * @param robi
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
}