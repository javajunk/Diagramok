import java.awt.Graphics;

/**
 * Az osztály feladata a ragacsfoltok képének, helyzetének és kiterjedésének tárolása,
 * valamint a ragacsfoltok frissítése és kirajzolása is.
 */
public class Glue extends Obstacle {

	//private static String glueImage = "/obstacles/glue.png";
	//private static final double Radius = 1;
	//private Vector2D position;

	public Glue(){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
	}

	/**
	 * Akkor hívódik meg, amikor a robot ütközik egy ragacsfolttal. 
	 * Ilyenkor a robot sebessége megfeleződik.
	 * 
	 * @param robi: a robot, amivel a ragacs ütközik
	 */
	@Override
	public void CollisionWithRobot(Robot robi) {
		SkeletonHelper.writeOutMethodName();
		
		if(CollisionDetectWithRobot(robi))
		{
			robi.getSpeed();
			robi.setSpeed(new Vector2D());
		}
		
		SkeletonHelper.returnFromMethod();
	}

	/**
	 * Kirajzolja a ragacsfoltot.
	 * 
	 * @param g: a grafikus környezet, amiben a kirajzolás történik.
	 */
	@Override
	public void Draw(Graphics g) {
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
	}
	
	/**
	 * Frissíti a ragacsfolt állapotát.
	 * 
	 * @param g: az objektumot vezérlő Game osztály.
	 */
	@Override
	public void Update(Game g) {
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
	}

}