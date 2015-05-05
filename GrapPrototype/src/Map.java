import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * T�rolja a p�lya k�p�s �s a p�ly�t meghat�roz� maskot.
 * Ut�bbi seg�ts�g�vel �llap�tja meg, hogy az adott poz�ci� a p�lya ter�let�n tal�lhat�-e.
 */
public class Map implements GameObject {
	
	private BufferedImage map=null; //A térképet alkotó maszkon kívüli grafika
	private BufferedImage mask=null; //A térkép pályát reprezentáló koordinátáit tartalmazó maszk
	//private BufferedImage trackLine=null;
	
	public final static String outOfTrackMaskFile = "map/mapMask.png";
	public final static String mapImage = "map/map.png";


	/**
	 * A Map oszt�ly param�ter n�lk�li konstruktora.
	 */
	public Map(){
		try {
		    map = ImageIO.read(new File(mapImage));
		    mask = ImageIO.read(new File(outOfTrackMaskFile));
		} catch (IOException e) {
			System.out.println("Map files not found!");			
		}
		
	}

	/**
	 * A metódus feladata elpusztítani a robotot, ha az elhagyta a pályát
	 * @param robi: a robot, amit vizsgálunk
	 */
	public void CollisionWithRobot(Robot robi){
		boolean onGround = robi.onTheGround();
		boolean out = isOutOfTrack(robi.getPosition());
		if(onGround && out)
		{
			robi.KillHim();
		}
	}
	
	/**
	 * Megállapítja, hogy az adott pont kint van-e a pályáról.
	 * 
	 * @param pos: vizsgálandó pont
	 */
	public boolean isOutOfTrack(Vector2D pos){
		int X=(int)pos.getX();
		int Y=(int)pos.getY();
		
		if(Y < 0 || mask.getHeight() <= Y ||
				X < 0 || mask.getWidth() <= X)
			return true;

		return mask.getRGB(X,Y) == Color.WHITE.getRGB();
	}

	/*public Vector2D[] getTrackLine(){
	
	
	}*/

	/**
	 * Frissíti a térkép állapotát.
	 * 
	 * @param g: az objektumot vezérlő Game osztály.
	 */
	@Override
	public void Update(Game g){
		
	}
	
	/**
	 * Kirajzolja a térképet.
	 * 
	 * @param g: a grafikus környezet, amiben a kirajzolás történik.
	 */
	@Override
	public void Draw(Graphics g) {
		g.drawImage(map, 0, 0, null);
	}
	
	public int getHeight()
	{
		return map.getHeight();
	}
	
	public int getWidth()
	{
		return map.getWidth();
	}
}