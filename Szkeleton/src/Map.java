import java.awt.Graphics;

public class Map implements GameObject {

	public Map(){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
	}

	/**
	 * Ha ütközik, akkor kinyírja a robotot. 
	 * 
	 * @param robi
	 */
	public void CollisionWithRobot(Robot robi){
		SkeletonHelper.writeOutMethodName();
		boolean onGround = robi.onTheGround();
		boolean out = isOutOfTrack(new Vector2D());
		if(onGround && out)
		{
			robi.KillHim();
		}
		SkeletonHelper.returnFromMethod();
	}
	
	/**
	 * Megmondja, hogy az adott pont kint van-e a pályából.
	 * 
	 * @param pos
	 */
	public boolean isOutOfTrack(Vector2D pos){
		SkeletonHelper.writeOutMethodName();
		boolean out = SkeletonHelper.getBooleanAnswer("Kint van a pályáról");
		SkeletonHelper.returnFromMethod();
		return out;
	}

	/**
	 * Frissíti a térkép állapotát.
	 * 
	 * @param g: az objektumot vezérlő Game osztály.
	 */
	@Override
	public void Update(Game g){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
	}
	
	/**
	 * Kirajzolja a térképet.
	 * 
	 * @param g: a grafikus környezet, amiben a kirajzolás történik.
	 */
	@Override
	public void Draw(Graphics g) {
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
	}

}