import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public abstract class SkeletonHelper {
	static int t = 0;
	
	public static void writeOutMethodName ()
	{
		final StackTraceElement[] ste = Thread.currentThread().getStackTrace();

		System.out.println(repeat("\t",t)+"[:"+ste[2].getClassName()+"] "+ste[2].getMethodName());
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
	
	/**
	 * A paraméterben kapott kérdést kíírja stdout-ra és vár egy választ.
	 * Értelmetlen válasz esetén kiszól, majd újra felrakja a kérdést.
	 * @param s - A kérdés
	 * @return	A kérdésre adott választ.
	 */
	public static boolean getBooleanAnswer (String question)
	{
		System.out.print(repeat("/t", t) + question + " (I/N): ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true)
		{
			try {
				String line = br.readLine();
				if (line.equals(""))
				{
					System.out.println(repeat("/t",t) + "Rossz bemenet, próbáld újra!");
					System.out.print(repeat("/t", t) + question + " (I/N): ");
					continue;
				}
			
				if ( ('I' == line.charAt(0)) || ('i' == line.charAt(0)) )
				{	
					return true;
				}
				if ( ('N' == line.charAt(0)) || ('n' == line.charAt(0)) )
				{	
					return false;
				}
				System.out.println(repeat("/t",t) + "Rossz bemenet, próbáld újra!");
				System.out.print(repeat("/t", t) + question + " (I/N): ");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * A paraméterben kapott kérdést kiírja stdout-ra. Válaszként egy számot vár.
	 * Ha nem számot kap hibát jelez és újra felteszi a kérdést.
	 * @param question - A kérdés
	 * @param choices - A lehetséges válaszok, max. 4 db
	 * @return A válasz sorszámát
	 */
	public static int getMultipleChoiceAnswer (String question, String choices[])
	{
		System.out.print(repeat("/t", t) + question + " (");
		for (int i = 0; i < 5 && i < choices.length; i++)
		{
			System.out.print((i+1) + ": " + choices[i] + "   ");
		}
		System.out.print("\b\b\b)\n" + repeat("/t", t));
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		
		while (true)
		{
			try {
				String line = br.readLine();
				int c = Integer.parseInt(line);
				if (c > choices.length)
					c = 0;
				switch (c)
				{
					case 1:
						return 1;
					
					case 2:
						return 2;
					
					case 3:
						return 3;
					
					case 4:
						return 4;
						
					default:
						System.out.println(repeat("/t",t) + "Rossz bemenet, próbáld újra!");
						System.out.print(repeat("/t", t) + question + " (");
						for (int i = 0; i < 5 && i < choices.length; i++)
						{
							System.out.print((i+1) + ": " + choices[i] + "   ");
						}
						System.out.print("\b\b\b)\n" + repeat("/t", t));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
