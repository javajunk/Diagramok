import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public abstract class SkeletonHelper {
	static int t = 0;
	static BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
	
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
	 * A param�terben kapott k�rd�st ki�rja stdout-ra �s v�r egy v�laszt.
	 * �rtelmetlen v�lasz eset�n figyelmeztet, majd �jra felteszi a k�rd�st.
	 * @param s - A k�rd�s
	 * @return	A k�rd�sre adott v�lasz
	 */
	public static boolean getBooleanAnswer (String question)
	{
		System.out.print(repeat("\t", t) + question + " (I/N): ");
		while (true)
		{
			try {
				String line = br.readLine();
				if (!line.equals(""))
				{
					if ( ('I' == line.charAt(0)) || ('i' == line.charAt(0)) )
					{	
						return true;
					}
					if ( ('N' == line.charAt(0)) || ('n' == line.charAt(0)) )
					{	
						return false;
					}
				}
				System.out.println(repeat("\t",t) + "Rossz bemenet, pr�b�ld �jra!");
				System.out.print(repeat("\t", t) + question + " (I/N): ");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * A param�terben kapott k�rd�st ki�rja stdout-ra. V�laszk�nt egy sz�mot v�r.
	 * Ha nem sz�mot kap, hib�t jelez �s �jra felteszi a k�rd�st.
	 * @param question - A k�rd�s
	 * @param choices - A lehets�ges v�laszok, max. 4 db
	 * @return A v�lasz sorsz�ma
	 */
	public static int getMultipleChoiceAnswer (String question, String choices[])
	{
		System.out.print(repeat("\t", t) + question + " (");
		for (int i = 0; i < 5 && i < choices.length; i++)
		{
			System.out.print((i+1) + ": " + choices[i] + "   ");
		}
		System.out.print("\b\b\b)\n" + repeat("\t", t));
		
		while (true)
		{
			try {
				String line = br.readLine();
				int c = Integer.parseInt(line);
				if (c > choices.length || c < 0 || c > 4)
					c = 0;
				if (c == 0)
				{
					System.out.println(repeat("\t",t) + "Rossz bemenet, pr�b�ld �jra!");
					System.out.print(repeat("\t", t) + question + " (");
					for (int i = 0; i < 4 && i < choices.length; i++)
					{
						System.out.print((i+1) + ": " + choices[i] + "   ");
					}
					System.out.print("\b\b\b)\n" + repeat("\t", t));
				}
				return c;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
