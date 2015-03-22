/**
 * @author Szendi Tam�s
 * @version 1.0
 * @created 19-m�rc.-2015 11:07:42
 */

public class Program {

	public static void main(String[] args) {
		SkeletonHelper.Init();
		Game g = new Game();
		g.Init();
		g.Start();
	}

}
