import java.awt.Graphics;
/**
 * Tárolja a pálya képét és a pályát meghatározó maskot. (Szkeletonban nem)
 * Utóbbi segítségével állapítja meg, hogy az adott pozíció a pálya területén található-e.
 */
public class Map implements GameObject {

	//Kellene bele valami amivel le lehet kerdezni a terkep meretet.
	public Map(){
		SkeletonHelper.writeOutMethodName();
		SkeletonHelper.returnFromMethod();
	}

	/**
	 * A metódus feladata elpusztítani a robotot, ha az elhagyta a pályát
	 * @param robi: a robot, amit vizsgálunk
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
	 * Megállapítja, hogy az adott pont kint van-e a pályáról.
	 * 
	 * @param pos: vizsgálandó pont
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