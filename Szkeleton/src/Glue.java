import java.awt.Graphics;


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


	@Override
	public void Draw(Graphics g) {
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
	}
	
	
	@Override
	public void Update(Game g) {
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
	}

}