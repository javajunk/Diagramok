import java.awt.Graphics;


public class Oil extends Obstacle {

	private static final String oilImage = "/obstacles/oil.png"; //TODO
	private static final double Radius = 1; //TODO
	private Vector2D position;

	public Oil(){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
	}
	
	
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

	@Override
	public void Draw(Graphics g) {
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
		
	}
	
	public void Update(Game g){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
	}
}