import java.util.Hashtable;
import java.util.LinkedHashMap;

/**
 * Az Obstacle absztrakt osztály tartalmazza az akadályok közös attribútumait és metódusát.
 * Az akadályok (Glue és Oil) őse.
 * Az osztály fő feladata az ütközések detektálása egy robot és egy akadály között.
 */

public abstract class Obstacle implements GameObject, Dumpable {
	public final static double Radius = 42;
	
	protected Vector2D position;
	protected double life = 100;
	
	protected int protoID;
	protected static int protoIdNext = 0;
	
	public Obstacle(Vector2D pos)
	{
		position = pos;
		Obstacle.protoIdNext++;
		this.protoID = Obstacle.protoIdNext;
	}
	
	/**
	 * Megnézi, hogy a megvalósító objektum ütközik-e a paraméterként kapott robottal.
	 * @param robi: a robot, amivel az adott objektum ütközik
	 */
	protected boolean CollisionDetectWithRobot(Robot robi)
	{
		return robi.getPosition().Distance(position) < Radius && robi.onTheGround();
	}
	
	public void DecreaseLife(double d)
	{
		this.life -= d;
	}
	
	public void Update(Game g)
	{
		if(life < 1)
			g.removeObstacle(this);
	}
	
	@Override
	public int getProtoId() {
		return protoID;
	}

	@Override
	public LinkedHashMap<String, String> dump() {
		LinkedHashMap<String,String> infos = new LinkedHashMap<String,String>();
		infos.put("position", position.toString());
		infos.put("life", String.valueOf(PrototypeHelper.LeaveDotZeroOr3Digit(life)));
		return infos;
	}
}