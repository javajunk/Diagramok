import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;

/**
 * A szkeletonhoz használt segédosztály és segédmetódusai
 */
public abstract class SkeletonHelper {
	static int t = 0;
	static BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
	static Hashtable<Integer, String> controlKeyNames = new Hashtable<Integer, String>();
	
	/**
	 * Összerendeli a verseny során használatos billentyűparancsokat a hozzájuk tartozó kóddal
	 */
	public static void Init()
	{
		//UP,DOWN,LEFT,RIGHT,OIL,GLUE
		controlKeyNames.put(KeyEvent.VK_UP,"Fel");
		controlKeyNames.put(KeyEvent.VK_DOWN,"Le");
		controlKeyNames.put(KeyEvent.VK_LEFT,"Balra");
		controlKeyNames.put(KeyEvent.VK_RIGHT,"Jobbra");
		controlKeyNames.put(KeyEvent.VK_O,"Olaj");
		controlKeyNames.put(KeyEvent.VK_G,"Ragacs");
	}
	
	/**
	 * Egy metódus nevének kiírását megvalósító függvény
	 */
	public static void writeOutMethodName ()
	{
		final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		StackTraceElement caller = ste[2];
		
		System.out.println(repeat("\t",t)+"[:"+caller.getClassName()+"] "
				+ (caller.getMethodName().equals("<init>") ? "Constructor" : caller.getMethodName()));
		t++;
	}
	
	/**
	 * A paraméterül kapott stringet ismétli meg n-szer
	 * @param str: a szöveg
	 * @param n: ismétlés száma
	 * @return re: az előállított új szöveg
	 */
	private static String repeat(String str,int n)
	{
		String re = "";
		for(int i = 0; i < n; i++)
		{
			re += str;
		}
		return re;
	}
		
	/**
	 * Egy metódusból való visszatéréskor csökkenti a behúzás mértékét
	 */
	public static void returnFromMethod ()
	{
		t--;
	}
	
	/**
	 * Egy metódus, ami rossz bemenet esetén figyelmeztető üzenetet ír ki
	 */
	private static void printInputWarning ()
	{
		System.out.println(repeat("\t",t) + "Rossz bemenet, próbáld újra!");		
	}
	
	/**
	 * A paraméterben kapott kérdést kiírja stdout-ra és vár egy egész számot válaszként.
	 * Értelmetlen válasz esetén figyelmeztet, majd újra felteszi a kérdést.
	 * @param question - A kérdés
	 * @param unit - A mértékegység (pl.: másodperc, db)
	 * @return	A kérdésre adott válasz
	 */
	public static int getIntAnswer(String question, String unit)
	{
		boolean badAnswer = false;
		int re = 0;
		do
		{
			if(badAnswer)
				printInputWarning();
			
			System.out.print(repeat("\t",t) + question + " (" + unit + ") ");
			
			badAnswer = false;
			
			try {
				
				String str = br.readLine();
				re = Integer.parseInt(str);
				
				if (re < 0)
					badAnswer = true;
					
			} catch (IOException e) {
				System.out.println(repeat("\t",t) + "Something went wrong :(");
				badAnswer = true;
			}
			catch (NumberFormatException e) {
				badAnswer = true;
			}
			
		}while(badAnswer);
		
		return re;
	}
	
	/**
	 * A paraméterben kapott kérdést kiírja stdout-ra és vár egy választ.
	 * Értelmetlen válasz esetén figyelmeztet, majd újra felteszi a kérdést.
	 * @param s - A kérdés
	 * @return	A kérdésre adott válasz
	 */
	public static boolean getBooleanAnswer (String question)
	{
		System.out.print(repeat("\t", t) + question + "? (I/N): ");
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
		} catch (IOException e) {
			e.printStackTrace();
		}
		SkeletonHelper.printInputWarning();
		return getBooleanAnswer(question);
	}
	
	/**
	 * A paraméterben kapott kérdést kiírja stdout-ra. Válaszként egy számot vár.
	 * Ha nem számot kap, hibát jelez és újra felteszi a kérdést.
	 * @param question - A kérdés
	 * @param choices - A lehetséges válaszok, max. 4 db
	 * @return A válasz sorszáma
	 */
	public static int getMultipleChoiceAnswer (String question, String choices[])
	{
		System.out.print(repeat("\t", t) + question + " (");
		for (int i = 0; i < 4 && i < choices.length; i++)
		{
			System.out.print((i+1) + ": " + choices[i] + "   ");
		}
		System.out.print("\b\b\b)\n" + repeat("\t", t));
		try {
			String line = br.readLine();
			int c = Integer.parseInt(line);
			if (c > choices.length || c < 0 || c > 4)
				c = 0;
			if (c != 0)
			{
				return c;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			
		}
		SkeletonHelper.printInputWarning();
		return getMultipleChoiceAnswer(question, choices);
	}
	
	
	/**
	 * Megkérdezi, hogy a paraméterül kapott kódú billentyű le van-e nyomva.
	 * @param keyCode: billentyűkód
	 * @return: true -> le van nyomva (I)
	 * @return: false -> nincs lenyomva (N)
	 */
	public static boolean getKeyState(Integer keyCode)
	{
		return getBooleanAnswer("Le van nyomva a "+ controlKeyNames.get(keyCode) +" billentyű");
	}
}
