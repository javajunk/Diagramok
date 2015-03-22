import java.awt.Graphics;



/**
 * @author Lucy
 * @version 1.0
 * @created 19-márc.-2015 11:08:14
 */
public class Oil extends Obstacle {

	private static final String oilImage = "/obstacles/oil.png"; //TODO
	private static final double Radius = 1; //TODO
	private Vector2D m_Vector2D;

	public Oil(){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
	}
	
	
	protected boolean CollisionDetectWithRobot(Robot robi){
		SkeletonHelper.writeOutMethodName();
		boolean coll = robi.onTheGround();
		if(coll)
		{
			coll = SkeletonHelper.getBooleanAnswer("Olajfolton van a robot?");
		}
		SkeletonHelper.returnFromMethod();
		return coll;
	}
	
	public void CollisionWithRobot(Robot robi){
		SkeletonHelper.writeOutMethodName();
		boolean coll = CollisionDetectWithRobot(robi);
		robi.setControllable(!coll);
		SkeletonHelper.returnFromMethod();
	}

	@Override
	public void Draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
	public void Update(Game g){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
	}


	public Vector2D getVector2D(){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
		return m_Vector2D;
	}


	/**
	 * 
	 * @param newVal
	 */
	public void setVector2D(Vector2D newVal){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
		//m_Vector2D = newVal;
	}



}