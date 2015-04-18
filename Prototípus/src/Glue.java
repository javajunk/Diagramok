import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import javax.imageio.ImageIO;

/**
 * Az osztály feladata a ragacsfoltok képének, helyzetének és kiterjedésének tárolása,
 * valamint a ragacsfoltok frissítése és kirajzolása is.
 */
public class Glue extends Obstacle {
	
	private BufferedImage glueImage = null;
	public static String gluePic = "/obstacles/glue.png";
	public static final double OnStepLifeDecrease = 25;
	
	public Glue(Vector2D pos){
		super(pos);
		try {
			glueImage = ImageIO.read(new File(gluePic));
		}
		catch (IOException e) 
		{
			e.getStackTrace();
			System.err.println(e);
		}
		catch (Exception e)
		{
			e.getStackTrace();
			System.err.println(e);
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

	/**
	 * Kirajzolja a ragacsfoltot.
	 * 
	 * @param g: a grafikus környezet, amiben a kirajzolás történik.
	 */
	@Override
	public void Draw(Graphics g) { //TODO

	}
	
	/**
	 * Frissíti a ragacsfolt állapotát.
	 * 
	 * @param g: az objektumot vezérlő Game osztály.
	 */
	@Override
	public void Update(Game g) {

	}
	
	@Override
	public int getProtoId() {

		return protoID;
	}


	@Override
	public Hashtable<String, String> dump() {
		Hashtable<String,String> infos = new Hashtable<String,String>();
		infos.put("position", position.toString());
		infos.put("life", String.valueOf(life));
		return infos;
	}
}