import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;

import javax.imageio.ImageIO;


/**
 * A játéktéren keményen dolgozó kisrobotokat reprezentáló objektum, 
 * akik szépen sorban feltakarítják a pályán található foltokat.
 */
public class LittleBot extends Bot implements Dumpable {
	
	public final static String littleBotPic = "littleBot.png";
	public final static double Radius = 13;
	private BufferedImage littleBotImage = null;
	private Obstacle targetObstacle;
	private int protoID;
	private static int protoIdNext = 0;

	LittleBot(Vector2D initPos)
	{
		protoIdNext++;
		protoID=protoIdNext;
		this.position = initPos;
		this.speed = new Vector2D();
		try 
		{
			littleBotImage = ImageIO.read(new File(littleBotPic));
		    
	        /*ImageIcon icon=new ImageIcon(littleBotPic);
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
	

	@Override
	public void CollisionWithRobot(Robot robi) {
		// TODO 
		
	}
	
	/**
	 * Teszteli, hogy a kisrobot ütközik-e a paraméterül kapott kisrobottal. 
	 * Ha ütköznek, mindkét kisrobot irányt vált.
	 */
	public void CollisionWithLittleBot(LittleBot lbot)
	{
		if(this.position.Distance(lbot.position)<2*LittleBot.Radius)
		{
			this.speed.Rotate270();
			lbot.speed.Rotate270();
		}
	}

	@Override
	public void Draw(Graphics g) {
		// TODO 
		
	}

	/**
	 * A kisrobot pályára lépése után kiválasztja a hozzá legközelebbi foltot 
	 * és elindul felé. Ezután minden Update-ben ellenőrzi, lett-e újabb folt, 
	 * ami közelebb van hozzá. Ha nem talált közelebbit, 
	 * folytatja útját a kiválasztott folt felé, ha viszont talált, 
	 * az újabb, közelebbi folt felé navigálja magát.
	 */
	@Override
	public void Update(Game g) {
		List<Obstacle> obs = g.getObstacles();
		
		targetObstacle = obs.get(0);
		
		for(int i=1; i<obs.size(); i++)
		{
			if(this.position.Distance(obs.get(i).position)<this.position.Distance(targetObstacle.position))
			{
				targetObstacle = obs.get(i);
			}
		}
		
	}


	@Override
	public int getProtoId() {
		return protoID;
	}


	@Override
	public LinkedHashMap<String, String> dump() {
		LinkedHashMap<String,String> infos = new LinkedHashMap<String,String>();
		
		infos.put("position", this.position.toString());
		infos.put("speed", this.speed.toString());
		infos.put("targetObstacle (Id)", String.valueOf(this.targetObstacle.getProtoId()));
		
		return infos;
	}

}
