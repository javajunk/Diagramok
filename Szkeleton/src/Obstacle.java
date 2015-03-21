import java.awt.Graphics;



/**
 * @author Lucy
 * @version 1.0
 * @created 19-márc.-2015 11:08:13
 */
public abstract class Obstacle implements GameObject {

	protected Vector2D position;
	protected int radius;

	/*public Obstacle(){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
	}*/

	/*public void finalize() throws Throwable {

	}*/

	/**
	 * 
	 * @param robi
	 */
	protected abstract boolean CollisionDetectWithRobot(Robot robi);

	/**
	 * Megnézi, hogy a megvalósító objektum ütközik-e a paraméterként kapott robottal.
	 * Ha ütközik, akkor befolyásolhatja a robot viselkedését. (Pl. ragacs esetén
	 * felezi a sebességet)
	 * 
	 * @param robi
	 */
	public abstract void CollisionWithRobot(Robot robi);

	/**
	 * 
	 * @param g
	 */
	/*public void Draw(Graphics g){

	}*/

	/**
	 * 
	 * @param g
	 */
	public abstract void Update(Game g);

	/*@Override
	public void Draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}*/

}