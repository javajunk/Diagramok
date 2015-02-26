import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2481320567640194373L;
	public static void main(String[] args) {
		Main win = new Main();
		
		win.setSize(480, 800);
		win.setVisible(true);
		win.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		System.out.println("asd");
		game.run();
	}
	
	static Drawer game;
	JPanel renderTarget;
	public Main() {
		renderTarget = new JPanel();
		renderTarget.setBackground(Color.BLUE);
		
		game = new Drawer();
		game.setFocusable(true);
		this.add(game);
	}

}
