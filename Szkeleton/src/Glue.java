

/**
 * Az osztály feladata a ragacsfoltok képének, helyzetének és kiterjedésének tárolása, 
 * valamint a ragacsfoltok frissítése és kirajzolása is.
 */
public class Glue extends Obstacle {

	private static String glueImage = "/obstacles/glue.png"; //TODO
	private static final double Radius = 1; //TODO
	private Vector2D position;

	public Glue(){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
	}


	public Vector2D getVector2D(){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
		return position;
	}

	/**
	 * Beállítja a ragacs új pozícióját
	 * @param newPos: új pozíciója
	 */
	public void setVector2D(Vector2D newPos){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
		position = newPos;
	}

}