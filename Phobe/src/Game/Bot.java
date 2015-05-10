package Game;

/**
 * A játéktéren elhelyezkedő és mozgó Robot és LittleBot őse.
 */
public abstract class Bot implements GameObject{
	
	public Vector2D position;
	public Vector2D speed;
	public final static double speedUnit = 0.5;

}