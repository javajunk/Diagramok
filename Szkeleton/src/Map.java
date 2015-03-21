import java.awt.Graphics;



/**
 * @author Lucy
 * @version 1.0
 * @created 19-márc.-2015 11:08:12
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
	 * Megnézi, hogy a megvalósító objektum ütközik-e a paraméterként kapott robottal.
	 * Ha ütközik, akkor befolyásolhatja a robot viselkedését. (Pl. ragacs esetén
	 * felezi a sebességet)
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
	 * Megmondja, hogy az adott pont kint van-e a pályából.
	 * 
	 * @param pos
	 */
	public boolean isOutOfTrack(Vector2D pos){
		SkeletonHelper.writeOutMethodName();
		boolean out = SkeletonHelper.getBooleanAnswer("Kint van a pályáról?");
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