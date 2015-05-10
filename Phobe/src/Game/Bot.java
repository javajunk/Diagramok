package Game;

/**
 * A játéktéren elhelyezkedő és mozgó Robot és LittleBot őse.
 */
public abstract class Bot implements GameObject{
	
	protected Vector2D position;
	protected Vector2D speed;
	public final static double speedUnit = 0.5;

	public  Vector2D getPosition()
	{
		return position;
	}
}