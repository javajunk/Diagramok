import java.awt.BorderLayout;
import java.io.UnsupportedEncodingException;

import javax.swing.JFrame;

/**
 * A program main metódusát tartalmazó osztály.
 * Feladata a teljes program indítása.
 */

public class Program {

	public static void main(String[] args) throws UnsupportedEncodingException {
		System.setOut(new java.io.PrintStream(System.out, true, "UTF8"));
		
		JFrame mainFrame = new JFrame();
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Game g = new Game();
		mainFrame.setSize(g.getPreferredSize());
		mainFrame.add(g,BorderLayout.CENTER);
		mainFrame.pack();
		mainFrame.setResizable(false);
		
		
		mainFrame.setVisible(true);
		g.setFocusable(true);
		g.Start();
	}

}
