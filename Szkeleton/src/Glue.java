

/**
 * Az oszt�ly feladata a ragacsfoltok k�p�nek, helyzet�nek �s kiterjed�s�nek t�rol�sa, 
 * valamint a ragacsfoltok friss�t�se �s kirajzol�sa is.
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
	 * Be�ll�tja a ragacs �j poz�ci�j�t
	 * @param newPos: �j poz�ci�ja
	 */
	public void setVector2D(Vector2D newPos){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
		position = newPos;
	}

}