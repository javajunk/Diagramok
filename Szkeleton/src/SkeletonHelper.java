import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


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
		System.out.print(repeat("/t", t) + s + " (I/N): ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			while (true)
			{
				String line = br.readLine();
				if (line == null)
					continue;
			
				if ( ('I' == line.charAt(0)) || ('i' == line.charAt(0)) )
				{	
					br.close();
					return true;
				}
				if ( ('N' == line.charAt(0)) || ('n' == line.charAt(0)) )
				{	
					br.close();
					return false;
				}
				System.out.println("Rossz bemenet, próbáld újra!");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static int getIntegerAnswer (String s)
	{
		System.out.println(s);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return 0;
	}
	
	public static Vector2D getVectorAnswer (String s)
	{
		return new Vector2D();
	}
}
