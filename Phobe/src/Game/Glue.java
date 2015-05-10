package Game;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Az osztály feladata a ragacsfoltok képének, helyzetének és kiterjedésének tárolása,
 * valamint a ragacsfoltok frissítése és kirajzolása is.
 */
public class Glue extends Obstacle {
	
	public static String gluePic = "obstacles/glue.png";
	public static final double OnStepLifeDecrease = 25;
	
	public Glue(Vector2D pos){
		super(pos);
		
		try {
			obstacleImage = ImageIO.read(new File(gluePic));
		} catch (IOException e) {
			System.out.println("Obstacle files not found!");
		}
	}

	/**
	 * Akkor hívódik meg, amikor a robot ütközik egy ragacsfolttal. 
	 * Ilyenkor a robot sebessége megfeleződik.
	 * 
	 * @param robi: a robot, amivel a ragacs ütközik
	 */
	@Override
	public void CollisionWithRobot(Robot robi) {
		
		if(CollisionDetectWithRobot(robi))
		{
			Vector2D sp = robi.getSpeed();
			sp.Scale(0.5);
			robi.setSpeed(sp);
			
			DecreaseLife(OnStepLifeDecrease);
		}
	}
}