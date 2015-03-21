import java.awt.Graphics;



/**
 * @author Lucy
 * @version 1.0
 * @created 19-m�rc.-2015 11:08:12
 */
public class Map implements GameObject {

	private static final String mapImage = "/map/map.png";
	private static final String outOfTrackMaskFile = "/map/mapMask.png";

	public Map(){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
	}

	/*public void finalize() throws Throwable {

	}*/

	/**
	 * Megn�zi, hogy a megval�s�t� objektum �tk�zik-e a param�terk�nt kapott robottal.
	 * Ha �tk�zik, akkor befoly�solhatja a robot viselked�s�t. (Pl. ragacs eset�n
	 * felezi a sebess�get)
	 * 
	 * @param robi
	 */
	public void CollisionWithRobot(Robot robi){
		SkeletonHelper.writeOutMethodName();
		boolean onGround = robi.onTheGround();
		boolean out = isOutOfTrack(new Vector2D());
		if(onGround && out)
		{
			robi.killHim();
		}
		SkeletonHelper.returnFromMethod();
	}

	/**
	 * 
	 * @param g
	 */
	/*public void Draw(Graphics g){

	}

	public String getmapImage(){
		return mapImage;
	}

	public String getoutOfTrackMaskFile(){
		return outOfTrackMaskFile;
	}*/

	/**
	 * Megmondja, hogy az adott pont kint van-e a p�ly�b�l.
	 * 
	 * @param pos
	 */
	public boolean isOutOfTrack(Vector2D pos){
		SkeletonHelper.writeOutMethodName();
		boolean out = SkeletonHelper.getBooleanAnswer("Kint van a p�ly�r�l?");
		SkeletonHelper.returnFromMethod();
		return out;
	}

	/**
	 * 
	 * @param g
	 */
	public void Update(Game g){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
	}

	@Override
	public void Draw(Graphics g) {
		// TODO Auto-generated method stub
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
	}

}