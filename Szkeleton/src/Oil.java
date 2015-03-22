import java.awt.Graphics;


public class Oil extends Obstacle {

	private static final String oilImage = "/obstacles/oil.png"; //TODO
	private static final double Radius = 1; //TODO
	private Vector2D position;

	public Oil(){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
	}
	
	
	protected boolean CollisionDetectWithRobot(Robot robi){
		SkeletonHelper.writeOutMethodName();
		boolean collision = false;
		if(robi.onTheGround())
		{
			collision = SkeletonHelper.getBooleanAnswer("Ráugrott a robot egy ragacsfoltra?");
		}
		SkeletonHelper.returnFromMethod();
		return collision;
	}
	
	public void CollisionWithRobot(Robot robi){
		SkeletonHelper.writeOutMethodName();
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


	public Vector2D getPosition(){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
		return position;
	}


	/**
	 * 
	 * @param newVal
	 */
	public void setPosition(Vector2D newPos){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
	}



}