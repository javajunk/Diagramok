import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;


/**
 * Az osztály feladata az olajfoltok képének, helyzetének és kiterjedésének tárolása, 
 * valamint az olajfoltok frissítése és kirajzolása is
 */
public class Oil extends Obstacle {
	public final static double DryingSpeed = 6.66666;//0.01389;
	public final static String oilPic = "oil.png";
	private BufferedImage oilImage = null;

	public Oil(Vector2D pos){
		super(pos);

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
		else
		{
			robi.setControllable(true && robi.getControllable());
		}
	}
	
	
	/**
	 * Kirajzolja az olajfoltot.
	 * 
	 * @param g: a grafikus környezet, amiben a kirajzolás történik.
	 */
	@Override
	public void Draw(Graphics g) 
	{
		
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