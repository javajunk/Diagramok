/**
 * A program main metódusát tartalmazó osztály.
 * Feladata a teljes program indítása.
 */

public class Program {

	public static void main(String[] args) {
		//SkeletonHelper.Init();
		//Game g = new Game();
		//g.Init();
		//g.Start();
		Game g = new Game();
		PrototypeHelper.Init(g);
		PrototypeHelper.CommandLoop();
		
		
		//System.out.println("A program futása befejeződöt :'(");
	}

}
