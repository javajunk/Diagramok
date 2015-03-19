

/**
 * @author Lucy
 * @version 1.0
 * @created 19-m�rc.-2015 11:08:12
 */
public class Map implements GameObject {

	private static final string mapImage = /map/map.png;
	private static final string outOfTrackMaskFile = /map/mapMask.png;

	public Map(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * Megn�zi, hogy a megval�s�t� objektum �tk�zik-e a param�terk�nt kapott robottal.
	 * Ha �tk�zik, akkor befoly�solhatja a robot viselked�s�t. (Pl. ragacs eset�n
	 * felezi a sebess�get)
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

	public string getmapImage(){
		return mapImage;
	}

	public string getoutOfTrackMaskFile(){
		return outOfTrackMaskFile;
	}

	/**
	 * Megmondja, hogy az adott pont kint van-e a p�ly�b�l.
	 * 
	 * @param pos
	 */
	public boolean isOutOfTrack(Vector2D pos){
		return false;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setmapImage(string newVal){
		mapImage = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setoutOfTrackMaskFile(string newVal){
		outOfTrackMaskFile = newVal;
	}

	/**
	 * 
	 * @param g
	 */
	public void Update(Game g){

	}

}