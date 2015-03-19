
public abstract class SzkeletonHelper {
	static int t = 0;
	
	public static void increaseIndent ()
	{
		t++;
	}
	
	public static void decreaseIndent ()
	{
		t--;
	}
	
	public static boolean getBooleanAnswer (String s)
	{
		return false;
	}
	
	public static int getIntegerAnswer (String s)
	{
		return 0;
	}
	
	public static Vector2D getVectorAnswer (String s)
	{
		return new Vector2D();
	}
}
