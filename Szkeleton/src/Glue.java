import java.awt.Graphics;


/**
 * Az osztály feladata a ragacsfoltok képének, helyzetének és kiterjedésének tárolása, valamint a 
 * ragacsfoltok frissítése és kirajzolása is.
 */
public class Glue extends Obstacle {

	private static String glueImage = "/obstacles/glue.png"; //TODO
	private static final double Radius = 1; //TODO
	private Vector2D position;

	public Glue(){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
	}

	/**
	 * Megnézi, hogy a megvalósító objektum ütközik-e a paraméterként kapott robottal.
	 * Ha ütközik, akkor befolyásolhatja a robot viselkedését. (Pl. ragacs esetén
	 * felezi a sebességet)
	 * 
	 * @param robi
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
	 * Kirajzolja az adott objektumot.
	 * 
	 * @param g A grafikus környezet amiben a kirajzolás történik.
	 */
	@Override
	public void Draw(Graphics g) {
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
	}
	
	/**
	 * Frissíti az adott objektumot állapotát.
	 * 
	 * @param g Az objektumot vezérlő Game osztály.
	 */
	@Override
	public void Update(Game g) {
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
	}

}