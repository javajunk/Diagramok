import java.awt.Graphics;

/**
 * Az osztály feladata a ragacsfoltok képének, helyzetének és kiterjedésének tárolása,
 * valamint a ragacsfoltok frissítése és kirajzolása is.
 */
public class Glue extends Obstacle {

	public Glue(Vector2D pos){
		super(pos);
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