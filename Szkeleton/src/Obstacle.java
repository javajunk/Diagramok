import java.awt.Graphics;



/**
 * @author Lucy
 * @version 1.0
 * @created 19-márc.-2015 11:08:13
 */
public class Obstacle implements GameObject {

	protected Vector2D position;
	protected int radius;

	public Obstacle(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param robi
	 */
	protected boolean CollisionDetectWithRobot(Robot robi){
		return false;
	}

	/**
	 * Megnézi, hogy a megvalósító objektum ütközik-e a paraméterként kapott robottal.
	 * Ha ütközik, akkor befolyásolhatja a robot viselkedését. (Pl. ragacs esetén
	 * felezi a sebességet)
	 * 
	 * @param robi
	 */
	public void CollisionWithRobot(Robot robi){

	}

	/**
	 * 
	 * @param g
	 */
	public void Draw(Graphics g){

	}

	/**
	 * 
	 * @param g
	 */
	public void Update(Game g){

	}

	@Override
	public void Draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}