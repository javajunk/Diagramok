
public abstract class SkeletonHelper {
	static int t = 0;
	
	public static void writeOutMethodName (String name)
	{
		
		System.out.println(repeat("/t",t)+name);
		t++;
	}
	
	private static String repeat(String str,int n)
	{
		String re = "";
		for(int i = 0; i < n; i++)
		{
			re += str;
		}
		return re;
		
	}
	
	public static void returnFromMethod ()
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
