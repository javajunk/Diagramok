import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;

import javax.imageio.ImageIO;
/**
 * T�rolja a p�lya k�p�s �s a p�ly�t meghat�roz� maskot.
 * Ut�bbi seg�ts�g�vel �llap�tja meg, hogy az adott poz�ci� a p�lya ter�let�n tal�lhat�-e.
 */
public class Map implements GameObject {

	private int protoID;
	private static int protoIDNext=0;
	
	private BufferedImage mapScenery=null; //A térképet alkotó maszkon kívüli grafika
	private BufferedImage mask=null; //A térkép pályát reprezentáló koordinátáit tartalmazó maszk
	private BufferedImage trackLine=null;
	
	public String mapImage=null;
	public String outOfTrackMaskFile=null;

	/**
	 * A Map oszt�ly param�ter n�lk�li konstruktora.
	 * Ez a konstruktor a relat�v "map.png" �s "mask.png" �tvonalakr�l t�lti be a f�jlokat
	 */

	//Kellene bele valami amivel le lehet kerdezni a terkep meretet.
	public Map(){
		this("map.png","mask.png","trackline.png");
	}
	
	/**
	 * Ez a paraméterezett konstruktor segíti betölteni az adott grafikákat a pályához.
	 * Ezzel a módszerrel nem kell minden Draw call-nál újra beolvasni a térképet
	 * @param mappath: a térkép (kiegészítő) grafikáját tartalmazó kép útvonala
	 * @param maskpath: a térkép maszkját tartalmazó kép útvonala
	  * @param tracklinepath: a kisrobotok trackline-jának maszkját tartalmazó kép útvonala
	 */
	public Map(String mappath,String maskpath, String tracklinepath){
		protoIDNext++;
		protoID=protoIDNext;
		try {
		    //mapScenery = ImageIO.read(new File(mappath));
		    mask = ImageIO.read(new File(maskpath));
		    //trackLine=ImageIO.read(new File(tracklinepath));
		    
		    mapImage=mappath;
		    outOfTrackMaskFile=mappath;	    
		  
		} catch (IOException e) {
			System.out.println("Map masknot found!");			
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
		
		if(Y < 0 || mask.getHeight() < Y ||
				X < 0 || mask.getWidth() < X)
			return true;
		
		int i = mask.getRGB(X, Y);
		
		return mask.getRGB(X,Y) == 0xFF;
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
	
	}
}