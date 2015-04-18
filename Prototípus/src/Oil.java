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
	public final static double DryingSpeed = 0.01389;
	public final static String oilPic = "oil.png";
	private BufferedImage oilImage = null;

	public Oil(Vector2D pos){
		super(pos);
		try 
		{
		    oilImage = ImageIO.read(new File(oilPic));
		    
	        /*ImageIcon icon=new ImageIcon(oilImage);
	        JFrame frame=new JFrame();
	        frame.setLayout(new FlowLayout());
	        frame.setSize(200,300);
	        JLabel lbl=new JLabel();
	        lbl.setIcon(icon);
	        frame.add(lbl);
	        frame.setVisible(true);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
		} 
		catch (IOException e) 
		{
			e.getStackTrace();
			System.out.println(e);
		}
		catch (Exception e)
		{
			e.getStackTrace();
			System.out.println(e);
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
		else
		{
			robi.setControllable(true);
		}
	}
	
	
	/**
	 * Kirajzolja az olajfoltot.
	 * 
	 * @param g: a grafikus környezet, amiben a kirajzolás történik.
	 */
	@Override
	public void Draw(Graphics g) { //TODO
		g.drawImage(oilImage, 0, 0, null);
	}
	
	/**
	 * Frissíti az olajfolt állapotát.
	 * 
	 * @param g: az objektumot vezérlő Game osztály.
	 */
	public void Update(Game g){
		List<Obstacle> obs = new ArrayList<Obstacle>();
		obs = g.getObstacles();
		
		for(int i=0; i<obs.size(); i++)
		{
			if(obs.get(i) instanceof Oil)
			{
				obs.get(i).DecreaseLife(Oil.DryingSpeed);
			}
		}
	}
}