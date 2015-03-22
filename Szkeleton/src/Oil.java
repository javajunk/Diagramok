import java.awt.Graphics;

/**
 * Az osztály feladata az olajfoltok képének, helyzetének és kiterjedésének tárolása, 
 * valamint az olajfoltok frissítése és kirajzolása is
 */
public class Oil extends Obstacle {

	private static final String oilImage = "/obstacles/oil.png";
	private static final double Radius = 1;
	private Vector2D position;

	public Oil(){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
	}
	
	/**
	 * Akkor hívódik meg, amikor a robot ütközik egy olajfolttal. 
	 * Ilyenkor a robot irányíthatatlanná válik.
	 * 
	 * @param robi: a robot, amivel az olajfolt ütközik
	 */
	public void CollisionWithRobot(Robot robi){
		SkeletonHelper.writeOutMethodName();
		
		if(CollisionDetectWithRobot(robi))
		{
			robi.setControllable(false);
		}
		else
		{
			robi.setControllable(true);
		}
		
		SkeletonHelper.returnFromMethod();
	}
	
	
	/**
	 * Kirajzolja az olajfoltot.
	 * 
	 * @param g: a grafikus környezet, amiben a kirajzolás történik.
	 */
	@Override
	public void Draw(Graphics g) {
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
	}
	
	/**
	 * Frissíti az olajfolt állapotát.
	 * 
	 * @param g: az objektumot vezérlő Game osztály.
	 */
	public void Update(Game g){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
	}
}