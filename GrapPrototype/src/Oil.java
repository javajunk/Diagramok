import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


/**
 * Az osztály feladata az olajfoltok képének, helyzetének és kiterjedésének tárolása, 
 * valamint az olajfoltok frissítése és kirajzolása is
 */
public class Oil extends Obstacle {
	public final static double DryingSpeed = 0.01389;
	public final static String oilPic = "obstacles/oil.png";

	public Oil(Vector2D pos){
		super(pos);
		
		try {
			obstacleImage = ImageIO.read(new File(oilPic));
		} catch (IOException e) {
			System.out.println("Obstacle files not found!");
		}
	}
	
	/**
	 * Akkor hívódik meg, amikor a robot ütközik egy olajfolttal. 
	 * Ilyenkor a robot irányíthatatlanná válik.
	 * 
	 * @param robi: a robot, amivel az olajfolt ütközik
	 */
	public void CollisionWithRobot(Robot robi){
		if(CollisionDetectWithRobot(robi))
		{
			robi.setControllable(false);
		}
	}
	
		
	/**
	 * Frissíti az olajfolt állapotát.
	 * 
	 * @param g: az objektumot vezérlő Game osztály.
	 */
	public void Update(Game g){
		this.DecreaseLife(DryingSpeed);
		super.Update(g);
	}
}