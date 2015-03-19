

/**
 * @author Lucy
 * @version 1.0
 * @created 19-márc.-2015 11:08:12
 */
public class Map implements GameObject {

	private static final String mapImage = /map/map.png;
	private static final String outOfTrackMaskFile = /map/mapMask.png;

	public Map(){

	}

	public void finalize() throws Throwable {

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

	public String getmapImage(){
		return mapImage;
	}

	public String getoutOfTrackMaskFile(){
		return outOfTrackMaskFile;
	}

	/**
	 * Megmondja, hogy az adott pont kint van-e a pályából.
	 * 
	 * @param pos
	 */
	public boolean isOutOfTrack(Vector2D pos){
		return false;
	}

	/**
	 * 
	 * @param g
	 */
	public void Update(Game g){

	}

}