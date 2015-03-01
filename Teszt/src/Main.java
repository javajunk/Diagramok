import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

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
		//game.Start();
	}
	
	static Drawer game;
	JPanel renderTarget;
	public Main() {
		renderTarget = new JPanel();
		renderTarget.setBackground(Color.BLUE);

		game = new Drawer();
		game.setFocusable(true);
		this.add(game);
		game.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				game.Start();
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				game.Pause();
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
	}

}
